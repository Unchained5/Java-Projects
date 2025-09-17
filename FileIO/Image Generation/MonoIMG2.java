import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors
import java.io.FileWriter;

/**
* Poorly written test code that generates an image according to specifications.
*/
public class CreateFile {
  public static void main(String[] args) {
	  int width = 1920;
	  int height = 1080;
	  String binImageData = "";
    CreateFile.createPBMFile(1);
	String[][] bitmap = new String[width][height];
	StringBuilder sb = new StringBuilder(width * height);
	for (int j = 0; j < height; j++) {
		for (int i = 0; i < width; i++) {
			if (i > 500 && i < 1000 && j > 700 && j < 1200) {
				bitmap[i][j] = "1";
				sb.append(bitmap[i][j]);
			}
			else {
				bitmap[i][j] = "0";
				sb.append(bitmap[i][j]);
			}
		}
	}
	binImageData = sb.toString();
	try (FileWriter writer = new FileWriter("IMG1.pbm")) 
        {
            
            writer.write("P1\n" + width + "\s" + height + "\n" + binImageData);

            System.out.println("Data written to the file successfully.");
        
        } 
     
      	catch (IOException e) {
            System.out.println("An error occurred while writing" + " to the file: " + e.getMessage());
        }
  }
  
 
  
  public static void createPBMFile(int iteration) {
	try {
      File myObj = new File("IMG" + iteration + ".pbm"); // Create File object
      if (myObj.createNewFile()) {           // Try to create the file
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace(); // Print error details
    }
  }
}

public class BitMap {
	private final int width;
	private final int height;
	private String[][] bitMap;
	
	public BitMap(int w, int h) {
		this.width = w;
		this.height = h;
		this.bitMap = String[this.width][this.height];
	}
}
