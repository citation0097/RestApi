package com.kimhank.collection;




	class Gen<T>{
		private T t;
		
		public void add(T t) {
			this.t  = t;
		}
		
		public T get() {
			return t;
		}
	}

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<Integer> integerGen = new Gen<Integer>();
		Gen<String> stringGen = new Gen<String>();
		
		integerGen.add( new Integer(10));
		stringGen.add(new String("Generic Test"));
		
		System.out.printf("integer value : %d", integerGen.get());
		System.out.printf("string value : %s", stringGen.get());
		
		
	}

}
