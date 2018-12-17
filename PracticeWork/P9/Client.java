package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import Protocol.*;
import Server.*;
import Database.*;

/**
 * 
 * @author Tomohiro Furuya 
 * @version 8 Mar 2018
 */
public class Client extends Observable{
	 //Network variables
    private Socket clientSocket;
    private String host ;
    private Integer port ;
    private Connection connection;

  //I/O variables
    private DataOutputStream toServer;
    private BufferedReader fromServer;
    private String response;
    private Protocol protocol;
	
	  //variable for client
       private boolean onlinestatus;
        private int id;
        private String username;
	    private String password1;
	    private String password2;
	    private String newPassword1;
	    private String newPassword2;
	    private String first_name;
	    private String surname;
	    private boolean gender;//true is female, false is male
	    private String birthMonth;
	    private int birthYear;
	    private String location;
	    private String interest1;
	    private String interest2;
	    private String seculity_question;
	    private String security_answer;
	    private String message;
	    private String currentUser;
	 //private int birthMonth;

	    private static Map<String, User> userList;
	    private Map<String ,List<Message>> messageLog;
	    public Integer offset = -1;	
	    private String User1;

	    
	    /**
	     * Requires host and port arguments.
	     * Possible solution is to initialise all GUI classes in GUI_Main inside the constructor, so that the
	     * Client can be initialised at the same time *with* host and port variables.
	     * Will try this tomorrow.
	     */
		public Client(String host, int port) {
			super();
			this.host = host;
			this.port = port;
			this.protocol = new Protocol();
			
			try {
				clientSocket = new Socket(host, port);
				toServer = new DataOutputStream(clientSocket.getOutputStream());
				fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				
				//setChanged();
				//notifyObserver();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public String getCurrentUser() {
	    	return currentUser;
		}
/**
		 public void upload() {
		    	return order;
		    }
		*/
		public void setCurrentUser(String newCurrentUser) {
			currentUser = newCurrentUser;
		}
	    
	    /*
		 * 		Read a line from server and unpack it using SimpleProtocol
		 */
		public String[] getOrder(){
			try {
				String[] order = protocol.strToStrArr(fromServer.readLine());
				return order;
			} catch (IOException e) {
				e.printStackTrace();
			}
		//	return null;
		}
		
	    public void signUp(boolean onlinestatus,  String username, String password1,String password2, String first_name,
							   String surname,int birthYear , String location, 
	    		                      String security_question,String security_answer, boolean gender,String birthMonth){

			 String[] newUser = {username, password1,password2 ,first_name,
					 surname,birthYear + "", location, security_question, security_answer , protocol.booleanToStr(false),
					 protocol.booleanToStr(gender), birthMonth};

                      String string = protocol.strArrToStr(0 + "", newUser);

			try {
				toServer.writeBytes(string + "\n");
				String[] order = this.getOrder();
				setChanged();
				notifyObservers();
				// order;
				//return order;
			} catch (IOException e) {
				e.printStackTrace();
			//	return null;
			}
		} 
	  /**
	    public String[] sendtoGUI{
	    	return order;
	    }
	   */
	    
	    public void signIn(String username, String password){

			String[] loginDetails = {username, password};
			String string = protocol.strArrToStr(1 + "", loginDetails);

			try {
				toServer.writeBytes(string + "\n");
				System.out.println(string);
				String[] order = this.getOrder();

				if (order[0].equals("true")) {
					setCurrentUser(username);
					System.out.println("username: " + username);
					System.out.println("currentUser0: " + currentUser);
				}
				//String[] order = this.getOrder();
				setChanged();
				notifyObservers();

				
			} catch (IOException e) {
				e.printStackTrace();
				//return null;
			}
			
		}
	    /**
	    public String[] sendtoGUI{
	    	return order;
	    }
	    */
		/*
		 * 		Send a message to server.
		 */
		
		public void send_message(String content, String recipient, String sender){
			String string = null;

			try {
				CreateNewConversation getCon = new CreateNewConversation();

				string = protocol.messageToStr(2 + "", new Message(
						content, new SimpleDateFormat("dd.mm.yyyy.hh.mm").format(new Date()),
						sender, recipient, true, false));

				toServer.writeBytes("\n" + username + ":" + string + "\n");
				//setChanged();
				//notifyObservers();
				
			} catch (IOException e) {
				System.out.println("Unable to send message.");
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		/**
		public String[] sendtoGUI{
	    	return order;
	    }
		*/
	    /*
		 * 		Send get-message request to server
		 */
	    
		public void  receiveMessage(){
			String string = protocol.transmitStr(3 + "", this.offset.toString());
			
			try {
				toServer.writeBytes("\n" + username + ":" + string + "\n");
				
				;
				String[] order = this.getOrder();
				setChanged();
				notifyObservers();
			//	return order;
			} catch (IOException e) {
				System.out.println("Unable to receive Massage");
				e.printStackTrace();
			}

			//return null;
		}
		/**
		public String[] sendtoGUI{
	    	return order;
	    }
		*/
    public  void retrieveUserList() {

			System.out.println("retrieveUserList()");
        String retrieveUsers = protocol.transmitStr(4 + "", "");

        try {
            toServer.writeBytes(retrieveUsers + "\n");
            String[] order = this.getOrder();
            setChanged();
			notifyObservers();
            //return 
            		protocol.userList(4 + "", retrieveUsers);
            		
        } catch (IOException e) {
            e.printStackTrace();
            //return null;
        }

    }
    /**
    public String[] sendtoGUI{
    	return order;
    }
	*/	
		/**
		 * 
		 * Retrieve list of users currently online
		 * @return List that is consist of users who are online
		 */
		/**
	

		
	public List<User> retriveUserList() {
	
		String retrieveUsers = protocol.transmitStr(4 + "", "");

		try {
			toServer.writeBytes(string + "\n");
			String order = this.getOrder();
			return protocol.userList(4 + "", onlineUsers);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	
}

		/*
		//log out from chat
		public String[] logOut(boolean onlinestatus, String username) {
			String[] logoutDetails = {false, username};
			String string = protocol.strArrToStr(5 + "", logoutDetails);

			try {
				toServer.writeBytes(string + "\n");
				String[] order = this.getOrder();

				return order;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		//time out 
		public void timeOut() {
			String string = username;
			try {
				toServer.writeBytes("\n" + string + "\n");
				System.out.println("You have been inactive for 30 minutes."+"\n"+ "Please log back in to continue messaging");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//View profile 
		public String[] viewProfile(String username)
	    		  {
	    		        

                      String string = protocol.transmitStr(8 + "", username);     
                      
			try {
				toServer.writeBytes(string + "\n");
				String[] order = this.getOrder();

				return order;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
                                           }
		//View profile 
		public String[] myProfile(String username)
	    		  {
	    		      String string = protocol.transmitStr(number + "", username);     
                      
			try {
				toServer.writeBytes(string + "\n");
				String[] order = this.getOrder();

				return order;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
                                           }
		//forgetpassword
		/*
		public String[] wrongPassword(String username, String password) {
			String[] loginDetails = {username, password};
			String string = protocol.strArrToStr(10 + "", loginDetails);

			try {
				toServer.writeBytes(string + "\n");
				//if(!string.equals(protocol.strArrToStr(1 + "", loginDetails))) {
				String[] order[2] = this.getOrder();
			//	String[] order = this.getOrder()[2];
    

				return order;
				} else {
				String[] order = this.getOrder()[1];
				return order
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			
		}
		*/
		
		/**
		 * public String[] resetPassword( String username, String newPassword1, String newPassword2){

			 String[] newPassword = {username, newPassword1,newPpassword2 };

                      String string = protocol.strArrToStr(numberOfServer + "", newPassword);

			try {
				toServer.writeBytes(string + "\n");
				String[] order = this.getOrder();

				return order;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		} 
		 */

		public void resetPassword( String username, String newPassword1, String newPassword2) {

			String[] newPassword = {username, newPassword1, newPassword2};

			String string = protocol.strArrToStr(13 + "", newPassword);

			try {
				toServer.writeBytes(string + "\n");
				String[] order = this.getOrder();

				for (String s : order) {
					System.out.println(s);
				}
				setChanged();
				notifyObservers();
				//return order;
				
			} catch (IOException e) {
				e.printStackTrace();
				//return null;
			}
		}
		/**
		 * 
		 
		public String[] sendtoGUI{
	    	return order;
	    }
		*/
		public void forgotPassword(String username) {
			String string = protocol.transmitStr(10 + "", username);

			try {
				toServer.writeBytes(string + "\n");
				String[] order = this.getOrder();
				setChanged();
				notifyObservers();
			//	return order;
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			//return null;
		}
		/**
		public String[] sendtoGUI{
	    	return order;
	    }
		*/
		//sequrity check question (incompleted)
		 public void securityQuestion(String username, String security_answer){
				try {
					CreateNewUser c = new CreateNewUser();

					String[] loginDetails2 = {username,
							c.getAllUsers().get(username).getqid()+"", security_answer };

					String string = protocol.strArrToStr(12 + "", loginDetails2);

					toServer.writeBytes(string + "\n");
					String[] order = this.getOrder();
					setChanged();
					notifyObservers();
					/*
					if(order[1].equals("true") && order[2].equals("true")){
						System.out.println("sign in success! Welcome back!");
					}else{
						System.out.println("Your username and/or password was incorrect.");
					}
					*/

				//	return order;
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			// return null;
			}
		 /**
		  * 
		  
		 public String[] sendtoGUI{
		    	return order;
		    }
		 */
		 
		 public void wrongPassword(String username, String password) {
				String[] loginDetails = {username, password};
				String string = protocol.strArrToStr(10 + "", loginDetails);

				try {
					toServer.writeBytes(string + "\n");
					//if(!string.equals(protocol.strArrToStr(1 + "", loginDetails))) {
					String[] order = this.getOrder();
				//	String[] order = this.getOrder()[2];
	    
					setChanged();
					notifyObservers();
				//	return order;
					
				} catch (IOException e) {
					e.printStackTrace();
					//return null;
				}
				
			}

	//View profile
	public void myProfile(String username) {
			System.out.println("myProfile()");
		String string = protocol.transmitStr(8 + "", username);

		try {
			toServer.writeBytes(string + "\n");
			String[] order = this.getOrder();
			setChanged();
			notifyObservers();
			//return order;
			
		} catch (IOException e) {
			e.printStackTrace();
		//	return null;
		}
	}

	//View user's own profile
	public void myProfile() {
			String string = protocol.transmitStr(8 + "", "");

			try {
				toServer.writeBytes(string + "\n");
				String[] order = this.getOrder();
				//return order;
				setChanged();
				notifyObservers();
			} catch (IOException e) {
				e.printStackTrace();
			}

			//return null;
	}
		//
		//public 

		//sequrity check
	/*
		public boolean securityCheck(String username, String password) {
			
		}
		*/


		public void setHost(String host) {
			this.host = host;
			
		}

		public void setPort(Integer port) {
			this.port = port;
			;
		}
		
		 /**
		  *  Start socket
		  */
		public void start(){
			try {
				clientSocket = new Socket(this.host, this.port);
				toServer = new DataOutputStream(clientSocket.getOutputStream());
				fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			//setChanged();
			//notifyObservers();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * 		Close socket
		 */
		public void finish(){
			try {
				clientSocket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
