package com.leetcode.solution.string;

import java.util.*;

/**
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).
 * <p>
 * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.
 * <p>
 * For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
 * <p>
 * Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * <p>
 * All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "ed" starts at index 2 in S, so it's replaced by "ffff".
 * Example 2:
 * <p>
 * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "ec" doesn't starts at index 2 in the original S, so we do nothing.
 * Notes:
 * <p>
 * 0 <= indexes.length = sources.length = targets.length <= 100
 * 0 < indexes[i] < S.length <= 1000
 * All characters in given inputs are lowercase letters.
 *
 * @author dadisdad
 * @date 2018/5/13
 */
public class FindReplaceString {

    /**
     * TODO
     *
     * @param S
     * @param indexes
     * @param sources
     * @param targets
     * @return
     */
    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int size = indexes.length;
        int s_size = S.length();
        if (size == 0) {
            return S;
        }
        List<Pair<Integer, Integer>> v = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            v.add(Pair.makePair(indexes[i], i));
        }
        Collections.sort(v, Comparator.comparing(Pair::getFirst));
        String ans = "";
        if (v.get(0).getFirst() != 0) {
            ans = ans.concat(S.substring(0, v.get(0).getFirst()));
        }

        for (int i = 0; i < size; i++) {
            int index = v.get(i).getFirst();
            int id = v.get(i).getSecond();
            int next_index = (i == size - 1) ? s_size : v.get(i + 1).getFirst();
            if (compare(S, s_size, index, sources[id])) {
                ans = ans.concat(targets[id]);
                int middle_index = index + sources[id].length();
                ans = ans.concat(S.substring(middle_index, next_index));
            } else {
                ans = ans.concat(S.substring(index, next_index));
            }
        }
        return ans;
    }

    private static boolean compare(String s, int size, int index, String sources) {
        int length = sources.length();
        int len = index + length;
        if (len > size) {
            return false;
        }
        for (int i = index, j = 0; i < len; i++, j++) {
            if (s.charAt(i) != sources.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findReplaceString("abcd", new int[]{1, 2}, new String[]{"b", "cd"}, new String[]{"eee", "ffff"}));
    }

}

class Pair<T, E> {

    private T first;

    private E second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    public static <T, E> Pair<T, E> makePair(T first, E second) {
        Pair<T, E> pair = new Pair<>();
        pair.setFirst(first);
        pair.setSecond(second);
        return pair;
    }
}