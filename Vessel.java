package team2.lostatsea;

/**
 * Created by TAKKA on 12/16/2016.
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vessel {


    String Name;

    Date tNot;
    Point lastLoc;

    double speed;

    double heading;

    Date ETA;

    public Vessel(Date tNot, Point lastLoc, double speed, double heading, Date ETA, String Name ) {
        DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss SS");
        this.tNot= tNot;
        this.lastLoc =lastLoc;
        this.speed = speed;
        this.heading=heading;
        this.ETA=ETA;
        this.Name = Name;



    }
public String Name(){
    return Name;
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

    public double getLongitude() {
        return lastLoc.getX();
    }

    public double getLatitude() {
        return lastLoc.getY();
    }

}