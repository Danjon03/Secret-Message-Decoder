package myPackage;


import java.io.File;
import java.util.Hashtable;

public class TranslateMessage extends Main
{
	
	
	public static String[] txtFiles = new String[10];
	
	public static File folder = new File("C:\\Users\\michaelj_00\\Desktop\\Eclipse\\something\\Secret Message Decoder");
	public static File[] listOfFiles = folder.listFiles();
	
	
	public static String numberOfTextFilesInAFolder(String text)
	{
		int numberOfTxtFiles = 0;
		
		 
		
		
		
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			  if (listOfFiles[i].isFile()) 
			  {
				  if(listOfFiles[i].getName().substring(listOfFiles[i].getName().length() - 3).equals("txt"))
				  {
					  System.out.println("File " + listOfFiles[i].getName());
					  
					  txtFiles[numberOfTxtFiles] = listOfFiles[i].getName();
					  numberOfTxtFiles++;
					  
				  } 
			  }
		}
		
		
		
		if(numberOfTxtFiles > 1)
		{
			String ListOfFilesYouCanUse = "These are the files that I have access to. Type in which one you want to use.";
			 
			for(String i: txtFiles)
			{
			
				if(i != null)
				{
				ListOfFilesYouCanUse = ListOfFilesYouCanUse + "\n" + i;
				
				}			
			}
			return ListOfFilesYouCanUse;
		}
		else
		{
			readFileAndCreateDecoders("Default.txt");
			
			
			
			encryptFlag = true;
			return "Please type in the message that you wish to encrypt.";

		}
		
			}
	
	
	
	
	public static String returnCodedMessage(String message)
	{
		
		int x = 0;
		int y = 1;
		
		boolean flag = true;
		
		String secretMessage = "j";
			
			while(flag == true)
			{
				try
				{
					
						if(x >= 2)
						{
						secretMessage = secretMessage + codeToMessage.get( message.substring(x, y)) +"j";
						
						}
					
					x++;
					y++;
				}
				catch( Exception e)
				{
					flag = false;
					
					
				}
				
				
			}
			System.out.println(secretMessage);
			encryptFlag = false;
		return secretMessage;
	}
	
}
