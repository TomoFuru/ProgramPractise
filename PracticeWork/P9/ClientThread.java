package Server;

import Database.*;
import Protocol.Protocol;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.*;

/**
 * This class creates a thread that manages a single client-server connection.
 *
 * @author Tomohiro Furuya
 * @version 24 Mar 2018
 */
class ClientThread implements Runnable {
    private static LoginDatabaseNULL dbUser;
    private static CreateNewUser dbCrUser;
    private static CreateNewMessage dbMsg;
    private static CheckMessage dbChkMsg;
    private static CreateNewConversation dbCon;

    private static Map<String, User> allUsers;
    private static Map<Integer, List<Message>> allMessages;
    private static Map<String, User> onlineUsers;

    private static InputStream in;
    private static OutputStream out;
    private static DataInputStream inData;
    private static DataOutputStream outData;
    private static BufferedReader readIn;
    private static PrintWriter printOut;

    private static User currentUser;

    private static Protocol protocol;
    private Socket clientSocket;

    private String output;

    private GetSecurityQuestion getSecurityQuestion;

    /**
     * Constructor method.
     *
     * @param clientSocket socket with which the thread connects to the server
     * @throws ClassNotFoundException 
     */
    ClientThread(Socket clientSocket) throws ClassNotFoundException, SQLException {
        this.clientSocket = clientSocket;

        dbUser = new LoginDatabaseNULL();
        dbMsg = new CreateNewMessage();
        onlineUsers = Server.getOnlineUsers();

        try {
        	dbCrUser = new CreateNewUser();
            dbChkMsg = new CheckMessage();
            dbCon = new CreateNewConversation();

            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
            inData = new DataInputStream(in);
            outData = new DataOutputStream(out);

            readIn = new BufferedReader(new InputStreamReader(in));
            printOut = new PrintWriter(outData, true);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO exception...");
            e.printStackTrace();
        }

        allUsers = dbCrUser.getAllUsers();
        allMessages = dbMsg.getAllMessages();

        protocol = new Protocol();

        getSecurityQuestion = new GetSecurityQuestion();
    }

    public synchronized PrintWriter getPrintOut() {
        return printOut;
    }

