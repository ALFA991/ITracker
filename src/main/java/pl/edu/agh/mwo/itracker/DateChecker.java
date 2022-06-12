package pl.edu.agh.mwo.itracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class DateChecker {

//    String date = "01/01/2020";
//    String regex = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-](\\d{4})$";
//    DateChecker dc = new DateChecker(regex);
//		System.out.println(dc.check(date));

    private static final int LEAP_STEP = 4;
    private Matcher matcher;
    private Pattern pattern;

    public DateChecker(String regex) {
        pattern = Pattern.compile(regex);
    }

    /**
     * Checks if the date format is a valid.
     * Uses the regex pattern to match the date first. 
     * Than additionally checks are performed on the boundaries of the days taken the month into account (leap years are covered).
     * 
     * @param date the date that needs to be checked.
     * @return if the date is of an valid format or not.
     */
    public boolean check(final String date) {
        matcher = pattern.matcher(date);
        if (matcher.matches()) {
            matcher.reset();
            if (matcher.find()) {
                int day = Integer.parseInt(matcher.group(1));
                int month = Integer.parseInt(matcher.group(2));
                int year = Integer.parseInt(matcher.group(3));

                switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: return day < 32;
                case 4:
                case 6:
                case 9:
                case 11: return day < 31;
                case 2:
                    int modulo100 = year % 100;
                    //http://science.howstuffworks.com/science-vs-myth/everyday-myths/question50.htm
                    if ((modulo100 == 0 && year % 400 == 0) || (modulo100 != 0 && year % LEAP_STEP == 0)) {
                        //its a leap year
                        return day < 30;
                    } else {
                        return day < 29;
                    }
                default:
                    break;
                }
            }
        }
        return false;
    }

    public boolean check(final Date date)  {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateStart = null;

        try {
            dateStart = sdf.parse("01/01/2010");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date dateNow = new Date();

        if (date.after(dateStart) && date.before(dateNow)) {
            return true;
        }
        return false;
    }

    private Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }

    public String getRegex() {
        return pattern.pattern();
    }
}