package myPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class TxtfiletoSecretMessage extends Main 
{

	public static Hashtable<String, String > codeToMessage = new Hashtable<String, String>();
	public static Hashtable<String, String > messageToCode = new Hashtable<String, String>();
	
	public static void main(String[] args) 
	{
		File file = new File("SecretCodeTest.txt");
		String path = file.getAbsolutePath();
		System.out.println(path);
	readFile("C:\\Users\\michaelj_00\\Desktop\\Secret_Code_Files\\SecretCodeTest.txt");	
	
	}
	
	public static void readFile(String fileName)
	{
		
		try
		{
			FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
			String fileReader;
		
			for(int i = 0; i <= 29; i++)
			{
				String key = " ";
				String value = " ";
				
				fileReader = br.readLine();
				
				 key = fileReader;
				
				fileReader = br.readLine();
				 value = fileReader;
				
				
				
				codeToMessage.put(key, value);
				messageToCode.put(value, key);
				
			}
			
			System.out.println(codeToMessage);
			System.out.println(messageToCode);
		}
		catch(IOException e)
		{
			System.out.println("something happened");
		}
		
		
	}

	
	
	
}
