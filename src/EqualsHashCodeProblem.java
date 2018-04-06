/**
 * Created by Divya.Gupta on 03-04-2018.
 */
public class EqualsHashCodeProblem {

    public static void main(String[] args) {
//        String a="Divya";
//        String b="Divya";
//        String c=new String("Divya");
//        String d=new String(c);
//        String g=new String("Divya");
//        String e=b;
//        String f=d;

//        Integer a = 1;
//        Integer b = 1;
//        Integer c = new Integer(1);
//        Integer h = new Integer(c);
//        Integer d = 1;
//        Integer g = new Integer(1);
//        Integer e = d;
//        Integer f = b;

        String a="Divya";
        String b="Ebay";
        String c=new String("Divya");
        String d=new String(a);
        String g=d;
        String e=b;
        String f=c;


        System.out.println(g == h);
        System.out.println(g.equals(h));

        System.out.println(g == c);
        System.out.println(g.equals(h));

        System.out.println(d == g);
        System.out.println(d.equals(g));

        System.out.println(f == c);
        System.out.println(c.equals(f));
    }
}
