//import org.json.JSONException;
//import org.json.JSONObject;

/**
 * Created by Divya.Gupta on 06-04-2017.
 */
public class StringTesting {

    public static void main(String[] args) {
//        String str="{\"talismanOtherUserDetail\":[{\"propertyid\":\"16244233\",\"advertiser_Number\":\"null\"]}";
//
//
//        try {
//            JSONObject jsonObject=new JSONObject(str);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        String propIds = " 23360525,23736559,23360525,23736559,23360525,23736559, ";
//        String newLen=propIds.substring(0, propIds.lastIndexOf(","));
//            propIdsToUpdt.append(",").append(prop.substring(0, newLen));
//        String[] propStr=propIds.split(",");
//
//        for(String s:propStr){
//            System.out.println("without trim"+s);
//        }
//        System.out.println(newLen.trim());
//        String[] propStr1=propIds.split(",");
//
//        for(String s:propStr){
//            System.out.println("without trim"+s.trim());
//        }


//        String prop = "16747792,19329765,23360525,23736559,16747792,19329765,23360525,23736559,16747792,19329765," +
//                "23360525,23736559,23360525,23736559,23360525,23736559,23360525,23736559";
//        StringBuilder propIdsToUpdt = new StringBuilder();
//        propIdsToUpdt.append(propIds);
//        int maxLen = 128 - (propIds.length() - 1);
//        if (maxLen > prop.length())
//            propIdsToUpdt.append(",").append(prop);
//        else {
//            int newLen=prop.substring(0, maxLen).lastIndexOf(",");
//            propIdsToUpdt.append(",").append(prop.substring(0, newLen));
//        }
//        System.out.println(propIdsToUpdt.length());
//        System.out.println(propIdsToUpdt.toString());

//        if (prop.toString()))
//        tpUsrShrtLstPropToUpdt.setPropIds(propIdsToUpdt.toString());
//        else{
//
//        }


        String a = "Devesh is my name";

int startIndex=a.lastIndexOf(" ");
        int endIndex=a.length()-1;

        System.out.print(a.substring(startIndex, endIndex));
        System.out.print(" ");

//        int startIndex = 0;
//        int endIndex = a.length() - 1;
//        for (int i = a.length() - 1; i >= 0; i--) {
//
//            if (a.charAt(i) == ' ' || i == 0) {
//                startIndex = i == 0 ? i : i + 1;
//
//                while (startIndex <= endIndex) {
//                    System.out.print(a.charAt(startIndex));
//                    startIndex++;
//                }
//
//                if (i != 0)
//                    System.out.print(a.charAt(i));
//                if (startIndex > endIndex) {
//                    endIndex = i - 1;
//                }
//            }
//        }


    }

//    class Employee;


}
