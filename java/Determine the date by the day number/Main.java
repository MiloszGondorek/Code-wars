//task url: https://www.codewars.com/kata/602afedfd4a64d0008eb4e6e/train/java

class Kata {
    public static String getDay(int day, boolean isLeap) {
        String[] months=new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"}; // Set months names
        int[] daysInMonth=new int[]{31,isLeap?29:28,31,30,31,30,31,31,30,31,30,31}; // Set day in month if years is leap set february days as 29 else set 28
        for(int x=0;x<12;x++){
            day-=daysInMonth[x]; // Decrease days numbers by numbers of days in month
            if(day<=0) // Days <= 0, it means that this is correct month
                return months[x]+", "+(daysInMonth[x]+day); // return correct month and day
        }
        return "False input";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Kata().getDay(15, false));
    }
}
