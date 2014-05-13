public class MapSolver{

	//private instances
	private static boolean[][] mapTable;
	private static int regions;
	private static int adjacencies;
	private static final int REGIONCOLORDEFAULT = 5;

	/** Uses input region number adjacencies, starting at region 0, to color map with 4 colors with no regions of same color touching. */
	public static void main (String[] args){

		MapSolver mp = new MapSolver(args);

	}

	//public constructor
	public MapSolver(String[] args){

		regions = regionCount(args);
		adjacencies = args.length;
		makeMap(args);

		int[] regionColors = new int[regions];

		for(int i = 0; i < regions; i++){ 
			regionColors[i] = REGIONCOLORDEFAULT;
		}

		colorMap(0, regionColors, mapTable);

		throw new IllegalArgumentException("IMPOSSIBLE MAP");

	}

	/** Creates a 2d boolean array to simulate a map. */
	public static void makeMap(String[] args){

		mapTable = new boolean[regions][regions];

		//indicates adjacencies with true
		for (int i = 0; i < adjacencies; i = i + 2) {
			int border1 = Integer.parseInt(args[i]);
			int border2 = Integer.parseInt(args[i + 1]);

			mapTable [border1][border2] = true;
			mapTable [border2][border1] = true;
		}

		//indicates non adjacencies with false
		for (int i = 0; i < regions; i++) {
			for (int j = 0; j < regions; j++) {
				boolean box = mapTable[i][j];
				if(box != true) {
					box = false;
				}
			}
		}

	}

	/** Checks the input for the total number of regions. */
	public static int regionCount(String[] args){

		int[] regions = new int[args.length];
		for(int i = 0; i < regions.length; i++){
			regions[i] = Integer.parseInt(args[i]);
		}

		int regionCount;
		int highestNum = 0;

		for(int i = 0; i < args.length; i++){
			if(regions[i] > highestNum){
				highestNum = regions[i];
			}
		}

		regionCount = highestNum + 1;

		return regionCount;

	}

	/** Checks map for conflicting color schemes. */
	public static boolean colorConflict(boolean[][] mapTable, int[] regionColors){

		int length = regionColors.length;

		for (int i = 0; i < length; i++){
			for (int j = 0; j < length; j++){
				if (mapTable [i][j] == true && regionColors[i] != REGIONCOLORDEFAULT 
					&& regionColors[j] != REGIONCOLORDEFAULT && regionColors[i] == regionColors[j]){
					return true;
				}
			}
		}
		return false;

	}

	/** Colors in the regions of the map. */
	public static void colorMap(int n, int[] regionColors, boolean[][] mapTable){

		for(int i = 0; i <= 3; i++){ 
			regionColors[n] = i;

			if(!colorConflict(mapTable, regionColors)){
				if(n == regionColors.length - 1){
					print(regionColors);
					System.exit(0);
				}
				else{
					colorMap(n + 1, regionColors, mapTable);

				}	
			} 
		}

		regionColors[n] = REGIONCOLORDEFAULT;

	}

	/** Prints the results of the map coloring. */
	public static void print(int[] regionColors){

		System.out.println("\n" + "Map should be colored as follows: \n");

		String[] colors = new String[regionColors.length];

		for (int i = 0; i < regionColors.length; i++){
			int colorNum = regionColors[i];
			String color = "";

			switch (colorNum) {
				case 0:  color = "RED";
				break;
				case 1:  color = "BLUE";
				break;
				case 2:  color = "YELLOW";
				break;
				case 3:  color = "GREEN";
				break;
			}

			colors[i] = color;

			System.out.println("Region " + i + " is colored: " + colors[i]);
		}

	}

}