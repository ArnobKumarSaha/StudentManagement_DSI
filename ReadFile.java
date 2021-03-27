
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {   
    private ArrayList<String> lines = new ArrayList<String>();

    public ArrayList<String> readFile(String path ){
    try {
      File myObj = new File(path);
      Scanner myReader = new Scanner(myObj);  
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
        lines.add(data);
      }
      myReader.close();
      return lines;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
    return new ArrayList<String>();
  }  
} 
