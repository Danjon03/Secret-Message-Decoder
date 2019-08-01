package myPackage;

import java.io.IOException;

public class InputParser extends Main 
{
	static boolean translateMessageFlag = false;
	static boolean createFileflag = true;
	
	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	private String text;
	
	
	public InputParser(String Text)
	{
		Text = text;
	}
	
	
	public String determineResponse(String text)
	{
		String returnStatement = "base value";
		
		//help
		if(text.equals("h") || text.equals("H"))
		{
			returnStatement = "these are all commands you can use"
					+ "\ndecode message"
					+ "\nCreate new secret code"
					+ "\nencrypt a message";
		}
		
		//encrypt a message
		else if( text.contains("encrypt") || text.contains("Encrypt"))
		{
			returnStatement = TranslateMessage.numberOfTextFilesInAFolder(Main.input.getText());
			
		}
		
		 
		//create a secret new code
		/*
		else if(text.contains("create") || text.contains("Create"))
		{
			
				createFile();
				createFileflag = false;
				returnStatement ="To create a secret code, you will be given a letter. "
						+ "\nYou will then type in the character that you want to stand in place of that letter."
						+ "\nWe will start with A.";
		}
		*/
		else if(text.contains("translate") || text.contains("Translate"))
		{
			returnStatement = "Type in the message that you wish to translate";
			readFileAndCreateDecoders("Default.txt");
			translateMessageFlag = true;
		}
		else if(translateMessageFlag == true)
		{
			returnStatement = translate(text);
			translateMessageFlag = false;
		}
		else if(encryptFlag == true)
		{
		returnStatement = TranslateMessage.returnCodedMessage(Main.input.getText());
		encryptFlag = false;
		}	
		else if(isExistingTextFile(text) == true)
		{
			
			
			returnStatement = "Type in the message that you wish to encrypt";
			encryptFlag = true;
		}
		else if(isExistingTextFile(text) == false)
		{
			returnStatement = "That is not a real file. Please try again.";
		}
		// anything else
		else
		{
			returnStatement = "Try entering h to get a list of commands I can use";
		}
		
		
		
		
		return returnStatement;
		
		}
	
	
	
	
	
	
	
	
}
