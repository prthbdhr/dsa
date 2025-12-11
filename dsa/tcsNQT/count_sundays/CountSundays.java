package dsa.tcsNQT.count_sundays;

import java.util.Scanner;

public class CountSundays {

    private static final String[] DAYS = {
        "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String startDay = sc.next();
        int n = sc.nextInt();

        sc.close();
        
        int sundays = countSundays(startDay, n);
        System.out.println(sundays);
    }

    private static int countSundays (String startDay, int n) {

        int startIndex = -1;

        for (int i = 0; i < DAYS.length; i++) {
            
            if (DAYS[i].equalsIgnoreCase(startDay)) {
                startIndex = i;
                break;
            }
        }

        int sundays = 0;

        for (int i = 0; i < n; i++) {

            int dayIndex = (startIndex + i) % 7;

            if (dayIndex == 6) sundays++;
        }

        return sundays;
    }
}
