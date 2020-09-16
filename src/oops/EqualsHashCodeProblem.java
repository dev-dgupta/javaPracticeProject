package oops;

/**
 * Created by Divya.Gupta on 03-04-2018.
 */
public class EqualsHashCodeProblem {

    public static void main(String[] args) {
        String a="Divya";
        String b="Divya";
        String c=new String("Divya");
        String d=new String(c);
        String e=new String("Divya").intern();
        String f=b;
        String g=d;
//        String a="Divya";
//        String b="Ebay";
//        String c=new String("Divya");
//        String d=new String(a);
//        String g=d;
//        String e=b;
//        String f=c;
//        Integer a = 1;
//        Integer b = 1;
//        Integer c = new Integer(1);
//        Integer h = new Integer(c);
//        Integer d = 1;
//        Integer g = new Integer(1);
//        Integer e = d;
//        Integer f = b;

        System.out.println(a == b);
//        System.out.println(a.equals(b));
        System.out.println(a == c);
//        System.out.println(a.equals(c));
//        System.out.println(c == h);
//        System.out.println(c.equals(h));

        System.out.println(c == d);
//        System.out.println(g.equals(a));

        System.out.println(e == a);
//        System.out.println(g.equals(h));

        System.out.println(f == e);
//        System.out.println(g.equals(c));

        System.out.println(g == c);
//        System.out.println(d.equals(g));

        System.out.println(d == g);
//        System.out.println(c.equals(f));
    }
}
