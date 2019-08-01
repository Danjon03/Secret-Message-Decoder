package myPackage;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main  
{
	private static boolean whileflag = false;
	private static String Message = " ";
	public static Hashtable<String, String > codeToMessage = new Hashtable<String, String>();
	public static Hashtable<String, String > messageToCode = new Hashtable<String, String>();
	
	public static String[] letters = new String[27];
	
	private static JFrame mainFrame = new JFrame();
	
	private static JPanel panel = new JPanel();
	
	protected static JTextArea output = new JTextArea();
	
	public static JTextArea input = new JTextArea();
	private static int lettersIncrementer = 0;
	
	public static boolean encryptFlag = false;

	public static KeyAdapter normal = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
            	
            	InputParser commandTranslator = new InputParser(input.getText());
            	
            	
            		output.setText(commandTranslator.determineResponse(input.getText()));
            	
            	
            	input.setText(" ");
            }
        
       
        
        }
 
	};
	
	public static KeyAdapter createFile = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) 
        {
        	
        	if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
        		if(lettersIncrementer > 0)
            	{
            		output.setText(letters[lettersIncrementer]);
            		
            	}
            	
        		
        		lettersIncrementer++;
        		
        		
        		
        		if(lettersIncrementer == letters.length)
            	{
        			System.out.println("this happens");
        			InputParser.createFileflag = true;
        			input.removeKeyListener(createFile);
        			input.addKeyListener(normal);
        			output.setText("You have created a new secret code. This is the filepath\n"
        					+ "(need to find a way to display filepath)");
            	}
            	else
            	{
		        	setupArray();
		        	
		        	
		        	
		        	
		        		try{	
				        	FileWriter fileWriter = new FileWriter("test.txt", true);
					        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				        	
					        bufferedWriter.write(letters[lettersIncrementer]);
							bufferedWriter.newLine();
							
							bufferedWriter.write(input.getText());
							bufferedWriter.newLine();
							
							bufferedWriter.close();
			        	}
			        	catch(IOException x)
			        	{
			        		System.out.println("probably something wrong with the file name.");
			        	}
		        		
		        		input.setText("");
            
        
            	}
            }
        }
	};   

	public static void main(String[] args) 
	{
	
		setup();
		
	}
		
	public static boolean isExistingTextFile(String fileName)
	{
		boolean flag = false;
		
		System.out.println("into isExistingTextFile if");
		if(fileName.substring(fileName.length() - 3).equals("txt"))
		{
			System.out.println(TranslateMessage.listOfFiles + "Hello");
			for(File i: TranslateMessage.listOfFiles)
			{
				if(fileName.contains(i.getName()))
				{
					readFileAndCreateDecoders(i.getName());
					flag = true;
				}
				
			}
			
				
			
		}
		
			System.out.println(flag);
			return flag;
		
		
	}

	public static void setup()
	{
		mainFrame.setSize(800, 800);
		mainFrame.setVisible(true);
		mainFrame.setLocation(800, 200);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel.setSize(800, 200);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		mainFrame.add(panel);
		
	
		output.setSize(700, 500);
		output.setLocation(50, 0);
		output.setEditable(false);
		output.setVisible(true);
		panel.add(output);
		output.setText("Type a command in the text box below or press H for a list of commands");
		
		input.setSize(700, 200);
		input.setLocation(50, 550);
		input.setEditable(true);
		input.setVisible(true);
		input.setLineWrap(true);
		input.setCaretPosition(0);
		panel.add(input);
		
		input.addKeyListener(normal);
		
		
		System.out.println("finished setup");
		
	}
	
	public static void readFileAndCreateDecoders(String fileName)
	{
		
		try
		{
			FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
			String fileReader;
		
			for(int i = 0; i <= 30; i++)
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
			System.out.println(e);
		}
		
		
	}
	
	// The Following Code refers to creating files (This portion is faulty and needs to be either removed or fixed
	//It's call section in InputParser will be commented out)
	public static void createFile() 
	{
		
		try
		{
		 File file = new File("test.txt");
	        FileWriter w = new FileWriter("test.txt");
	    PrintWriter    writer = new PrintWriter(w);		
	    System.out.print(file.getAbsolutePath());
		}
		catch(IOException e)
		{
			
		}
		
		System.out.println("initial message created.");
		
		input.removeKeyListener(normal);
		input.addKeyListener(createFile);
		
		
		
		
		
		
	}
	public static void setupArray()
	{
		letters[0] = "a";
		letters[1] = "b";
		letters[2] = "c";
		letters[3] = "d";
		letters[4] = "e";
		letters[5] = "f";
		letters[6] = "g";
		letters[7] = "h";
		letters[8] = "i";
		letters[9] = "j";
		letters[10] = "k";
		letters[11] = "l";
		letters[12] = "m";
		letters[13] = "n";
		letters[14] = "o";
		letters[15] = "p";
		letters[16] = "q";
		letters[17] = "r";
		letters[18] = "s";
		letters[19] = "t";
		letters[20] = "u";
		letters[21] = "v";
		letters[22] = "w";
		letters[23] = "x";
		letters[24] = "y";
		letters[25] = "z";
	
	
		
		
	
	}
	
	//The Following code Refers to converting messages that are in encrypted form to English
	public static String translate(String message)
	{
		
		
			int x = 2;
			int y = 3;
			
			while (whileflag == false)
			{
				
				try
				{
					
					if(message.substring(x, y).startsWith("j"))
					{
						
						x++;
						y++;
					}
					
				else if(message.substring(x, y).endsWith("j") )
				{
					
					
					decode(message.substring(x, y - 1));
					
					
					
				
					x = y;
					y++;
					
					
				}
				else if(message.substring(x, y) == null)
				{
					
					x++;
					y++;
				}
				else
				{
					
					y++;
					
				}
				
				
				
				}
				catch( Exception e)
				{
					whileflag = true;
					
					
				}
			
			
			
			
			
			}
			
			return Message;
			
	}
			
	public static String decode(String input)
	{	
		
		System.out.println(input);
			
		if(input.equals("31"))
		{
			
			Message = Message + " ";
		}
		else
		{
			Message = Message + messageToCode.get( input);
		}
		return Message;
	}
		
}
