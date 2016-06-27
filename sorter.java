import java.io.*;
import java.util.Scanner;
//import java.nio.file.spi.FileTypeDetector

public class Sorter
{
  String keyword;
  String fileType;
  ArrayList<String> types;
  File folder;
  File newFolder;

  public static void main(String[] args)
  {
    folder=new File(System.getProperty("user.dir"));
    types= new ArrayList<String>();
    Scanner sc = new Scanner(System.in);
    System.out.print(" Keyword: ");
    keyword = sc.next();
    System.out.print("Want specific files? (Y/N) ");
    if (sc.next().toLowerCase().equals("Y"))
    {
      System.out.print("File type: ");
      fileType=sc.next();
      while (fileType!="\n")
      {
        types.add(fileType);
        fileType=sc.next();
      }
    }
    fileType = NULL;
    newFolder = new File(System.getProperty("user.dir")+ "/" + keyword).mkdirs();






  }
  public static void sortFile(File fileEntry) throws IOException
  {
    //try
    //{

    	   if(fileEntry.renameTo(System.getProperty("user.dir") + "/" + newFolder.getName() + "/" + fileEntry.getName())))
         {
    		     System.out.println("File is moved successful!");
    	   }
         else
         {
    		     System.out.println("File is failed to move!");
    	   }

    	//}
      //catch(Exception e)
      //{
    		//e.printStackTrace();
    	//}
  }
  public static void recurseDirectory(final File folder) throws IOException
  {
    String fileName = "";
    String fileExtension;
    for (final File fileEntry : folder.listFiles())
    {
      if(fileEntry.isDirectory())
      {
        recurseDirectory(fileEntry);
      }
      else
      {
        if (fileEntry.isFile())
        {
          fileName=fileEntry.getName();
          fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length()).toLowerCase();
          if (fileName.contains(keyword))
          {
            for (String type : types)
            {
              if (fileExtension.equals(types))
              {
                sortFile(fileEntry);
                break;
              }
            }
          }
        }
      }
    }
  }
}
