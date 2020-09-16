package interviewProblems;

import java.util.Arrays;

public class SmallestBiggestProblem {
    public static void main(String[] args) {
        int arr[] = {0, 2, 1, 5, 4, 3};

//      Output:  arr= 0,5,1,4,2,3
//
        int n = arr.length;
        Arrays.sort(arr);
        int max = arr[n - 1];

        int i = 1, j = n - 1;
        while (i <= j) {
            if(arr[j]>arr[i]) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            if (i % 2 == 0) {
                i++;
            } else
                j--;

        }

        for (int k = 0; k < n; k++) {
            System.out.println(arr[k]);
        }

    }
}
