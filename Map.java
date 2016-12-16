import java.util.Random;
public class Map{
	
	private static final lower = .65;
	private static final upper = 1.35;
	private static final upperTime = 2400;

	double north;
	double south;
	double east;
	double west;	

	//Point resizable array

	public Map(){
		north = 0;
		south = 0;
		east = 0;
		west = 0;

		//Point resizable array	
	}

	public Map(Point points[]){
		//Point resizable array = points
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
		
		//Points array
	}

	public Map(double north, double south, double east, double west, Point points [])
	{
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		//points array 
	}

	public Point createPossible(Vessel vessel){
		double xPossible = (vessel.getLongitude() * lower) + ((vessel.getLongitude() * upper) - (vessel.getLongitude() * lower)) * rand.nextDouble();
		double yPossible = (vessel.getLatitude() * lower) + ((vessel.getLatitude() * upper) - (vessel.getLatitude() * lower)) * rand.nextDouble();
		double headingPossible = (vessle.getHeading() * lower) + ((vessel.getHeading() * upper) - (vessel.getHeading() * lower)) * rand.nextDouble();
		double timePossible = (double) rand.nextInt(upperTime + 1) / 100;
}

	private static double findNorth(Point points []){
		double small;
		for(int i = 0; i < points.length -1;i++){
			if(small > point.getLatitude())
				small = point.getLatitude();
		}
		return small;
	}
	
	

	private static double findSouth(Point points []){
		double large;
		for(int i = 0; i < points.length; i++){
			if(large < point.getLatitude())
				large = point.getLatitude();
		}
		return large;
	}

	private static double findWest(Point points []){
		double small;
		for(int i = 0; i < points.length; i++){
			if(small > point.getLongitude())
				small = point.getLongitude();
		}
		return small;
	}
	
	private static double findEast(Point points []){
		double large;
		for(int i = 0; i < points.length; i++){
			if(large < point.getLongitude())
				large = point.getLongitude();
		}
		return large;
	}
}
