import java.util.Random;
public class Map{

	private static Random rand = new Random();

	private static final int mileToLat = 69;//this is an estimate for an approximate that works within 2 km of the north and south poles
	private static final int mileToLong = 55;//this is an estimate for an approximate that works within few km of the actual

	private static final double lower = .65;//this is to change the tolerance on the creation of possible locations of the ship
	private static final double upper = 1.35;

	private static final int upperTime = 1440;//minutes in a day. Used for creating T(casualty)

	private double north;//furthest lat north
	private double south;//furthest lat south
	private double east;//furthest long east
	private double west;//furthest long west

	private Point points [];

	public Map(){
		north = 0;
		south = 0;
		east = 0;
		west = 0;

		points = new Point[10000];
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
		
		this.points = new Point[10000];
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
			double xPossible = (vessel.getX() * lower) + ((vessel.getX() * upper) - (vessel.getX() * lower)) * rand.nextDouble();
			double yPossible = (vessel.getY() * lower) + ((vessel.getY() * upper) - (vessel.getY() * lower)) * rand.nextDouble();
			double headingPossible = (vessel.getHeading() * lower) + ((vessel.getHeading() * upper) - (vessel.getHeading() * lower)) * rand.nextDouble();
			double timePossible = (double) rand.nextInt(upperTime + 1) / 100;
			double velPossible = (vessel.getSpeed() * lower) + ((vessel.getSpeed() * upper) - (vessel.getSpeed() * lower)) * rand.nextDouble();

			double distance = timePossible * velPossible;
			double xDistance = (Math.cos(Math.toRadians(headingPossible)) * distance) / 69;
			double yDistance = (Math.sin(Math.toRadians(headingPossible)) * distance) / 69;
			Point point = new Point(xDistance + xPossible, yDistance + yPossible);
			pointSet[i] = point;
			System.out.println(xPossible + " " + yPossible + " " + headingPossible + " " + timePossible + " " + distance + " " + xDistance + " " + yDistance);
		}
		return pointSet;
	}

<<<<<<< HEAD
	private static int findNorth(Point points []){
		int small;
=======
	private static double findNorth(Point points []){
		double small = Double.MAX_VALUE;
>>>>>>> PKT_dev
		for(Point point : points){
			if(small > point.getY())
				small = point.getY();
		}
		return small;
	}
	
	

<<<<<<< HEAD
	private static int findSouth(Point points []){
		int large;
=======
	private static double findSouth(Point points []){
		double large = Double.MIN_VALUE;
>>>>>>> PKT_dev
		for(Point point : points){
			if(large < point.getY())
				large = point.getY();
		}
		return large;
	}

<<<<<<< HEAD
	private static int findWest(Point points []){
		int small;
=======
	private static double findWest(Point points []){
		double small = Double.MAX_VALUE;
>>>>>>> PKT_dev
		for(Point point : points){
			if(small > point.getX())
				small = point.getX();
		}
		return small;
	}
	
<<<<<<< HEAD
	private static int findEast(Point points []){
		int large;
=======
	private static double findEast(Point points []){
		double large = Double.MIN_VALUE;
>>>>>>> PKT_dev
		for(Point point : points){
			if(large < point.getX())
				large = point.getX();
		}
		return large;
	}
	
	
}
