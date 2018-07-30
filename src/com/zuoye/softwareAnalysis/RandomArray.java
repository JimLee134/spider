package com.zuoye.softwareAnalysis;

import java.util.Random;

public class RandomArray {

	public RandomArray() {
		// TODO Auto-generated constructor stub
	}

	public static int[] getArray(int n) {

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = new Random().nextInt(n);

		}

		// 最后输出arr，请自行测试一下。
		return arr;
	}
}
