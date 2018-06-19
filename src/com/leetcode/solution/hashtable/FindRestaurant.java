package com.leetcode.solution.hashtable;

import java.util.*;

/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * <p>
 * 示例 1:
 * <pre>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * </pre>
 * 示例 2:
 * <pre>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * </pre>
 * 提示:
 * <p>
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 *
 * @author dadisdad
 * @date 2018/6/19
 */
public class FindRestaurant {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> list1Map = new HashMap<>();
        Map<String, Integer> list2Map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            list1Map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            list2Map.put(list2[i], i);
        }
        TreeMap<Integer, List<String>> sameMap = new TreeMap<>();
        Map<String, Integer> map1;
        Map<String, Integer> map2;
        int minIndexSum = 0;
        if (list1.length >= list2.length) {
            map1 = list1Map;
            map2 = list2Map;
        } else {
            map1 = list2Map;
            map2 = list1Map;
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                minIndexSum = map2.get(entry.getKey()) + entry.getValue();
                if (sameMap.containsKey(minIndexSum)) {
                    List<String> list = sameMap.get(minIndexSum);
                    list.add(entry.getKey());
                    sameMap.put(minIndexSum, list);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(entry.getKey());
                    sameMap.put(minIndexSum, list);
                }
            }
        }
        return sameMap.get(sameMap.firstKey()).toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }
}
