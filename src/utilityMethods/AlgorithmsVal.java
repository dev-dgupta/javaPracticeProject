package utilityMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Divya.Gupta on 29-03-2017.
 */
public class AlgorithmsVal {

    public static void main(String[] args) {

        getTime();
//        System.out.println(roundUpNumberByUsingMultipleValue(163, 100));
//        System.out.println(roundUpNumberByUsingMultipleValue(123, 100));
//        System.out.println(roundUpNumberByUsingMultipleValue(13163, 100));
//        System.out.println(roundUpNumberByUsingMultipleValue(13143, 100));
    }

    public static int roundUpNumberByUsingMultipleValue(double number, int multiple) {
        int result = multiple;
        double val = number % multiple;
        if (val == 0) {
            return (int) number;
        }
        if (val != 0) {
            int division = 0;
            if (val > 50)
                division = (int) ((number / multiple) + 1);
            else
                division = (int) (number / multiple);
            result = division * multiple;
        }
        return result;
    }

    public static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void getTime() {

        String sqlQuery = "from time 'startTime' to 'endTime'";
        //contacts for past 5 minutes

        Calendar cal = Calendar.getInstance();
        String starttime = TIMESTAMP_FORMAT.format(cal.getTime());
        sqlQuery = sqlQuery.replaceAll("startTime", starttime);

        cal.add(Calendar.MINUTE, -5);
        String endTime = TIMESTAMP_FORMAT.format(cal.getTime());
        sqlQuery = sqlQuery.replaceAll("endTime", endTime);
        System.out.println(sqlQuery);

    }
}

