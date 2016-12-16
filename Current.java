/*
 * Purpose: The Current class is designed to show where ocean currents are. It holds an array of Points that display where the Current is located.
 * @author: Brooke Brown
 * @version: 2016.12.16
 */

import java.util.*;

public class Current {

	ArrayList<Point> points;

	//default constructor that takes in an already available array
	public Current(ArrayList<Point> points) 
	{
		this.points = points;
	}

	//second constructor if the points for the current are unknown
	public Current()
	{
		points = new ArrayList<Point>();
	}

	/*
	 * Adds a point to the points array.
	 * @param x the longitude of the point
	 * @param y the latitude of the point
	 */
	public void addPoint(double x, double y)
	{
		Point point = new Point(x, y);
		points.add(point);
	}

	public ArrayList<Point> getPoints()
	{ 
		return points;
	}
}
