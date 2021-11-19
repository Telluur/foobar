package com.withgoogle.foobar.level1;

public class Solution {
    public static String solution(String x) {
        return x.chars()
                .mapToObj(c -> Character.isLowerCase(c) ? (char) 25 - c + (2 * 'a') : (char) c)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


    public static void main(String[] args) {
        System.out.println(Solution.solution("Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!"));
        System.out.println(Solution.solution("wrw blf hvv ozhg mrtsg'h vkrhlwv?"));
    }
}