    private synchronized void signUp(String[] input) {
        if (input[0].equals("") || input[1].equals("") || input[2].equals("") ||
                input[3].equals("") || input[4].equals("") || input[5].equals("")
                || input[6].equals("") || input[7].equals("") || input[8].equals("") ||
                input[9].equals("") || input[10].equals("") || input[11].equals("")) {

            output = protocol.transmitStr(0 + "", "false_empty / " +
                    "You must fill in all fields before registering.");

        } else if (!input[1].equals(input[2])) {
            output = protocol.transmitStr(0 + "", "false_pmatch / Your passwords " +
                    "do not match.");

        } else if (input[1].length() > 8 || input[1].length() < 6) {
            output = protocol.transmitStr(0 + "", "false_plength / Your password " +
                    "must be between 6 and 8 characters long.");

        } else if (!CheckUsername.checkUsername(input[0])) {
            try {
                dbCrUser.insertUser(new Database.User(input[0], input[3],
                        input[4], input[5], input[6], getSecurityQuestion.getQid(input[7]), input[8],
                        input[1], protocol.strToBoolean(input[9]), protocol.strToBoolean(input[10]),
                        input[11]));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            output = protocol.transmitStr(0 + "", "true / Thank you for signing " +
                    "up.");

        } else {
            output = "false_uname / I'm sorry, somebody already has that username.";
        }
    }

    private synchronized void signIn(String[] input) {
        System.out.println("action == 1");
        if (dbUser.checkLogin(input[0], input[1])) {
            dbUser.setOnline(input[0]);

            currentUser = allUsers.get(input[0]);
            output = protocol.transmitStr(1 + "","true / Welcome back!");
        } else if (!CheckUsername.checkUsername(input[0])) {
            output = protocol.transmitStr(1 + "", "false / That username doesn't " +
                    "exist.");
        } else {
            output = protocol.transmitStr(1 + "", "Your username and/or password " +
                    "were incorrect.");
        }

        onlineUsers.put(input[0], allUsers.get(input[0]));
    }

    private synchronized void sendMessage(String[] input) throws SQLException {
        if (CheckUsername.checkUsername(input[0])) {
            if (!dbMsg.conversationExists(allUsers.get(input[0]).getUid(),
                    allUsers.get(input[0]).getUid())) {
                dbCon.insertConversation(new Conversation(
                        input[0] + " and " + input[1]));
            }

            dbMsg.sendMessage(new Message(
                    dbMsg.getConversationCid(allUsers.get(input[0]).getUid(),
                            allUsers.get(input[1]).getUid()),
                    input[0], input[1], allUsers.get(input[2]), allUsers.get(input[3]),
                    true, false));

            output = protocol.transmitStr(2 + "", "true / Message sent.");
        } else {
            output = protocol.transmitStr(2 + "", "false_lookup / Recipient " +
                    "not found.");
        }
    }

    private synchronized void receiveMessage(String[] input) throws SQLException {
        //Take the offset - assuming for now it is input[1] but this may change
        int i = Integer.parseInt(input[2]);

        if (allMessages.isEmpty() || allMessages.size() < i+1) {
            output = protocol.transmitStr(3 + "", "false / No new messages.");
        } else {
            output = protocol.messageToStrOffset(3 + "", i+1 + "",
                    dbChkMsg.getMessage(currentUser, i));
        }
    }

    private synchronized void getOnlineUsers(String[] input) {
        System.out.println("action == 4");
        if (allUsers.size() != 0) {
            StringBuilder sbOutput = new StringBuilder();
            sbOutput.append("4 / ");

            for (User u : allUsers.values()) {
                sbOutput.append(u.getUsername() + " / ");
            }

                                /* When a client hits this, call a method from here which is defined in the
                                GUI to change the view / the contents in the list
                                 */

            output = protocol.transmitStr(4 + "", sbOutput.toString());

        } else {
            output = protocol.transmitStr(4 + "", "false_empty / Nobody else " +
                    "is online right now!");
        }
    }

    private synchronized void signOut(String[] input) {
        dbUser.logout(input[0]);

        output = protocol.transmitStr(5 + "", "true / Successfully logged out. " +
                "See you soon!");

        onlineUsers.remove(input[0]);
    }

    private synchronized void getChatHistories(String[] input) {
        StringBuilder sbOutput = new StringBuilder();

        for (Message m : dbMsg.getAllMessages().get(allUsers.get(input[2]).getUid())) {
            if (m.getSender_uid() == Integer.parseInt(input[3])) {
                sbOutput.append(protocol.messageToStr(7 + "", m) + "\n");
            }
        }

        output = protocol.transmitStr(7 + "", sbOutput.toString());
    }

    private synchronized void viewProfile(String[] input) {
        User toView;

        if (input[0].equals("")) {
            if (currentUser != null) {
                toView = allUsers.get(currentUser.getUsername());
            } else {
                toView = null;
            }
        } else {
            toView = allUsers.get(input[0]);
        }

        String[] profileAttributes = new String[6];

        if (toView != null) {
            profileAttributes[0] = toView.getFirst_name();
            profileAttributes[1] = toView.getSurname();
            profileAttributes[2] = toView.getUsername();
            profileAttributes[3] = toView.getBirth_month();
            profileAttributes[4] = toView.getBirth_Year();
            profileAttributes[5] = toView.getLocation();
        } else {
            for (String s : profileAttributes) {
                s = "null";
            }
        }

        output = protocol.strArrToStr(8 + "", profileAttributes);
    }

    private synchronized void getConversation(String[] input) throws SQLException {
        if (!dbMsg.conversationExists(allUsers.get(input[0]).getUid(),
                allUsers.get(input[1]).getUid())) {
            dbCon.insertConversation(new Conversation(
                    input[0] + " and " + input[1]));
        }

        output = protocol.conversationToStr(9 + "",
                dbCon.getAllConversations().get(input[0] + " and " + input[1]));
    }

    private synchronized void forgotPassword(String[] input) {
        System.out.println("input0: " + input[0]);
        if (!CheckUsername.checkUsername(input[0])) {
            output = protocol.transmitStr(10 + "", "false_uname / That " +
                    "username doesn't exist.");
        } else {
            output = protocol.transmitStr(10 + "",
                    "true / " + getSecurityQuestion.getSecurityQuestion(
                            allUsers.get(input[0]).getqid()) + "");
        }
    }

    private synchronized void securityQuestion(String[] input) {
        output = protocol.transmitStr(11 + "", dbUser.securityQuestion(input[0]));
    }

    private synchronized void securityCheck(String[] input) {
        if (!dbUser.securityCheck(input[1], input[0])) {
            output = protocol.transmitStr(12 + "", "false_answer / That " +
                    "answer doesn't match our records.");
        } else {
            output = protocol.transmitStr(12 + "", "true / Set a " +
                    "new password:");
        }
    }

    private synchronized void resetPassword(String[] input) throws SQLException {
        try {
            ResetPassword.ResetPassword(input[0], input[1]);

            output = protocol.transmitStr(13 + "",
                    "true / Password successfully changed!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            output = protocol.transmitStr(13 + "", "false / Reset password failed.");
        }
    }

    /**
     * Run method.
     *
     * Commented-out sections use the list and map classes I created while I could not use the database.
     * They are still there as the database is still not entirely set up yet.
     */
    @Override
    public synchronized void run() {
        try {
            Protocol protocol = new Protocol();

            String inputStr;

            while(true) {
                try {
                    while ((inputStr = readIn.readLine()) != null) {
                        int action = protocol.clientAction(inputStr);
                        String[] input = protocol.strToStrArr(inputStr);
                        output = null;

                        //Sign up
                        if (action == 0) {
                        	signUp(input);
                        }
                     
                        //Sign in
                        if (action == 1) {
                            signIn(input);
                        }

                        //Send message
                        if (action == 2) {
                            sendMessage(input);
                        }

                        //Receive messages
                        if (action == 3) {
                            receiveMessage(input);
                        }

                        //Retrieve list of users currently online
                        if (action == 4) {
                            getOnlineUsers(input);
                        }

                        //Log out
                        if (action == 5) {
                            signOut(input);
                        }

                        //Chat histories
                        if (action == 7) {
                            getChatHistories(input);
                        }

                        //View a profile
                        if (action == 8) {
                            viewProfile(input);
                        }

                        //Start or return to a conversation with somebody
                        if (action == 9) {
                            getConversation(input);
                        }

                        //Forgot password
                        if (action == 10) {
                            System.out.println(input[0]);
                            forgotPassword(input);
                        }

                        //Security question
                        if (action == 11) {
                            securityQuestion(input);
                        }

                        //Security check
                        if (action == 12) {
                            securityCheck(input);
                        }

                        //Reset password
                        if (action == 13) {
                            resetPassword(input);
                        }

                        System.out.println("output: " + output);
                        printOut.println(output);

                        if (action == 1) {
                            viewProfile(input);
                        }

                        if (action == 1 || action == 5) {
                            getOnlineUsers(input);
                            Server.sendOnlineUsers();
                        }
                    }
                } finally {
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("IO Exception!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
