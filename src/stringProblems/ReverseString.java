package stringProblems;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {


    public static void main(String[] args) {
        String str = "My name is Divya";
        ReverseString reverseString = new ReverseString();
        reverseString.completeReverse(str);
        reverseString.wordsReverse(str);
        reverseString.intraWordReverse(str);

    }

    /**
     * ayviD si eman yM
     *
     * @param input
     */
    void completeReverse(String input) {
        char[] st = input.toCharArray();
        int j = st.length - 1;
        for (int i = 0; i < st.length / 2; i++) {
            char temp = st[i];
            st[i] = st[j];
            st[j] = temp;
            j--;
        }

        System.out.println(String.valueOf(st));
    }

    void intraWordReverse(String input) {
        String[] st = input.split(" ");
        System.out.println(Stream.of(st).map(i->new StringBuilder(i).reverse()).collect(Collectors.joining(" ")));
}

    /**
     * Divya is name My
     *
     * @param input
     */
    void wordsReverse(String input) {
        String[] st = input.split(" ");
        int j = st.length - 1;
        for (int i = 0; i < st.length / 2; i++) {
            String temp = st[i];
            st[i] = st[j];
            st[j] = temp;
            j--;
        }
//        System.out.println(Stream.of(st).map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(String.join(" ", st));
    }
}
