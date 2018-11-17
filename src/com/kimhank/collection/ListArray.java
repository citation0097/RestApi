package com.kimhank.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

public class ListArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruit = {"apple", "peach", "melon", "berry"};
		LinkedList<String>  listfruit = new LinkedList<>(Arrays.asList(fruit));
		
		listfruit.add("pumkin");
		listfruit.addFirst("orange");
		fruit = listfruit.toArray(new String[listfruit.size()]);
		
		for(String f: fruit)
			System.out.println("array" + f);
		// Stream
		Stream<String> stream = listfruit.stream();
		stream.forEach(System.out::println);
		
	}

}
