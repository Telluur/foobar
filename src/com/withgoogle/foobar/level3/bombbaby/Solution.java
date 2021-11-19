package com.withgoogle.foobar.level3.bombbaby;

import java.math.BigInteger;

public class Solution {

    public static String solution(String m, String f) {
        BigInteger M = new BigInteger(m);
        BigInteger F = new BigInteger(f);
        BigInteger steps = BigInteger.ZERO;

        while (!(M.equals(BigInteger.ONE) && F.equals(BigInteger.ONE))) {
            int comp = M.compareTo(F);
            if (comp >= 0) {
                if (F.equals(BigInteger.ONE)) {
                    steps = steps.add(M.subtract(BigInteger.ONE));
                    M = BigInteger.ONE;
                } else if (M.mod(F).equals(BigInteger.ZERO)) {
                    return "impossible";
                } else {
                    BigInteger[] bigIntegers = M.divideAndRemainder(F);
                    M = bigIntegers[1];
                    steps = steps.add(bigIntegers[0]);
                }
            } else {
                if (M.equals(BigInteger.ONE)) {
                    steps = steps.add(F.subtract(BigInteger.ONE));
                    F = BigInteger.ONE;
                } else if (F.mod(M).equals(BigInteger.ZERO)) {
                    return "impossible";
                } else {
                    BigInteger[] bigIntegers = F.divideAndRemainder(M);
                    F = bigIntegers[1];
                    steps = steps.add(bigIntegers[0]);
                }
            }
        }
        return steps.toString();
    }

    public static void main(String[] args) {
        testWrapper(2, 1, 1);
        testWrapper(1, 2, 1);


        testWrapper(4, 7, 4);
        testWrapper(7, 4, 4);

        testWrapper(10, 1, 9);
        testWrapper(1, 10, 9);


        testWrapper(10, 11, 10);
        testWrapper(11, 10, 10);


        testWrapper(122, 13, 14);
        testWrapper(13, 122, 14);

        testWrapper(70006, 7, 10006);
        testWrapper(7, 70006, 10006);

        testWrapper(2, 8, -1);
        testWrapper(8, 2, -1);

        testWrapper(2, 2, -1);


    }

    public static void testWrapper(long m, long f, long expected) {
        if (expected == -1) {
            test(solution(Long.toString(m), Long.toString(f)), "impossible");
        } else {
            test(solution(Long.toString(m), Long.toString(f)), Long.toString(expected));
        }
    }


    public static void test(String solution, String expected) {
        System.out.printf("Test: %s, solution: %s, expected: %s%n",
                solution.equals(expected) ? "pass" : "fail",
                solution,
                expected);
    }
}
