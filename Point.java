/*
 * Purpose: The Point class holds the x, y coordinates of the ship.
 * @author: Brooke Brown
 * @version: 2016.12.16
 */
 
public class Point {
	double x;
	double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() 
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public int getLong(){
		return x-(int)x > .5 ? (int)x+1 : (int)x; //If the long has a value greater than .5 in the decimal then round up, else round down
	}
	
	public int getLat(){
		return y-(int)y > .5 ? (int)y+1 : (int)y;//If the long has a value greater than .5 in the decimal then round up, else round down
	}
}
