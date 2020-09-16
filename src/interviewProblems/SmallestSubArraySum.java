package interviewProblems;


/*
 Instructions to candidate.
  1) Your task is ultimately to implement arr function that takes in an array of non-negative numbers and an integer.
   You want to return the *LENGTH* of the shortest subarray whose sum is at least the integer,
   and -1 if no such sum exists.
  2) Run this code in the REPL to observe its behaviour. The
   execution entry point is main().
  3) Consider adding some additional tests in doTestsPass().
  4) Implement subArrayExceedsSum() correctly.
  5) If time permits, some possible follow-ups.
*/

public class SmallestSubArraySum {
    public static int subArrayExceedsSum(int arr[], int target) {

        // stores the current window sum
        int windowSum = 0;
        // stores the result
        int n = Integer.MAX_VALUE;
        // stores window's starting index
        int j = 0;

        // maintain arr sliding window [j..i]
        for (int i = 0; i < arr.length; i++) {
            // include current element in the window
            windowSum += arr[i];

            // window becomes unstable if its sum becomes more than target
            while (windowSum >= target && j <= i) {
                // update the result if current window's length is less
                // than minimum found so far
                n = Integer.min(n, i - j + 1);

                // remove elements from the window's j side till window
                // becomes stable again
                windowSum -= arr[j];
                j++;
            }
        }

        // return result
        if (n == Integer.MAX_VALUE)
            return -1;
        else
            return n;

    }

    /**
     * int doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        boolean result = true;
        int[] arr = {1, 2, 3, 4};

        result = result && subArrayExceedsSum(arr, 6) == 2;
        result = result && subArrayExceedsSum(arr, 12) == -1;

        return result;
    }

    ;

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All tests pass\n");
        } else {
            System.out.println("There are test failures\n");
        }
    }
};

