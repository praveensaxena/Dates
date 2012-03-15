package dates;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Here are some examples of using TimeZone and Locale to affect
 * format and values associated with Date, Time and Numbers.
 * 
 * @author jlombardo
 */
public class FormatToLocale {
    public static void main(String[] args) {
                
        // Lookup table for numeric value references
        String[] months = {
            "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY",
            "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
            "NOVEMBER", "DECEMBER"
        };
        
        // Language code for Arabic: ar; Country code for Saudi Arabia
        // See for Language codes: 
        //      http://www.loc.gov/standards/iso639-2/php/English_list.php
        // See for Country codes: 
        //      http://userpage.chemie.fu-berlin.de/diverse/doc/ISO_3166.html
        Locale loc = new Locale("hi","IN");
        TimeZone tz = TimeZone.getTimeZone("GMT+6:30");
        Calendar cal = Calendar.getInstance(tz,loc);
        System.out.println("Month in " + loc.getDisplayName() + ": " 
                + months[cal.get(Calendar.MONTH)]);
        System.out.println("Day in " + loc.getDisplayName() + ": " 
                + cal.get(Calendar.DATE));
        System.out.println("Hour in " + loc.getDisplayName() + ": " 
                + cal.get(Calendar.HOUR));
        System.out.println("AM_PM in " + loc.getDisplayName() + ": " 
                + (cal.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
        Date date = cal.getTime();
        DateFormat df = 
                SimpleDateFormat.getDateTimeInstance(
                    DateFormat.LONG, DateFormat.LONG,loc);
        System.out.println("\nLong form of DATE/TIME for India:");
        System.out.println("(Notice the hour is local time: based on runtime engine location)");
        System.out.println(df.format(date) + " : " + loc.getDisplayName());
        
        System.out.println("\nA dollar amount formatted in French:");
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRENCH);
        double money = 12456.34;
        String strMoney = nf.format(money);
        System.out.println(strMoney + " : " + Locale.FRENCH.getDisplayName());
        
        System.out.println("\nSome other DATE/TIME formats for various countries:");
        //
        // Defines an array of Locales using the built in constants,
        // which are only a subset of all the country codes possible
        //
        Locale[] locales = new Locale[] {
                Locale.US,
                Locale.JAPAN,
                Locale.CHINA,
                Locale.KOREA,
                Locale.TAIWAN,
                Locale.ITALY,
                Locale.FRANCE,
                Locale.GERMAN
        };

        //
        // Iterates the entire Locale defined above and create a long 
        // formatted date using the SimpleDateFormat.getDateInstance() 
        // with the format, the Locale and the date information.
        //
        for (Locale locale : locales) {
            System.out.println("Date format in " 
                + locale.getDisplayName() 
                + " = " 
                + SimpleDateFormat.getDateTimeInstance(
                      SimpleDateFormat.LONG, SimpleDateFormat.LONG, locale)
                          .format(date).toUpperCase());
        }
        
        // See a list of time zones supported by Java
        System.out.println("\nTime Zones supported by Java:");
        String[] zones = TimeZone.getAvailableIDs();
        for(String zone : zones) {
            System.out.println(zone);
        }
        
        // See a list of Locale(s) supported by Java
        System.out.println("\nLocales supported by Java:");
        Locale[] locs = Locale.getAvailableLocales();
        for(Locale lo : locs) {
            System.out.println(lo + " : " + lo.getDisplayCountry());
        }

    }
}
