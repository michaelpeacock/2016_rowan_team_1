/*
 * Purpose: The CurrentPoint class extends the Point class by adding more information such as the course and velocity of the individual vessel.
 * @author: Brooke Brown
 * @version: 2016.12.16
 */

public class CurrentPoint extends Point{

	double course;
	double velocity;

	public CurrentPoint(double course, double velocity, double x, double y) {
		super(x,y);
		this.course = course;
		this.velocity = velocity;
	}

	public double getCourse() 
	{ 
		return course;
	}

	public double getVelocity()
	{
		return velocity;
	}
}

