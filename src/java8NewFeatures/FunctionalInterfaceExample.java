package java8NewFeatures;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

    }
}


interface DeafaultMethodInt {

    default void methA() {
        System.out.println("ABC");
    }

    default void methB() {
        System.out.println("BCD");
    }


    void methE();

}

@FunctionalInterface
interface FunctionalMethodInt {

    default void methA() {
        System.out.println("ABC");
    }

    void methE();
}

class Asd implements DeafaultMethodInt,FunctionalMethodInt{


    @Override
    public void methB() {

    }

    @Override
    public void methE() {

    }

    @Override
    public void methA() {
        DeafaultMethodInt.super.methA();
    }
}