package dataStructures.arrays;

import java.util.Arrays;

/**
 * input = 218765
 * output = 251678
 *
 * the idea is to get first number from right which is smaller than the rightmost number.
 * then sort all the digits and swap them.
 */
public class FindNextNumber {

    public static void main(String[] args) {
        getNextNumber(2148756L);
    }

    public static void getNextNumber(Long num) {
        String s = num.toString();
        int n = s.length();

        char[] arr = s.toCharArray();
        int j;
        for (j = n - 1; j > 0; j--) {
            if (Long.parseLong(String.valueOf(arr[j])) > Long.parseLong(String.valueOf(arr[j - 1])))
                break;
        }
        if (j == 0)
            System.out.println(-1L);
        else {
            Arrays.sort(arr, j, n);   //215678

            char temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
            System.out.println(arr);

        }
    }
}
