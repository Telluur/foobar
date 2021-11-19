package com.withgoogle.foobar.level3.perfectfuelinjection;

import java.math.BigInteger;

public class Solution {

    public static final BigInteger THREE = new BigInteger("3");


    public static int solution(String x) {
        BigInteger n = new BigInteger(x);
        int steps = 0;

        System.out.printf("%s", n);
        while (n.compareTo(BigInteger.ONE) > 0) {
            steps += 1;
            if (!n.testBit(0)) {
                //True if LSB == 0, which implies even number.
                n = n.shiftRight(1); //Efficient division by 2.
            } else if (n.equals(THREE) || (!n.testBit(1) && n.testBit(0))) {
                // n == 3 or last two bits == 01
                n = n.subtract(BigInteger.ONE);
            } else {
                n = n.add(BigInteger.ONE);
            }
            System.out.printf(" -> %s", n);
        }
        System.out.printf("%n");
        return steps;
    }

    public static void main(String[] args) {
        test(solution("4"), 2);
        test(solution("12"), 4);
        test(solution("15"), 5);
        test(solution("30"), 6);
    }


    public static void test(int solution, int expected) {
        System.out.printf("Test: %s, solution: %d, expected: %d%n",
                solution == expected ? "pass" : "fail",
                solution,
                expected);
    }
}
