package com.kimhank.collection;

import java.util.Scanner;


public class BinSearchTest {
	public static int binSearch(int[] a, int n , int key) {
		int first, last, middle, position = -1;
				
		first = 0; last = n - 1;
		boolean found = false;
		while( !found && first <= last ) {
			middle = (first + last)/2;
			if ( a[middle] == key) {
				found = true;
				position = middle;
			}else if(a[middle] > key  ){
				last = middle-1; 
			}else {
				first = middle+1;
			}
		}
	
		return position;
	}
	
	public static class GenClass<T>{
		private T xyz;
		GenClass(T t){
			this.xyz = t;
		}
		T getXyz() {
			return xyz;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner srint = new Scanner(System.in);
		
		GenClass<String> s = new GenClass<String>("ABC");
		GenClass<Integer> n = new GenClass<Integer>(15);
		
		System.out.println(s.getXyz());
		System.out.println(n.getXyz());
		
		System.out.println("index num");
		int num = srint.nextInt();
		int[] x = new int[num];
		
		System.out.println("input number by ascent");
		System.out.println("x[0]");
		x[0] = srint.nextInt();
		
		for( int i = 1 ; i < num ; i++) {
			do {
				System.out.println("X[" + i + "]");
				x[i] = srint.nextInt();
			}while(x[i] < x[i-1]);
		}
		
		System.out.println("inupt serach num");
		int ky = srint.nextInt();
		
		int rtn = binSearch(x, num, ky);
		
		if(rtn == -1)
			System.out.println("no such a num");
		else
			System.out.println(ky+ "is x[" + rtn + "]");
		
	}
}
