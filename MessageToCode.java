package myPackage;



public class MessageToCode extends Main
{

	private static boolean whileflag = false;
	private static String Message = " ";
	
	public static void main(String[] args)
	{
		readFileAndCreateDecoders("Default.txt");
		translate("j19j22j15j12j");
	}
	
	
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
		//createDecoder();
		
		
		
		
		
			
			
					
						
						Message = Message + Main.messageToCode.get( input);
						
						
					
					
				
				
				
			
			System.out.println(Message);
		return Message;
	}
			
			
		
		
		
		
		
		
		
	
	
	
	
	
}
