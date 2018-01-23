package com.leetcode.solution.math;

/**
 * @author dadisdad
 * @date 2018/1/23
 */
public class ReverseInteger {

    public static int reverse(int x) {
        long result = 0L;
        while(x!=0){
            result = result*10+x%10;
            x=x/10;
            if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)result;

    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
        System.out.println(reverse(123));
        System.out.println(reverse(-321));
        System.out.println(reverse(1234567899));
    }
}
