/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Class16Lab;

import dates.DateUtilities;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author psaxena
 */
public class PlayWithDate {

    public static void main(String[] args) {
        /**
         * Lab Activity 1
         */
        System.out.println("Solution for Lab 1");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy hh:mm a");

        String formattedDate1 = sdf.format(date);
        System.out.println("1 Formatted Date: " + formattedDate1);

        /**
         * Lab Activity 2
         */
        System.out.println("\nSolution for Lab 2");
        Calendar cal1 = Calendar.getInstance();
        Date createDate = cal1.getTime();
        String formattedDate2 = sdf.format(createDate);
        int dayOfYr = cal1.get(Calendar.DAY_OF_YEAR);

        System.out.println("2 Formatted Date: " + formattedDate2);
        System.out.println("Day od the year is " + dayOfYr);

        /**
         * Lab Activity 3
         */
        System.out.println("\nSolution for Lab 3");
        Date date3 = new Date();
        Calendar firstDate = Calendar.getInstance();
        Calendar secondDate = Calendar.getInstance();
        secondDate.add(Calendar.DATE, -7);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println(df.format(date3));
        System.out.println(df.format(secondDate.getTime()));
        System.out.println(DateUtilities.dateDiff(DateUtilities.DAY_UNITS, firstDate, secondDate));

        /**
         * Lab Activity 4
         */
        System.out.println("\nSolution for Lab 4");
        Date date4 = new Date();
        Calendar firstDate4 = Calendar.getInstance();
        Calendar secondDate4 = Calendar.getInstance();
        secondDate.add(Calendar.DATE, 30);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println(df4.format(date3));
        System.out.println(df4.format(secondDate.getTime()));
        System.out.println(DateUtilities.dateDiff(DateUtilities.DAY_UNITS, firstDate, secondDate));

        /**
         * Lab Activity 5
         */
        System.out.println("\nSolution for Lab 5");
        String strDate = "Tuesday, April 12, 1952 AD or 3:30:42pm PST";
        date = null;

        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL); // LONG stle

        try {
            // now parse the String "strDate" into a date object
            date = df5.parse(strDate);
        } catch (ParseException pe) {
            System.out.println("Couldn't parse the date. Reason: " + pe);
            System.out.println("\nA typical date format would look like this:");
            System.out.println(new Date());
        }

        System.out.println(date);
    }
}
