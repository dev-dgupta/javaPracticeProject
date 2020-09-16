package encryption;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by Divya.Gupta on 22-02-2017.
 */
public class DateTests {

//    public static void main(String[] args) {
//        checkForNonceExpiry(48789938L, "(GMT+09:00) Japan Standard Time (Asia/Tokyo)".trim());
//    }

    private static boolean checkForNonceExpiry(long nonce, String timezone) {
        Calendar cal = Calendar.getInstance();

        String timeZoneVal = (cal.getTimeZone().getDisplayName() + " (" + cal.getTimeZone().getID() + ")").trim();
        TimeZone tz = null;
        if (!timezone.equalsIgnoreCase(timeZoneVal)) {
            //find correct timezone
            boolean foundTZ = false;
            for (String availId : TimeZone.getAvailableIDs()) {
                if (timezone.trim().equalsIgnoreCase(TimeZone.getTimeZone(availId).getDisplayName())) {
                    tz = TimeZone.getTimeZone(availId);
                    foundTZ = true;
                    break;
                }
            }
            cal.setTimeZone(tz);
            long date = System.currentTimeMillis();
            int offset = tz.getOffset(date);
            System.out.printf("%d + %d = %d%n", date, offset, date + offset);
            nonce = 0;
        }

        return (nonce - System.currentTimeMillis() > 120000);
    }


    public static void main(String[] args) {

        String[] ids = TimeZone.getAvailableIDs();
        String result = "";
        for (String id : ids) {
            result = displayTimeZone(TimeZone.getTimeZone(id));
            System.out.println(result + "(\"" + result + "\"),");
        }

        System.out.println("\nTotal TimeZone ID " + ids.length);

    }

    private static String displayTimeZone(TimeZone tz) {

        long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
        long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset()) - TimeUnit.HOURS.toMinutes(hours);
        // avoid -4:-30 issue
        minutes = Math.abs(minutes);

        String result = "";
        if (hours > 0) {
            result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
        } else {
            result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
        }

//        System.out.println(getFinalResult(result + " (" + tz.getID() + ")") + "(\"" + result + " (" + tz.getID() + ")" + "" + "\")" + ",");
//        System.out.println(getFinalResult(result) + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
//        System.out.println(getFinalResult(result + " " + tz.getID()) + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
//        String result2 = "";
//        if (hours > 0) {
//            result2 = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
//        } else {
//            result2 = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
//        }
//        System.out.println(getFinalResult(result2 + " (" + tz.getID() + ")") + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
//        System.out.println(getFinalResult(result2) + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
//        System.out.println(getFinalResult(result2 + " " + tz.getID()) + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
//        System.out.println(getFinalResult(" (" + tz.getID() + ")") + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
//        System.out.println(getFinalResult(tz.getDisplayName()) + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
//        System.out.println(getFinalResult(tz.getID()) + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
//        System.out.println(getFinalResult(tz.getDisplayName() + " " + tz.getID()) + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
//        System.out.println(getFinalResult(tz.getDisplayName() + " (" + tz.getID() + ")") + "(\"" + result + " (" + tz.getID() + ")" + "\"),");
////        System.out.println(getFinalResult(tz.toString()) + "\"" + result) + " (" + tz.getID() + ")" + "\"),");
        return result;

    }

    private static String getFinalResult(String result) {
        return result.replace(" ", "_");
    }

}
