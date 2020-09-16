package oops.inheritance;

public class InstanceOfCheck {
    public static void main(String[] args) {
        B b = new B(23);
        System.out.println(b instanceof B);
        System.out.println(b instanceof A);
//        System.out.println(b instanceof C);
    }
}

class A {
    A(){
        System.out.println("Super called");
    }
}

class B extends A {
    int a;

    B(int a){
        this.a=a;
    }
}

//class C extends B {
//
//    C(){}
//}
