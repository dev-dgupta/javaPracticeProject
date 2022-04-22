package collectionsExample;

import com.sun.source.doctree.SeeTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class HashSetEqualsHashCodeExample {

    public static void main(String[] args) {
	// write your code here

        String a = new String();
        String b = new String();

        System.out.println(a==b);
        System.out.println(a.equals(b));

        Set<String> set= new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(set.size());

    }
}
