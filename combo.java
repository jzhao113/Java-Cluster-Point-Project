public class combo {
	
	//combo stores x, y and distance of a pair
	private int x;
	private int y;
	private double distance;
	
	public combo(int x, int y, double distance)
	{
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	//getters and setters
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public double getDistance()
	{
		return distance;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setDistance(double distance)
	{
		this.distance = distance;
	}

}
