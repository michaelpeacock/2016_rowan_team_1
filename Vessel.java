import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vessel {
	
Date tNot;
Point lastLoc; 

Double speed; 

Double heading; 

Date ETA; 

public Vessel(Date tNot, Point lastLoc, Double speed, Double heading, Date ETA ) {
	DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss SS");
	this.tNot= tNot; 
	this.lastLoc =lastLoc; 
	this.speed = speed; 
	this.heading=heading; 
	this.ETA=ETA; 
	
	
}

public Date gettNot() {
	return tNot;
}

public void settNot(Date tNot) {
	this.tNot = tNot;
}

public Point getLastLoc() {
	return lastLoc;
}

public void setLastLoc(Point lastLoc) {
	this.lastLoc = lastLoc;
}

public Double getSpeed() {
	return speed;
}

public void setSpeed(Double speed) {
	this.speed = speed;
}

public Double getHeading() {
	return heading;
}

public void setHeading(Double heading) {
	this.heading = heading;
}

public Date getETA() {
	return ETA;
}

public void setETA(Date eTA) {
	ETA = eTA;
}

public double getX() {
	return lastLoc.getX();
}

public double getY() {
	return lastLoc.getY();
}

	public int getLong()
	{
		return (int) lastLoc.getY();
	}

	public int getLat()
	{
		return (int) lastLoc.getX();
	}
	
}

