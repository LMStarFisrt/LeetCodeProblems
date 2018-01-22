package com.leetcode.solution.array;

import java.util.Arrays;

/**
 * @author dadisdad
 * @date 2018/1/21
 */
public class RemoveElement {

    /**
     * 不开辟新的空间，在数组上删除元素，返回新的数组的长度n
     * 并且数组在0到n为新的数组
     * <br>
     * 例如：a=[3,4,5,6,3,4,5,2,3],val=3
     * <br>
     * 返回6，并且a[0]到a[5]为[4,5,6,4,5,2]
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[m++] = nums[i];
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
        return m;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 2, 3, 4, 3, 5, 6, 7, 3};
        removeElement(a, 3);
    }


}
