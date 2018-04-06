import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Divya.Gupta on 26-03-2017.
 */
public class ArrayListOrder {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");

        System.out.println("list");
        for (String s : arrayList) {
            System.out.println(s);
        }
        List<String> arrayList2 = new ArrayList<String>();
        int ctr = 0;
        Set<String> stringSet = new HashSet<String>();
        if (stringSet.add("y")) {
            arrayList2.add("y");
            ctr++;
        }
        if (stringSet.add("f")) {
            arrayList2.add("f");
            ctr++;
        }
        if (stringSet.add("a")) {
            arrayList2.add("a");
            ctr++;
        }


        for (String s : arrayList) {
            if (stringSet.add(s)) {
                arrayList2.add(s);
                ctr++;
            }

            if (5 == ctr)
                break;
        }

        System.out.println("\n\nPrevious list");
        for (String s : arrayList) {
            System.out.println(s);
        }

        System.out.println("\n\nNew list");
        for (String s : arrayList2) {
            System.out.println(s);
        }


    }
}
