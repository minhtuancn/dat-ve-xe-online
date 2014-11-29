package com.vexeonline.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdminServiceImpl implements AdminService{
	
	
    public static void main(String[] args) {
    	
    	List<String> arrayList = new ArrayList<String>();
    	List<String> linkedList = new LinkedList<String>();
    	
    	for (int i = 0; i < 100000; ++i) {
    		linkedList.add("tung");
    		arrayList.add("tung");
    	}
    	
    	long startTime = System.nanoTime();
		
    	for (int i = 0; i < 100000; ++i) {
    		arrayList.get(i);
    	}
    	
		long endTime = System.nanoTime();

		long duration1 = (endTime - startTime); // divide by 1000000 to get
												// milliseconds.

		startTime = System.nanoTime();
		
		
		endTime = System.nanoTime();

		 long duration2 = (endTime - startTime); //divide by 1000000 to get// milliseconds.

		long startTime3 = System.nanoTime();
		
		for (int i = 0; i < 100000; ++i) {
    		linkedList.get(i);
    	}
		
		long endTime3 = System.nanoTime();

		long duration3 = (endTime3 - startTime3); // divide by 1000000 to get
													// milliseconds.

		System.out.println(duration1 / 1000000000.0 + "		" + duration2/1000000000.0 +"	" + duration3
				/ 1000000000.0);
		System.out.println(duration3 / (duration1 * 1.0));
    	
    	System.out.println("terminate");
    }
}
