package com.withgoogle.foobar.level2.gearingupfordestruction;

import java.util.Arrays;

public class Solution {


    public static int[] solution(int[] pegs) {
        final int[] NO_SOLUTION_FOUND_VALUE = {-1, -1};

        if (pegs.length < 2) {
            return NO_SOLUTION_FOUND_VALUE;
        }

        int d = 0;
        int sign = -1;
        int maxEvenD = Integer.MIN_VALUE;
        int minOddD = Integer.MAX_VALUE;

        for (int i = 0; i < pegs.length - 1; i++) {
            d -= sign * (pegs[i + 1] - pegs[i]);
            sign *= -1;

            if (isOdd(i)) {
                maxEvenD = Math.max(maxEvenD, d);
            } else {
                minOddD = Math.min(minOddD, d);
            }
        }


        int num = 2 * d;
        int den = Math.abs(1 + sign * 2);

        boolean evenCond = num < den * (maxEvenD + 1);
        boolean oddCond = num > den * (minOddD - 1);

        if (evenCond || oddCond) {
            return NO_SOLUTION_FOUND_VALUE;
        }

        if (sign == 1 && num % 3 == 0) {
            num = Math.abs(Math.floorDiv(num, 3));
            den = 1;
        }

        return new int[]{num, den};
    }


    /**
     * Performant odds checking by checking LSB bit.
     *
     * @param i int to be checked
     * @return whether int is odd.
     */
    public static boolean isOdd(int i) {
        return (i & 1) != 0;
    }


    public static void main(String[] args) {
        test(solution(new int[]{4, 17, 50}), new int[]{-1, -1});
        test(solution(new int[]{4, 30, 50}), new int[]{12, 1});
        test(solution(new int[]{1, 51}), new int[]{100, 3});
        test(solution(new int[]{1, 31}), new int[]{20, 1});
        test(solution(new int[]{1, 31, 51, 71}), new int[]{20, 1});
        test(solution(new int[]{1, 31, 51, 71, 91}), new int[]{20, 1});
        test(solution(new int[]{4, 9, 17, 31, 40}), new int[]{4, 1});
    }


    public static void test(int[] solution, int[] expected) {
        System.out.printf("Test: %s, solution: %s, expected: %s%n",
                Arrays.equals(solution, expected) ? "pass" : "fail",
                Arrays.toString(solution),
                Arrays.toString(expected));
    }

}
