package com.flexpayment.dateformat;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * This class is for parsing letter date to DD-MMM-YYYY format
 * 
 */

/**
 *
 * @author Movla Aliyev
 * 
 */

// please Jesus help me with it _/\_
public class LetterDateFX extends IDFormatFX {

  /**
    *
    * Constructor for nothing like me
    * 
    */
    public LetterDateFX() {
    }

    /**
     * Getting a day from letter date ex: 1november2017
     * 
     * <p>
     * @param date date should be parsed or return empty string if couldn't parse
     * 
     * @return day from date
     * 
     */
    @Override
    protected String getDay(String date) {
        Matcher matcher = Pattern.compile("\\d+").matcher(date);
        matcher.find();
        return String.valueOf(matcher.group());
    }

    /**
     * Getting a month from letter date ex: 1november2017
     *
     * @param date date should be parsed or return empty string if couldn't parse
     * 
     * @return month from date
     * 
     */
    @Override
    protected String getMonth(String date) {
 
        String cleanedDate = cleanDate(date);            // cleaning additional symbols from date
        String month = date.replaceAll("[^A-Za-z]", ""); // getting string from date which should be a month

        String monthAz; 
        String monthEng;

        // list of default months in az and eng
        String[] monthsAz = {"yanvar", "fevral", "mart", "aprel", "may", "iyun", "iyul", "avqust", "sentyabr", "oktyabr", "noyabr", "dekabr"};
        String[] monthsEn = {"january", "feburary", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};

        String newMonth = "";

        // start checking for az date loop count is 12 which is equal to months in a year
        for (int i = 0; i < 12; i++) {
            /*
                checking passed month length with month in list in case of additional string in passed month
                ex: novemberciil against november
            */
            if (month.length() > monthsAz[i].length()) {
                newMonth = month.substring(0, monthsAz[i].length());
            } else {
                newMonth = month;
            }

            // check if month found ex: november.contains(nov);
            if (monthsAz[i].contains(newMonth.toLowerCase())) {
                return monthsAz[i];
            }
        }

        // same for eng months
        for (int i = 0; i < 12; i++) {

            int mL  = month.length();
            int mEL = monthsEn[i].length();

            if (month.length() > monthsEn[i].length()) {
                newMonth = month.substring(0, monthsEn[i].length());
            } else {
                newMonth = month;
            }

            if (monthsEn[i].contains(newMonth.toLowerCase())) {
                return monthsEn[i];
            }

            // if not found make additional checking for eng one
            // if found return true and stop searching if not continue 
            if (checkAdvanced(monthsEn[i], newMonth)) {
                return monthsEn[i];
            }
        }

        // if nothing found return empty string
        return "";
    }

    /**
     * clean additional symbols from date ex: 1\november\2017 -> 1november2017
     *
     * @param date date which should parse
     * 
     * @return cleaned date
     * 
     */
    private String cleanDate(String date) {
        return date.replaceAll("[^a-zA-Z0-9]", "");
    }

    
    /**
     * Getting a year from letter date ex: 1november2017
     *
     * @param date date should be parse or empty string if couldnt parse
     * 
     * @return year from date
     * 
     */
    @Override
    protected String getYear(String date) {
        Matcher matcher = Pattern.compile("(\\d+)(?!.*\\d)").matcher(date);
        matcher.find();
        return String.valueOf(matcher.group());
    }

    /**
     * starting parsing operation
     *
     * @param date date which should parse
     * 
     * @return parsed date or empty string
     * 
     */
    @Override
    protected String parse(String date) {
        String day   = getDay(date);     // getting day from date
        String month = getMonth(date); // getting month from date
        String year  = getYear(date);   // getting year from date

        // translate month to english if month is az if not return null
        if (monthTranslate(month) != null) {
            month = monthTranslate(month);
        }
        // if cant parse day or month or year return empty string
        if (year.isEmpty() || month.isEmpty() || year.isEmpty()) {
            return "";
        }

        // finalize parsing and return result if error not occured
        return day + "-" + month.substring(0, 3).toUpperCase() + "-" + year;
    }

    /**
     * translate az months to eng
     *
     * @param month month which must translate
     * 
     * @return translated month
     * 
     */
    private String monthTranslate(String month) {
        Map<String, String> engMonth = new HashMap<>();
        engMonth.put("yanvar", "JAN");
        engMonth.put("fevral", "FEB");
        engMonth.put("mart", "MAR");
        engMonth.put("aprel", "APR");
        engMonth.put("may", "MAY");
        engMonth.put("iyun", "JUN");
        engMonth.put("iyul", "JUL");
        engMonth.put("avqust", "AUG");
        engMonth.put("sentyabr", "SEP");
        engMonth.put("oktyabr", "OCT");
        engMonth.put("noyabr", "NOV");
        engMonth.put("dekabr", "DEC");

        return engMonth.get(month);
    }
    
    
    /**
     * make final search for short date ex: 1nov2017 (only for eng month case)
     *
     * @param currentMonth month which in default list
     * @param month        which is searching
     * @return true in case of found false in case of not found
     * 
     */
    private boolean checkAdvanced(String currentMonth, String month) {
        
        // checking first 3 letter if any of them is not match return false
        for (int i = 0; i < 3; i++) {
            char c = currentMonth.charAt(i);
            char m = month.charAt(i);
            if (currentMonth.charAt(i) != month.toLowerCase().charAt(i)) {
                return false;
            }
        }

        return true;
    }

}

// thanks Jesus 
