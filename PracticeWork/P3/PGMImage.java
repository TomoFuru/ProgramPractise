
	import java.awt.image.BufferedImage;
import java.io.*;
	import java.util.Scanner;

	/**
	 * 
	 * @author Tomo
	 *
	 */
	
	public class PGMImage{
	    private int width;
	    private int height;
	    private int maxShade;
	    private String typeOfFile;
	    private short[][] pixels;

	    /**
	     *  @param filename The name of a file that contains an image in
	     *  pgm format of type P2.
	     *
	     */
	    public PGMImage(String filename) {
	        // try since the file may not exist.
	        try {
	            // we read from the scanner s which is linked to the file filename.
	            Scanner s = new Scanner(new File(filename));

	            /* The field variables are assigned by reading in from a
	               file. The file should start with something like
	               P2
	               150 176
	               255

	               where P2 is the file type, 150 the width of the image, 176
	               the height, and 255 the maximal grey value. Then follow
	               150*176 grey values between 0 and 255.
	            */
	            
	            // We read the initial element that is in our case "P2"
	            typeOfFile = s.next();
	            // Next we read the width, the height, and the maxShade.
	            width = s.nextInt();
	            height = s.nextInt();
	            maxShade = s.nextInt();
	            //We initialize and read in the different pixels.
	            pixels = new short[height][width];
	            
	            for (int i=0; i<height; i++){
	                for (int j=0; j<width; j++) {
	                    pixels[i][j] = s.nextShort();
	                }
	            }
	            // We finished reading and close the scanner s.
	            s.close();
	        }
	        catch (IOException e){
	            //If the file is not found, an error message is printed,
	            //and an empty image is created.
	            System.out.println("File not found.");

	            typeOfFile = "P2";
	            width = 0;
	            height = 0;
	            maxShade = 0;
	            pixels = new short[width][height];
	        }
	    }

	    /**
	     *  @return The width of the image.
	     */
	    public int getWidth(){
	        return width;
	    }

	    /**
	     *  @return The height of the image.
	     */
	    public int getHeight(){
	        return height;
	    }
	    
	    /**
	     *  @return The maximal grey value of the image.
	     */
	    public int getMaxShade(){
	        return maxShade;
	    }

	    /**
	     *  @return The file type of the image.
	     */
	    public String getTypeOfFile(){
	        return typeOfFile;
	    }

	    /**
	     *  @return The matrix representing the pixels of the image.
	     */
	    public short[][] getPixels(){
	    
	    
	        return pixels;
	    }
	    	 /**
	     *  The method crops the left upper half of an image.
	     *  @param filename The filename of the file in which the cropped
	     *  image should be saved.
	     */
	    public void crop (String filename){
		try {
		    BufferedWriter out = 
			new BufferedWriter(new FileWriter(filename));
		    // We write the file type to out.
		    out.write(getTypeOfFile() + "\n");

		    // We write the dimensions to out.
		    out.write((getWidth()/2) + " " + (getHeight()/2) +"\n");
		    
		    // We write maximal number.
		    out.write(getMaxShade() + "\n");
		    
		    byte counter = 0;
		    for (int i=0; i<getHeight()/2; i++){
			for (int j=0; j<getWidth()/2; j++){
			    out.write(getPixels()[i][j] + " ");
			    counter++;
			    if (counter == 15){		 
	                        out.write("\n");
	                        counter = 0;
	                    }
			}
		    }
		    out.write("\n");
		    // We close the file.
		    out.close();
		}
		catch (IOException e){
	            //Errors are caught.
	            System.out.println("File not found.");
	        }
	    }

	    public int[][] quarter(String filename){
	    	  int [][] newArray = new int[getHeight()/2][getWidth()/2];
	    	 
            try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(filename));
                    out.write(getTypeOfFile() + "\n");

                    out.write((getWidth()/2) + " " + (getHeight()/2) +"\n");

                    out.write(getMaxShade() + "\n");

                    byte counter = 0;

          for (int i=0; i<getHeight()/2; i++){
               for (int j=0; j<getWidth()/2; j++){
                    pixels[i][j] = getPixels()[i][j];
                   newArray[i][j] = (int) Math.round(((pixels[2*i][2*j] + pixels[2*i][2*j+1] + pixels[2*i+1][2*j] + pixels[2*i+1][2*j+1]) / 4.0));
                    System.out.print(newArray[i][j]);
                    out.write(newArray[i][j] + " ");
                     counter++;
                    if (counter == getWidth()/2) {
                      out.write("\n");
                     counter = 0;
                   }
                  }
             }
             out.write("\n");
             out.close();
            }
            catch (IOException e) {
                         throw new IllegalArgumentException(" ");
            }
            return newArray;
  }

	    public int[][] rotate(String filename){
            try {
                BufferedWriter out =
                         new BufferedWriter(new FileWriter(filename));
                out.write(getTypeOfFile() + "\n");

                out.write((getHeight()) + " " + (getWidth()) +"\n");
                
                out.write(getMaxShade() + "\n");
                
                int[][] rotaArray = new int[getWidth()][getHeight()];
                
                int counter = 0;
                
                for(int i = 0; i < width; i++) {
                         for(int j = 0; j < height; j++) {
                                       rotaArray[i][j] = pixels[height-j-1][i];
                                       out.write(rotaArray[i][j] + " ");
                                       counter ++;
                                                     if(counter == 15) {
                                                                  out.write("\n");
                                                                                counter = 0;
                                                     }
                                       }
                         }
                out.write("\n");
                out.close();
                return rotaArray;
            }
            catch (IOException e) {
            throw new IllegalArgumentException(" ");
            }
  }
	    	    
				    
	    
	     	public int[][] bw(String filename){
	              try {
	                           BufferedWriter out =
	                                                      new BufferedWriter(new FileWriter(filename));
	 
	                           out.write(getTypeOfFile() + "\n");
	 
	                           out.write((getWidth()) + " " + (getHeight()) +"\n");
	                          
	                           out.write(1 + "\n");
	 
	                           int totalPixels = 0;
	                           double total = 0;
	                           double mean = 0;
	                           int counter = 0;
	 
	                           for(int i = 0; i < getHeight(); i++) {
	                                         for(int j = 0; j <getWidth(); j++) {
	                                                      total += pixels[i][j];
	                                                      totalPixels+=1;
	                                         }
	                           }
	                          
	                           mean = total/totalPixels;
	                          
	                           int[][] bwArray = new int[getHeight()][getWidth()];
	 
	                           for(int i = 0; i < getHeight(); i++) {
	                                         for(int j = 0; j <getWidth(); j++) {
	                                                      if(pixels[i][j]>mean) {
	                                                                    bwArray[i][j] = 0;
	                                                      } else if (bwArray[i][j]<=mean) {
	                                                                    bwArray[i][j] = 1;
	                                                      }
	                                                      out.write(bwArray[i][j] + " ");
	                                                      counter++;
	                                                      if(counter == getWidth()) {
	                                                                    out.write("\n");
	                                                                    counter = 0;
	                                                      }
	                                         }
	                           }
	                           out.write("\n");
	                           out.close();
	                           return bwArray;
	              }
	              catch (IOException e) {
	                           throw new IllegalArgumentException(" ");
	              }
	    }
		
		public static void main(String[] args) {
	        PGMImage cs = new PGMImage("ComputerScience.pgm");
	        cs.quarter("ComputerScienceQuater.pgm");
	        cs.quarter("ComputerSciencebw.pgm");
	        cs.rotate("ComputerScienceRotate.pgm");
	        cs.crop("ComputerScienceCrop.pgm");
	    }
	}

	   // if(size /= 2) {
			//size /= 2;
			//median = list.get(size
				// chris sum += pixels[width][height];
	  //  for (int i=0; i<getHeight()/2; i++){
	//	for (int j=0; j<getWidth()/2; j++)
	// if(getHeight /= 2) {
	    /**	}else if (size % 2 != 0;)
		
		for (int i=0; i< pixels[Height].length-1; i = i+2) {
			for (int j=0; j< pixels[Width].length-1; j = j+2) {
		        
	 
	    	sum = (int) (a[i][j] + a[i][j+1]+ a[i+1][j] + a[i+1][j+1]);
	          //count++;
	    }
	}
	        ave = sum / 4;
	        
	    return ave;	;
	// if(getMaxShade() == 1) {
					//   sumblack += pixels[i][j];
					  // counter1++;
					  // if(getMaxShade() ==0) {
						//   sumwhite += pixels[i][j];
						  // counter2++;
					 //  }
				  // }
		          //          }
		//		}
	}
    // We write the file type to out.
}
/*
* An example.
*/