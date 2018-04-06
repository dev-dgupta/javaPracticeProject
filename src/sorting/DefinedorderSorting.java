package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Divya.Gupta on 28-03-2018.
 */
public class DefinedorderSorting {

    private final static List<String> preDefinedOrder = Arrays.asList("#", "!", "@", "%", "&", "*");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int noOfTests = sc.nextInt();

        while (noOfTests > 0) {
            int nutBoltSize = sc.nextInt();
            if (nutBoltSize <= 0)
                continue;
            String nutsArr=null;
            while (sc.hasNextLine())
                 nutsArr = sc.nextLine();
            String boltsArr = sc.nextLine();

            System.out.println(nutsArr);
            Arrays.sort(new char[][]{nutsArr.toCharArray()}, new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {
                    return Integer.valueOf(preDefinedOrder.indexOf(o1)).compareTo(Integer.valueOf(preDefinedOrder.indexOf(o2)));
                }
            });


            System.out.println(nutsArr);
            System.out.println(boltsArr);

            Arrays.sort(new char[][]{boltsArr.toCharArray()}, new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {
                    return Integer.valueOf(preDefinedOrder.indexOf(o1)).compareTo(Integer.valueOf(preDefinedOrder.indexOf(o2)));
                }
            });


            System.out.println(boltsArr);
            noOfTests--;
        }

    }


    String returnScannerInput(Scanner sc) {
        while (sc.hasNextLine())
            return sc.nextLine();
        return null;
    }
}
