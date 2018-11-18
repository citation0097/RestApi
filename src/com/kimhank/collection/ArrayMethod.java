package com.kimhank.collection;

public class ArrayMethod {
	
	
	private Object[] elementData = new Object[100];
	private int size = 0;
	
	public boolean addLast(Object element) {
		
		while(size < 100) {
			elementData[size] = element;
			size++;
		}
		return true;
	}
	
	public boolean add(int index, Object element) {
		
		for(int i = size-1; i >= index; i--) {
			elementData[i+1] = elementData[i];
		}
		elementData[index] = element;
		size++;		
		return true;
	}
	
	public Object remove(int index) {
		
		Object removed = elementData[index];
		for(int i = index +1; i< size; i++) {
			elementData[i-1] = elementData[i];
		}
		size--;
		elementData[size] = null;
		return removed;
				
		
	}
	
	

}
