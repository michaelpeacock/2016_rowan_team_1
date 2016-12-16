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
}
