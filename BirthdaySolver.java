public class BirthdaySolver{
	
	//private instances
	private static final int RANGEMIN = 1;
	private static final int RANGEMAX = 365;

	/** Uses randomization to determine probability of at least 2 people out of n people share a birthday. */
	public static void main(String[] args){

		BirthdaySolver bs = new BirthdaySolver(Integer.parseInt(args[0]));

	}

	//public constructor
	public BirthdaySolver(int val){

		System.out.println(solve(val) + " %");

	}

	/** Determines probability of at least 2 people out of n people share a birthday by randomizing birthdays */
	public static double solve(int val){

		double answer;
		double sum = 0;
		double probability;
		int[] birthdays = new int[val];
		if(val == 1){
			answer = 0;
		}
		else{
			for(int i = 0; i < 1000000; i++){
				for(int j = 0; j < birthdays.length; j++){
					birthdays[j] = RANGEMIN + (int)(Math.random() * (RANGEMAX - RANGEMIN));
				}
				boolean duplicates = false;
				for(int j = 0; j < birthdays.length; j++){
 					for(int k = j + 1; k < birthdays.length; k++){
    					if (k != j && birthdays[k] == birthdays[j]){
     						duplicates = true;
     					}
     				}
     			}
     			if(duplicates){
     				sum++;
     			}
			}
			answer = 100 * (sum / 1000000);
		}
		return answer;

	}

}
