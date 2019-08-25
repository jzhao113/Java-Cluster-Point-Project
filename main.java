import java.io.*;

public class main {
	
	public static void main(String[]args) throws IOException
	{
		//there should only be two inputs
		if(args.length!=2)
		{
			System.out.println("Not two arguments");
			return;
		}
		
		//seeing if the second argument is an integer
		try
		{
			int testNum = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid number");
			return;
		}
		
		//seeing if the file input is there
		File f = new File(args[0]);
		if(!f.exists())
		{
			System.out.println("File does not exist");
			return;
		}
		
		//seeing if the second argument is within the amount of lines in the txt file
		FileReader fr = new FileReader(args[0]);
		BufferedReader bf = new BufferedReader(fr);
		String line;
		int count=0;
		while((line = bf.readLine()) != null)
		{
			count++;
		}
		if(Integer.parseInt(args[1])>count-1||Integer.parseInt(args[1])<0)
		{
			System.out.println("Number wanted is out of bounds");
			return;
		}
		
		//running the the rest of the program
		String fileName = args[0];
		int value = Integer.parseInt(args[1]);
		coordinates x = new coordinates(fileName);
		x.closestPoints(value);
		
	}

}
