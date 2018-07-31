package com.leetcode.solution.string;

import java.util.HashMap;
import java.util.Map;

public class NumToRoman {

	
	public static String toRoman(int num) {
		Map<Integer, String> romanMap = new HashMap<>();
		romanMap.put(1, "I");
		romanMap.put(5, "V");
		romanMap.put(10, "X");
		romanMap.put(50, "L");
		romanMap.put(100, "C");
		romanMap.put(500, "D");
		romanMap.put(1000, "M");
		romanMap.put(4, "IV");
		romanMap.put(9, "IX");
		romanMap.put(40, "XL");
		romanMap.put(90, "XC");
		romanMap.put(400, "CD");
		romanMap.put(900, "CM");
		
		String result = "";
		int temp = num;
		int count = 0;
		while (temp > 0) {
			int tmpRes = temp % 10;
			temp = temp / 10;
			if (tmpRes == 4 || tmpRes == 9) {
				result = romanMap.get(tmpRes*(int)Math.pow(10, count)) + result;
			} else {
				String tmpResult = "";
				if (tmpRes >= 5) {
					tmpResult = romanMap.get(5*(int)Math.pow(10, count)); 
					tmpRes = tmpRes - 5;
				}
				while (tmpRes > 0) {
					tmpResult = tmpResult + romanMap.get(1*(int)Math.pow(10, count)); 
					tmpRes--;
				}
				result = tmpResult + result;
			}
			count++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(toRoman(3568));
	}
}
