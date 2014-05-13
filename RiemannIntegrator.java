public class RiemannIntegrator{

	/** Uses Riemann Sum integration to determine the definite integral given the x bounds, type of function, and values of function. */
	public static void main(String[] args){

		double lowerX = Double.parseDouble(args[0]);
		double upperX = Double.parseDouble(args[1]);

		//puts polynomial values into array
		double[] valueArray = new double[args.length - 3];
		for(int i = 3; i < args.length; i++){
			valueArray[i - 3] = Double.parseDouble(args[i]);
		}

		if(args[2].equals("poly")){
			RiemannIntegrator ri = new RiemannIntegrator(lowerX, upperX, valueArray);
		}
		else if(args[2].equals("sin") || args[2].equals("cos") || args[2].equals("tan") || args[2].equals("ln") || args[2].equals("log10")){
			RiemannIntegrator ri = new RiemannIntegrator(lowerX, upperX, args[2]);
		}
		else{
			throw new IllegalArgumentException("Only accepts poly, sin, cos, tan, ln, and log10 for function type");
		}

	}

	//public constructor
	public RiemannIntegrator(double lowBound, double upBound, double[] values){

		System.out.println(polyIntegrate(lowBound, upBound, values));

	}

	//public constructor
	public RiemannIntegrator(double lowBound, double upBound, String function){

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

	/** Uses Riemann sum integration to calculate definite integral of polynomial function. */
	public static double polyIntegrate(double lowBound, double upBound, double[] values){

		double lastArea = 0;
		double slice = 2;
		double area = (upBound - lowBound) * (polyFunction((upBound + lowBound) / 2, values));

		while (Math.abs(lastArea - area) > .01) { 

			double sliceWidth =  Math.abs((upBound - lowBound) / slice);
			double newLowBound = lowBound;
		    double newUpBound = lowBound + sliceWidth;
			lastArea = area;
			area = 0;

			for(int i = (int) slice; i > 0; i-- ) {

				area = area + ((newUpBound - newLowBound) * (polyFunction((newUpBound + newLowBound) / 2, values)));

				newLowBound = newLowBound + sliceWidth;
				newUpBound = newUpBound + sliceWidth;

			}
			slice = Math.pow(slice, 2.0);

		}

		return area;

	}

	/** Uses Riemann sum integration to calculate definite integral of sin function. */
	public static double sinIntegrate(double lowBound, double upBound){

		double lastArea = 0;
		double slice = 2;
		double area = (upBound - lowBound) * (Math.sin((upBound + lowBound) / 2));

		while (Math.abs(lastArea - area) > .01) { 

			double sliceWidth =  Math.abs((upBound - lowBound) / slice);
			double newLowBound = lowBound;
		    double newUpBound = lowBound + sliceWidth;
			lastArea = area;
			area = 0;

			for(int i = (int) slice; i > 0; i-- ) {

				area = area + ((newUpBound - newLowBound) * (Math.sin((newUpBound + newLowBound) / 2)));

				newLowBound = newLowBound + sliceWidth;
				newUpBound = newUpBound + sliceWidth;

			}
			slice = Math.pow(slice, 2.0);

		}

		return area;

	}

	/** Uses Riemann sum integration to calculate definite integral of cos function. */
	public static double cosIntegrate(double lowBound, double upBound){

		double lastArea = 0;
		double slice = 2;
		double area = (upBound - lowBound) * (Math.cos((upBound + lowBound) / 2));

		while (Math.abs(lastArea - area) > .01) { 

			double sliceWidth =  Math.abs((upBound - lowBound) / slice);
			double newLowBound = lowBound;
		    double newUpBound = lowBound + sliceWidth;
			lastArea = area;
			area = 0;

			for(int i = (int) slice; i > 0; i-- ) {

				area = area + ((newUpBound - newLowBound) * (Math.cos((newUpBound + newLowBound) / 2)));

				newLowBound = newLowBound + sliceWidth;
				newUpBound = newUpBound + sliceWidth;

			}
			slice = Math.pow(slice, 2.0);

		}

		return area;

	}

	/** Uses Riemann sum integration to calculate definite integral of tan function. */
	public static double tanIntegrate(double lowBound, double upBound){

		double lastArea = 0;
		double slice = 2;
		double area = (upBound - lowBound) * (Math.tan((upBound + lowBound) / 2));

		while (Math.abs(lastArea - area) > .01) { 

			double sliceWidth =  Math.abs((upBound - lowBound) / slice);
			double newLowBound = lowBound;
		    double newUpBound = lowBound + sliceWidth;
			lastArea = area;
			area = 0;

			for(int i = (int) slice; i > 0; i-- ) {

				area = area + ((newUpBound - newLowBound) * (Math.tan((newUpBound + newLowBound) / 2)));

				newLowBound = newLowBound + sliceWidth;
				newUpBound = newUpBound + sliceWidth;

			}
			slice = Math.pow(slice, 2.0);

		}

		return area;

	}

	/** Uses Riemann sum integration to calculate definite integral of ln function. */
	public static double lnIntegrate(double lowBound, double upBound){

		double lastArea = 0;
		double slice = 2;
		double area = (upBound - lowBound) * (Math.log((upBound + lowBound) / 2));

		while (Math.abs(lastArea - area) > .01) { 

			double sliceWidth =  Math.abs((upBound - lowBound) / slice);
			double newLowBound = lowBound;
		    double newUpBound = lowBound + sliceWidth;
			lastArea = area;
			area = 0;

			for(int i = (int) slice; i > 0; i-- ) {

				area = area + ((newUpBound - newLowBound) * (Math.log((newUpBound + newLowBound) / 2)));

				newLowBound = newLowBound + sliceWidth;
				newUpBound = newUpBound + sliceWidth;

			}
			slice = Math.pow(slice, 2.0);

		}

		return area;

	}

	/** Uses Riemann sum integration to calculate definite integral of log function. */
	public static double log10Integrate(double lowBound, double upBound){

		double lastArea = 0;
		double slice = 2;
		double area = (upBound - lowBound) * (Math.log10((upBound + lowBound) / 2));

		while (Math.abs(lastArea - area) > .01) { 

			double sliceWidth =  Math.abs((upBound - lowBound) / slice);
			double newLowBound = lowBound;
		    double newUpBound = lowBound + sliceWidth;
			lastArea = area;
			area = 0;

			for(int i = (int) slice; i > 0; i-- ) {

				area = area + ((newUpBound - newLowBound) * (Math.log10((newUpBound + newLowBound) / 2)));

				newLowBound = newLowBound + sliceWidth;
				newUpBound = newUpBound + sliceWidth;

			}
			slice = Math.pow(slice, 2.0);

		}

		return area;

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