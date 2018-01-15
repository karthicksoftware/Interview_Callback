package project.interview.clientinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class Collections {

	@Test
	public void testCollections() throws Exception {
		/*
		 * 1. Collections, different between different collection objects,
		 * conversion of one collection to another collection, sorting and find
		 * element methods, cloning, delete an objects from collection, compare
		 * collections.
		 */
		List<String> items = new ArrayList<String>();
		items.add("Dhoni");
		items.add("Virat");
		items.add("Raina");
		
		List<String> items1 = new LinkedList<String>();
		items1.add("Dhoni");
		items1.add("Raina");
		items1.add("Virat");
		items1.add("Virat");
		
		//java.util.Collections.sort(items);
		java.util.Collections.sort(items1);
		items.addAll(items1);
		System.out.println("hbasjdb: "+items);
		
		items.forEach(System.out::println);
		System.out.println();
		items1.forEach(System.out::println);
		
		System.out.println(items.containsAll(items1));
		System.out.println("\nSet");
		Set<String> set = new HashSet<String>(items1);
		set.forEach(karthick->System.out.println(karthick));
		
		String[] array = (String[])set.toArray(new String[0]);
		for(String arr : array) {
			System.out.println("Array: "+arr);			
		}
 		
	}

}
