import java.util.Random;
public class Map{

	private static Random rand = new Random();
	
	private static final double lower = .65;
	private static final double upper = 1.35;
	private static final int upperTime = 1440;

	private double north;
	private double south;
	private double east;
	private double west;	

	private Point points [];

	public Map(){
		north = 0;
		south = 0;
		east = 0;
		west = 0;

		points = new Points[10000];
	}

	public Map(Point points[]){
		this.points = points;
		north = findNorth(points);
		south = findSouth(points);
		east = findEast(points);
		west = findWest(points);

	}

	public Map(double north, double south, double east, double west){
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		
		this.points = new Points[10000];
	}

	public Map(double north, double south, double east, double west, Point points [])
	{
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.points = points;
	}

	public Point[] createPossiblePointSet(Vessel vessel){
		Point pointSet [] = new Point[10000];
		for(int i = 0; i < 10000; i++){
			double xPossible = (vessel.getLongitude() * lower) + ((vessel.getLongitude() * upper) - (vessel.getLongitude() * lower)) * rand.nextDouble();
			double yPossible = (vessel.getLatitude() * lower) + ((vessel.getLatitude() * upper) - (vessel.getLatitude() * lower)) * rand.nextDouble();
			double headingPossible = (vessel.getHeading() * lower) + ((vessel.getHeading() * upper) - (vessel.getHeading() * lower)) * rand.nextDouble();
			double timePossible = (double) rand.nextInt(upperTime + 1) / 100;
			double velPossible = (vessel.getSpeed() * lower) + ((vessel.getSpeed() * upper) - (vessel.getSpeed() * lower)) * rand.nextDouble();

			double distance = timePossible * velPossible;
			double xDistance = Math.cos(Math.toRadians(headingPossible)) * distance;
			double yDistance = Math.sin(Math.toRadians(headingPossible)) * distance;
			Point point = new Point(xDistance + xPossible, yDistance + yPossible);
			pointSet[i] = point;
		}
	}

	private static double findNorth(Point points []){
		double small;
		for(Point point : points){
			if(small > point.getLatitude())
				small = point.getLatitude();
		}
		return small;
	}
	
	

	private static double findSouth(Point points []){
		double large;
		for(Point point : points){
			if(large < point.getLatitude())
				large = point.getLatitude();
		}
		return large;
	}

	private static double findWest(Point points []){
		double small;
		for(Point point : points){
			if(small > point.getLongitude())
				small = point.getLongitude();
		}
		return small;
	}
	
	private static double findEast(Point points []){
		double large;
		for(Point point : points){
			if(large < point.getLongitude())
				large = point.getLongitude();
		}
		return large;
	}
}
