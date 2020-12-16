import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MyTextFileIO
{
   // Writes the given string to a file with the given file name
   public void writeToFile(String fileName, String str) throws FileNotFoundException
   {
      write(fileName, str);
   }
   
   // writeToFile and appendToFile are almost identical - only the boolean in the constructor
   // of the FileOutputStream differs. So I made this private method that both methods call
   private void write(String fileName, String str) throws FileNotFoundException
   {
      PrintWriter writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName);
         writeToFile = new PrintWriter(fileOutStream);
         writeToFile.println(str);
      }
      finally
      {
         if (writeToFile != null)
         {
            writeToFile.close();
         }
      }
   }
}
