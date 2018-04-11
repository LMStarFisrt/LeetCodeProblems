package com.leetcode.solution.array;

import java.util.*;

/**
 * 给定两个数组，写一个方法来计算它们的交集。
 * <p>
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 * <p>
 * 注意：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 跟进:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author 10308
 * @date 2018/4/11
 */
public class Intersect {

    /**
     * 将第一个数组元素及出现次数存到Map中，遍历另一个数组，找到的话计数减一
     * 放入结果中
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            Integer value = map.get(nums1[i]);
            map.put(nums1[i], (value == null ? 0 : value) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) != null && map.get(nums2[i]) > 0) {
                tmp.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] result = new int[tmp.size()];

        for (int i = 0; i < tmp.size(); i++) {
            result[i] = tmp.get(i);
        }
        return result;
    }

    /**
     * 给两个数组排序，然后用两个索引分别代表两个数组的起始位置，
     * 如果两个索引所代表的数字相等，则将数字存入结果中，两个索引均自增1，
     * 如果第一个索引所代表的数字大，则第二个索引自增1，反之亦然。
     * <p>
     * 适合两个数组大小相差较大时
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> tmp = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                tmp.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }

        }

        int[] result = new int[tmp.size()];

        for (int k = 0; k < tmp.size(); k++) {
            result[k] = tmp.get(k);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 3, 3, 2};
        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
    }
}
