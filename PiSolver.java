public class PiSolver{

	//private instances
	private static final double RANGEMIN = 0.0;
	private static final double RANGEMAX = 2.0;
	
	/** Calculates an estimate for the value of pi by throwing a specified number of darts randomly at a board. Default dart count is 1000. */
	public static void main(String[] args){
		if(args.length == 1){
			PiSolver ps = new PiSolver(Integer.parseInt(args[0]));
		}
		else{
			PiSolver ps = new PiSolver();
		}
	}

	//public constructor
	public PiSolver(){
		System.out.println(solve(1000));
	}

	//public constructor
	public PiSolver(int val){
		System.out.println(solve(val));
	}

	/** Throws a specified number of darts at a board and returns percentage landed in circle. */
	public static double solve(int val){
		int tally = 0;
		double answer = 0;
		double percent = 0;
		boolean inCircle;
		double xCoordinate;
		double yCoordinate;
		for(int i = 0; i < val; i++){
			xCoordinate = randomCoordinate();
			yCoordinate = randomCoordinate();
			inCircle = (Math.pow(xCoordinate - 1, 2)) + (Math.pow(yCoordinate - 1, 2)) <= 1;
			if(inCircle == true){
				tally++;
			}
		}
		percent = ((double)tally / (double)val);
		answer = 4 * percent;
		return answer;
	}

	/** Returns random number for one coordinate of dart. */
	public static double randomCoordinate(){
		double dub = 0;
		dub = RANGEMIN + (Math.random() * (RANGEMAX - RANGEMIN));
		return dub;
	}


}