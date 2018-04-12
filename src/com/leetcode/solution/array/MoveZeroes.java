package com.leetcode.solution.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 例如， 定义 nums = [0, 1, 0, 3, 12]，调用函数之后， nums 应为 [1, 3, 12, 0, 0]。
 * <p>
 * 注意事项:
 * <p>
 * 必须在原数组上操作，不要为一个新数组分配额外空间。
 * 尽量减少操作总数
 *
 * @author dadisdad
 * @date 2018/4/12
 */
public class MoveZeroes {

    /**
     * 双指针移动
     * 
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int i=0;
        int j=0;
        while(i<nums.length && j<nums.length){
            if(nums[j] == 0){
                j++;
            }else if(nums[i]!=0){
                i++;
            }else if(nums[i]==0 && nums[j]!=0 && i<j){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            }else{
                j=i+1;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int p = 0;
        // 将所有的0设为最近的非0数，p记录非0的个数；
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[p] = nums[i];
                p++;
            }
        }
        // p为非0的个数，数组剩下的就为0；
        while(p<nums.length){
            nums[p] = 0;
            p++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1,0};
        int[] nums3 = {0,1,0,3,12};
        moveZeroes2(nums1);
        moveZeroes2(nums2);
        moveZeroes2(nums3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
     }
}
