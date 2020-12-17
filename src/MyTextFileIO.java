import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * A class responsible for reading and writing text files. Used to write
 * projects and requirements to a XML file.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class MyTextFileIO
{
   /**
    * Writes the given string to a file with the given file name.
    *
    * @param fileName the name and path of the file to write to
    * @param str      the text string to write to the file
    * @throws FileNotFoundException if the file with fileName is not found
    */
   public void writeToFile(String fileName, String str) throws FileNotFoundException
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

