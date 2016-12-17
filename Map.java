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

	public Map(int north, int south, int east, int west){
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		
		this.points = new Point[totalPoints];
	}

	public Map(int north, int south, int east, int west, Point points [])
	{
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.points = points;
	}

	public double[][] populate(int x, int y){
		double[][] map  = new double[x][y];
		for(int i = 0; i < x; i++){
			for(int k = 0; k < y; k++){
				map[i][k] = 0;
			}
		}
		return map;
	}

	public double[][] createMap(Vessel vessel){
		double [][] map = populate(south-north,east-west);
		Point pointSet [] = createPossiblePointSet(vessel);
		for(int i = 0; i < totalPoints; i++){
			map[pointSet[i].getLong()][pointSet[i].getLat()]++;
		}
		return map;
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

	private static int findNorth(Point points []){
		int small = Integer.MAX_VALUE;
		for(Point point : points){
			if(small > point.getLat())
				small = point.getLat();
		}
		return small;
	}	

	private static int findSouth(Point points []){
		int large = Integer.MIN_VALUE;
		for(Point point : points){
			if(large < point.getLat())
				large = point.getLat();
		}
		return large;
	}
	private static int findWest(Point points []){
		int small = Integer.MAX_VALUE;
		for(Point point : points){
			if(small > point.getLong())
				small = point.getLong();
		}
		return small;
	}
	
	private static int findEast(Point points []){
		int large = Integer.MIN_VALUE;
		for(Point point : points){
			if(large < point.getLong())
				large = point.getLong();
		}
		return large;
	}
}
