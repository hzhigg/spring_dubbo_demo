package com.common.test;

import com.common.util.StringUtils;

public class Test {
	public static void main(String[] args) {
		String s1="helloWorld";
		String s2="123";
		StringUtils.setValueIfNotBlank(s1,s2);
		System.out.println();
	}
}
