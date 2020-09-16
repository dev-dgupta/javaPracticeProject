package utilityMethods; /**
 * Created by Divya.Gupta on 02-02-2017.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java program to find count of repeated words in a file. * * @author
 */
public class RepeatedWordsStringUtility {
    public static void main(String args[]) {
        String filename = "D:" + File.separator + "mb" + File.separator + "mb_home_worthSMS_batch" + File.separator + "log4jLogs" + File.separator + "smsEmailBatchLog.txt";
        Map<String, Integer> wordMap = buildWordMap(filename);
        List<Entry<String, Integer>> list = sortByValueInDecreasingOrder(wordMap);
        System.out.println("List of repeated word from file and their count");
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }
    }

    public static Map<String, Integer> buildWordMap(String fileName) {

        // Using diamond operator for clean code
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        // Using try-with-resource statement for automatic resource management
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            // words are separated by whitespace
            Pattern pattern = Pattern.compile("\\s+");
            String line = null;
            while ((line = br.readLine()) != null) {
                // do this if case sensitivity is not required i.e. Java = java
                line = line.toLowerCase();
                String[] words = pattern.split(line);
                for (String word : words) {
//                    if (!isEmailCorrect(word))
//                        continue;
                    if (!isMobNumCorrect(word))
                        continue;
                    if (wordMap.containsKey(word)) {
                        wordMap.put(word, (wordMap.get(word) + 1));
                    } else {
                        wordMap.put(word, 1);
                    }
                }
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        return wordMap;
    }

    public static List<Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap) {
        Set<Entry<String, Integer>> entries = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        return list;
    }

    public static boolean isEmailCorrect(String email) {
        if (email == null || email.equalsIgnoreCase(""))
            return false;
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = pattern.matcher(email);
        boolean b = m.find();
        return !(!b || email.length() < 5);
    }

    public static boolean isMobNumCorrect(String mobileNum) {
        if (mobileNum == null || mobileNum.equalsIgnoreCase("") || mobileNum.length() != 12)
            return false;

        char[] str = mobileNum.toCharArray();
        char ch = str[0];

        if (Character.getNumericValue(ch) < 7)
            return false;

        int count = 1;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ch)
                count++;
        }

        return count != 10;
    }

    public static boolean isNRINum(short code) {
        return !(code == 91 || code == 0);
    }

}

