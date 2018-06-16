package com.leetcode.solution.util;

import java.util.Arrays;
import java.util.List;

/**
 * @author dadisdad
 * @date 2018/6/16
 */
public class CollectionUtils {

    /**
     * list 转字符串
     *
     * @param list
     * @return
     */
    public static String List2String(List<?> list) {
        return Arrays.deepToString(list.toArray());
    }
}
