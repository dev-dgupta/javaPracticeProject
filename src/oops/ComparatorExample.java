package oops;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Divya.Gupta on 24-01-2017.
 */
public class ComparatorExample {


    public static void main(String[] args) {
        final List<String> definedOrder = // define your custom order
                Arrays.asList(null,"C","D","S");
//
//        final Map<String, String> carList = new TreeMap<String, String>(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return Integer.valueOf(
//                        definedOrder.indexOf(o1))
//                        .compareTo(
//                                Integer.valueOf(
//                                        definedOrder.indexOf(o2)));
//            }
//        });
//        carList.put("12229", "1");
//        carList.put("2345", "1");
//        carList.put("43423", "3");
//        carList.put("12205", "2");
//        carList.put("12224", "4");
//        carList.put("12226", "1");
//        carList.put("12204", "6");
//        carList.put("12206", "1");
//        carList.put("4332432", "2");
//        carList.put("333434", "1");
//
//
//        for (String a : carList.keySet()) {
//            if (definedOrder.indexOf(a) == -1)
//                carList.remove(a);
//            System.out.println(a + " " + carList.get(a));
//        }
//        System.out.println(carList);
        List<String> fruits = new ArrayList<String>();

        fruits.add("S");
        fruits.add(null);
        fruits.add("D");
        fruits.add("C");
        fruits.add("D");
        Collections.sort(fruits,new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.valueOf(
                        definedOrder.indexOf(o1))
                        .compareTo(
                                Integer.valueOf(
                                        definedOrder.indexOf(o2)));
            }
        });


        int i=0;
        for(String temp: fruits){
            System.out.println("fruits " + ++i + " : " + temp);
        }
    }


}
