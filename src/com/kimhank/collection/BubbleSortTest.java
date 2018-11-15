package com.kimhank.collection;

import java.util.Scanner;

public class BubbleSortTest {

	public static void swap(int[] array, int idx1, int idx2) {
		int temp =0;
		temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
		
	}
	
	static void bubbleSort(int[] a, int b) {
		
		for(int i=0; i<b; i++) {
			for(int j=b-1; j> i; j--) {
				if(a[j-1]  > a[j]) {
					swap(a,j-1,j);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("input index");
		int idx = sc.nextInt();
		int[] x = new int[idx];
		
		for(int i = 0 ; i < idx ; i++) {
			System.out.println("input number [" + (i+1) + "]");
			x[i] = sc.nextInt();
		}
		try{
			bubbleSort(x, idx);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("sort by ascent");
		for(int i = 0; i< idx ; i++) {
			System.out.println("x[" + i + "] =" + x[i]);
		}
	}

		
}
