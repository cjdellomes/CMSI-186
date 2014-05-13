public class RandomIntegrator{

	/** Uses randomized integration to determine the definite integral given the x bounds, type of function, and values of function. */
	public static void main(String[] args){

		double lowerX = Double.parseDouble(args[0]);
		double upperX = Double.parseDouble(args[1]);

		//puts polynomial values into array
		double[] valueArray = new double[args.length - 3];
		for(int i = 3; i < args.length; i++){
			valueArray[i - 3] = Double.parseDouble(args[i]);
		}

		if(args[2].equals("poly")){
			RandomIntegrator ri = new RandomIntegrator(lowerX, upperX, valueArray);
		}
		else if(args[2].equals("sin") || args[2].equals("cos") || args[2].equals("tan") || args[2].equals("ln") || args[2].equals("log10")){
			RandomIntegrator ri = new RandomIntegrator(lowerX, upperX, args[2]);
		}
		else{
			throw new IllegalArgumentException("Only accepts poly, sin, cos, tan, ln, and log10 for function type");
		}

	}

	//public constructor
	public RandomIntegrator(double lowBound, double upBound, double[] values){

		System.out.println(polyIntegrate(lowBound, upBound, values));

	}

	//public constructor
	public RandomIntegrator(double lowBound, double upBound, String function){

		if(function.equals("sin")){
			System.out.println(sinIntegrate(lowBound, upBound));
		}
		else if(function.equals("cos")){
			System.out.println(cosIntegrate(lowBound, upBound));
		}
		else if(function.equals("tan")){
			System.out.println(tanIntegrate(lowBound, upBound));
		}
		else if(function.equals("ln")){
			System.out.println(lnIntegrate(lowBound, upBound));
		}
		else if(function.equals("log10")){
			System.out.println(log10Integrate(lowBound, upBound));
		}

	}

	/** Uses randomized integration to determine definite integral of polynomial function. */
	public static double polyIntegrate(double lowBound, double upBound, double[] values){

		double xRand;
		double sum = 0;

		for(int i = 0; i < 1000000; i++){
			xRand = Math.random() * (upBound - lowBound) + lowBound;
			sum += polyFunction(xRand, values);
		}

		double approximate = (upBound - lowBound) * sum / 1000000;
		return approximate;

	}

	/** Uses randomized integration to determine definite integral of sin function. */
	public static double sinIntegrate(double lowBound, double upBound){

		double xRand;
		double sum = 0;

		for(int i = 0; i < 1000000; i++){
			xRand = Math.random() * (upBound - lowBound) + lowBound;
			sum += Math.sin(xRand);
		}

		double approximate = (upBound - lowBound) * sum / 1000000;
		return approximate;

	}

	/** Uses randomized integration to determine definite integral of cos function. */
	public static double cosIntegrate(double lowBound, double upBound){

		double xRand;
		double sum = 0;

		for(int i = 0; i < 1000000; i++){
			xRand = Math.random() * (upBound - lowBound) + lowBound;
			sum += Math.cos(xRand);
		}

		double approximate = (upBound - lowBound) * sum / 1000000;
		return approximate;

	}

	public static double tanIntegrate(double lowBound, double upBound){

		double xRand;
		double sum = 0;

		for(int i = 0; i < 1000000; i++){
			xRand = Math.random() * (upBound - lowBound) + lowBound;
			sum += Math.tan(xRand);
		}

		double approximate = (upBound - lowBound) * sum / 1000000;
		return approximate;

	}

	public static double lnIntegrate(double lowBound, double upBound){

		double xRand;
		double sum = 0;

		for(int i = 0; i < 1000000; i++){
			xRand = Math.random() * (upBound - lowBound) + lowBound;
			sum += Math.log(xRand);
		}

		double approximate = (upBound - lowBound) * sum / 1000000;
		return approximate;

	}

	public static double log10Integrate(double lowBound, double upBound){

		double xRand;
		double sum = 0;

		for(int i = 0; i < 1000000; i++){
			xRand = Math.random() * (upBound - lowBound) + lowBound;
			sum += Math.log10(xRand);
		}

		double approximate = (upBound - lowBound) * sum / 1000000;
		return approximate;

	}

	/** Calculates and returns value of polyFunction with given x. */
	public static double polyFunction(double x, double[] values){

		double sum = 0;

		for(int i = 0; i < values.length; i++){
			sum += values[i] * Math.pow(x, i);
		}

		return sum;

	}

}