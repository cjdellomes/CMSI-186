
public class CountTheDays {

	/* Prints number of days between two dates or that the given date is invalid. */
	public static void main(String[] args) {
		long long1 = Long.parseLong(args[0]);
		long long2 = Long.parseLong(args[1]);
		long long3 = Long.parseLong(args[2]);
		long long4 = Long.parseLong(args[3]);
		long long5 = Long.parseLong(args[4]);
		long long6 = Long.parseLong(args[5]);
		long long0 = 0;
		if(isValidDate(long1, long2, long3) || isValidDate(long4, long5, long6)){
			System.out.println(daysBetween(long1, long2, long3, long4, long5, long6));
		}
		else{
			System.out.println("Invalid dates entered");
		}
	}
	
	/* Returns whether or not a given year is a leap year. */
	public static boolean isLeapYear(long year){
		if(year % 4 == 0){
			if(year % 100 == 0){
				if(year % 400 == 0){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return true;
			}
		}
		else{
			return false;
		}
	}
	
	/* Returns the number of days in a given month from a specific year. */
	public static long daysInMonth(long month, long year){
		int days;
		if(month == 4 || month == 6 || month == 9 || month == 11){
			days = 30;
		}
		else if(month == 2){
			if(isLeapYear(year)){
				days = 29;
			}
			else{
				days = 28;
			}
		}
		else{
			days = 31;
		}
		return days;
	}
	
	/* Returns whether or not a date is valid. */
	public static boolean isValidDate(long month, long day, long year){
		boolean validM = false;
		boolean validY = false;
		boolean validD = false;
		if(month > 0 && month < 13){
			validM = true;
		}
		if(year > 0){
			validY = true;
		}
		if(day > 0 && day <= daysInMonth(month, year)){
			validD = true;
		}
		if(validM && validY && validD){
			return true;
		}
		else{
			return false;
		}
	}
	
	/* Returns number of days between two dates. */
	public static long daysBetween(long month0, long day0, long year0, long month1, long day1, long year1){
		long dayCount = 0;
		long determine1 = 0;
		long determine2 = 0;
		long day3 = 0;
		long month3 = 0;
		long year3 = 0;

		//determines which date is later
		if(year1 > year0){
			determine2 = 1;
		}
		else if(year1 < year0){
			determine1 = 1;
		}
		else{
			if(month1 > month0){
				determine2 = 1;
			}
			else if(month1 < month0){
				determine1 = 1;
			}
			else{
				if(day1 > day0){
					determine2 = 1;
				}
				else{
					determine1 = 1;
				}
			}
		}

		//prints 0 if dates are equal
		if(month0 == month1 && day0 == day1 && year0 == year1){
			dayCount = 0;
		}
		
		//calculates number of days between
		else{
			if(determine2 > determine1){
				while(day0 != day1 || month0 != month1 || year0 != year1){
					day0++;
					if (day0 > daysInMonth(month0, year0)){
						day0 = 1;
						month0++;
						if(month0 > 12){
							month0 = 1;
							year0++;
						}
					}
					dayCount++;
				}
			}
			else{
				while(day0 != day1 || month0 != month1 || year0 != year1){
					day1++;
					if (day1 > daysInMonth(month1, year1)){
						day1 = 1;
						month1++;
						if(month1 > 12){
							month1 = 1;
							year1++;
						}
					}
					dayCount++;
				}
			}
		}
		return dayCount;
	}
}