import java.io.*;
import java.util.*;
import java.math.*;
public class coordinates  {
	
	private String fileName;
	private ArrayList<Integer> xCoords = new ArrayList<>();
	private ArrayList<Integer> yCoords = new ArrayList<>();
	private int originPoint[] = new int[2];
	
	//making comparator for objects of class combo
	Comparator<combo> firstElement  = new Comparator<combo>()
			{
				@Override
				public int compare(combo x, combo y)
				{
					if(x.getDistance()<y.getDistance())
						return -1;
					else if(x.getDistance()>y.getDistance())
						return 1;
					
					return 0;
				}
			};
	
	//making priority queue with overridden comparator
	private PriorityQueue<combo> sorted = new PriorityQueue<>(firstElement);
	
	public coordinates(String fileName) throws IOException
	{
		//storing file name
		this.fileName=fileName;
		
		//reading in file
		readFile();
		
		//creating combo objects with data provided and storing them in prioity queue
		for(int i=0;i<xCoords.size();i++)
		{
			double x = convertToDistance(xCoords.get(i),yCoords.get(i));
			combo temp = new combo(xCoords.get(i),yCoords.get(i),x);
			sorted.add(temp);
		}

	}
	
	public void closestPoints(int x) throws IOException
	{
		FileWriter fw = new FileWriter("output.txt");
		
		//peeking, writing then removing from queue to the number of x
		for(int i=0;i<x;i++)
		{
			fw.write(Integer.toString(sorted.peek().getX())+" , "+sorted.peek().getY()+" , "+sorted.peek().getDistance()+"\n");
			sorted.remove();
		}
		
		fw.close();
	}
	
	private void readFile() throws IOException
	{
		//this code is not mine, I just needed this piece for it to work
		BufferedReader bf = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(fileName),
			        "UTF-8"));
		bf.mark(1);
		if (bf.read() != 0xFEFF)
		  bf.reset();
		
		//this is where "not my code" ends
		
		String line="";
		
		//used for the origin point 
		int counter=1;
		
		//reading file
		while((line = bf.readLine()) != null)
		{
			//split each line by the space
			String[] split = line.split("\\s+");
			
			//split has to be the size of two for the x and y, if not close program
			if(split.length!=2)
			{
				System.out.println("Invalid line in txt file");
				System.exit(0);
			}
			
			//testing if both x and y are integer values
			try
			{
				int x = Integer.parseInt(split[0]);
				int y = Integer.parseInt(split[1]);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid number in file");
				System.exit(0);
			}
			
			//grabbing the origin point
			if(counter==1)
			{
				originPoint[0]=Integer.parseInt(split[0]);
				originPoint[1]=Integer.parseInt(split[1]);
				counter++;
			}
			else //storing the rest into the x and y coords arraylist
			{
				xCoords.add(Integer.parseInt(split[0]));
				yCoords.add(Integer.parseInt(split[1]));
			}
			
		}
		
		bf.close();
		
	}
	
	//distance formula function
	private double convertToDistance(int x, int y)
	{	
		return Math.sqrt( Math.pow(originPoint[0]-x, 2) + Math.pow(originPoint[1]-y, 2));
	}
	
	

}
