package com.kimhank.collection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	IntStream stream1 = IntStream.of(4,2,7,3,5,6);
	IntStream stream2 = IntStream.of(4,2,7,3,5,6);
	
	
	OptionalInt result = stream1.sorted().findFirst();
	OptionalInt result2 = stream1.sorted().findAny();

	String[] arr = { "I study hard", "You study java", "I am hungry"};
	
	Stream<String>  stream = Arrays.stream(arr);
//	stream.flatMap( s-> Stream.of(s.split("+"))).forEach(System.out::println);
	
	LocalDate today = LocalDate.now();
	LocalTime  present = LocalTime.now();
	
//	System.out.println(today + " " + present);	
	
}
