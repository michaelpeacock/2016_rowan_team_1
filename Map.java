import java.util.Random;
public class Map{

	private static Random rand = new Random();

	private static int totalPoints = 10000;

	private static final int mileToLat = 69;//this is an estimate for an approximate that works within 2 km of the north and south poles
	private static final int mileToLong = 55;//this is an estimate for an approximate that works within few km of the actual

	private static final double lower = .65;//this is to change the tolerance on the creation of possible locations of the ship
	private static final double upper = 1.35;

	private static final int upperTime = 1440;//minutes in a day. Used for creating T(casualty)

	private int north;//furthest lat north
	private int south;//furthest lat south
	private int east;//furthest long east
	private int west;//furthest long west

	private Point points [];

	public Map(){
		north = 0;
		south = 0;
		east = 0;
		west = 0;

		points = new Point[totalPoints];
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
		
		this.points = new Point[totalPoints];
	}

	public Map(double north, double south, double east, double west, Point points [])
	{
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.points = points;
	}

	public double[][] createMap(Vessel vessel){
		double [][] map = new double[south-north][east-west];
		Point pointSet [] = createPossiblePointSet(vessel);
		for(int i = 0; i < totalPoints; i++){
			if(map[pointSet[i].getX()][pointSet[i].getY()] == null)
			map[pointSet[i].getX()][pointSet[i].getY()] = 1;
			else
			map[pointSet[i].getX()][pointSet[i].getY()]++;

		}
	}

	public Point[] createPossiblePointSet(Vessel vessel){
		Point pointSet [] = new Point[totalPoints];
		for(int i = 0; i < totalPoints; i++){
			double xPossible = (vessel.getX() * lower) + ((vessel.getX() * upper) - (vessel.getX() * lower)) * rand.nextDouble();
			double yPossible = (vessel.getY() * lower) + ((vessel.getY() * upper) - (vessel.getY() * lower)) * rand.nextDouble();
			double headingPossible = (vessel.getHeading() * lower) + ((vessel.getHeading() * upper) - (vessel.getHeading() * lower)) * rand.nextDouble();
			double timePossible = (double) rand.nextInt(upperTime + 1) / 100;
			double velPossible = (vessel.getSpeed() * lower) + ((vessel.getSpeed() * upper) - (vessel.getSpeed() * lower)) * rand.nextDouble();

			double distance = timePossible * velPossible;
			double xDistance = (Math.cos(Math.toRadians(headingPossible)) * distance) / mileToLong;
			double yDistance = (Math.sin(Math.toRadians(headingPossible)) * distance) / mileToLat;
			Point point = new Point(xDistance + xPossible, yDistance + yPossible);
			pointSet[i] = point;
			System.out.println(xPossible + " " + yPossible + " " + headingPossible + " " + timePossible + " " + distance + " " + xDistance + " " + yDistance);
		}
		return pointSet;
	}

	private static double findNorth(Point points []){
		double small = Double.MAX_VALUE;
		for(Point point : points){
			if(small > point.getY())
				small = point.getY();
		}
		return small;
	}
	
	

	private static double findSouth(Point points []){
		double large = Double.MIN_VALUE;
		for(Point point : points){
			if(large < point.getY())
				large = point.getY();
		}
		return large;
	}
	private static double findWest(Point points []){
		double small = Double.MAX_VALUE;
		for(Point point : points){
			if(small > point.getX())
				small = point.getX();
		}
		return small;
	}
	
	private static double findEast(Point points []){
		double large = Double.MIN_VALUE;
		for(Point point : points){
			if(large < point.getX())
				large = point.getX();
		}
		return large;
	}
}
