public class Map{
	
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

	}

	public Map(double north, double south, double east, double west, Point points [])
	{
		
	}
}
