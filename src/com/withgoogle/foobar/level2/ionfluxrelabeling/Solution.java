package com.withgoogle.foobar.level2.ionfluxrelabeling;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] solution = Solution.solution(5, new int[]{19, 14, 28});
        System.out.println(Arrays.toString(solution));

        int[] solution2 = Solution.solution(3, new int[]{7, 3, 5, 1});
        System.out.println(Arrays.toString(solution2));
    }


    public static int[] solution(int h, int[] q) {
        HashMap<Integer, Integer> map = createLabelParentMap(h);
        return Arrays.stream(q).map(map::get).toArray();
    }

    static HashMap<Integer, Integer> createLabelParentMap(int depth) {
        HashMap<Integer, Integer> map = new HashMap<>();
        createTree(depth, numberOfNodes(depth), -1, map);
        return map;
    }

    static void createTree(int depth, int label, int parent, HashMap<Integer, Integer> labelparentmap) {
        //Add mapping of this node's label -> parent label.
        labelparentmap.put(label, parent);
        if (depth > 1) {
            //Traverse down left subtree
            createTree(depth - 1, label - 1 - numberOfNodes(depth - 1), label, labelparentmap);

            //Traverse down right subtree
            createTree(depth - 1, label - 1, label, labelparentmap);
        }
    }

    static int numberOfNodes(int depth) {
        return (int) Math.pow(2, depth) - 1;
    }

}
