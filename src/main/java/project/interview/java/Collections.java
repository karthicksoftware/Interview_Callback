package project.interview.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class Collections {

	@Test (priority = 1)
	public void testArrayList() throws Exception {
		System.out.println("==============================================================================");
		System.out.println("[ArrayList]");
		List<String> players = new ArrayList<String>();
		players.add("-MSDhoni");
		players.add("-Raina");
		players.add("-Virat");
		players.add("-Virat");
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i));
		}
		players.clear();
		System.out.println("Points to remember...");
		System.out.println("*ArrayList can hold duplicates,");
		System.out.println("*ArrayList follows insertion order,");
		System.out.println("*ArrayList is slow in shifting items after manipulation,\n");
		System.out.println("Clearing ArrayList...\n");
		System.out.println("==============================================================================");
		System.out.println("[LinkedList]");
		players = new LinkedList<String>();
		players.add("-MSDhoni");
		players.add("-Raina");
		players.add("-Virat");
		players.add("-Virat");
		ListIterator<String> itr = players.listIterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Iterating in backward direction...");
		while (itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
		System.out.println("Removing 2nd item...");
		players.remove(1);
		itr = players.listIterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		players.clear();
		System.out.println("Points to remember...");
		System.out.println("*LinkedList can hold duplicates,");
		System.out.println("*LinkedList follows insertion order,");
		System.out.println("*LinkedList is FAST in shifting items after manipulation,");
		System.out.println("*ListIterator can traverse from forward and backward direction,\n");
		System.out.println("Clearing LinkedList...\n");
	}

	@Test (priority = 2)
	public void testSet() throws Exception {
		System.out.println("==============================================================================");
		Set<String> players = new HashSet<String>();
		System.out.println("[HashSet]");
		players.add("-MSDhoni");
		players.add("-Raina");
		players.add("-Virat");
		players.add("-Virat");
		for (String player : players) {
			System.out.println(player);
		}
		System.out.println("Duplicate -Virat has been removed...\n");
		players.clear();
		System.out.println("Points to remember...");
		System.out.println("*HashSet CANNOT hold duplicates,");
		System.out.println("*HashSet doesn't follows the insertion order,");
		System.out.println("Clearing HashSet...\n");
		System.out.println("==============================================================================");
		players = new LinkedHashSet<String>();
		System.out.println("[LinkedHashSet]");
		players.add("-MSDhoni");
		players.add("-Raina");
		players.add("-Virat");
		players.add("-Virat");
		for (String player : players) {
			System.out.println(player);
		}
		System.out.println("Duplicate -Virat has been removed...");
		System.out.println("Insertion order has been maintained...\n");
		players.clear();
		System.out.println("Points to remember...");
		System.out.println("*LinkedHashSet CANNOT hold duplicates,");
		System.out.println("*LinkedHashSet FOLLOWS the insertion order,");
		System.out.println("Clearing LinkedHashSet...\n");

		players = new TreeSet<String>();
		System.out.println("==============================================================================");
		System.out.println("[TreeSet]");
		players.add("-MSDhoni");
		players.add("-Virat");
		players.add("-Raina");
		players.add("-Virat");
		for (String player : players) {
			System.out.println(player);
		}
		System.out.println("Duplicate -Virat has been removed...");
		System.out.println("Arranged in ascending order...\n");
		players.clear();
		System.out.println("Points to remember...");
		System.out.println("*TreeSet CANNOT hold duplicates,");
		System.out.println("*TreeSet FOLLOWS ascending order,");
		System.out.println("Clearing TreeSet...\n");
	}

	@Test (priority = 3)
	public void testMap() throws Exception {
		System.out.println("==============================================================================");
		System.out.println("[HashMap]");
		Map<Integer, String> players = new HashMap<Integer, String>();
		players.put(1, "-Sachin");
		players.put(2, "-Dravid");
		players.put(3, null);
		players.put(null, "-Raina");
		players.put(4, null);

		for (Map.Entry<Integer, String> player : players.entrySet()) {
			System.out.println(player);
		}
		players.clear();
		System.out.println("Points to remember...");
		System.out.println("*HashMap CANNOT hold duplicates,");
		System.out.println("*HashMap follows NO order,");
		System.out.println("*HashMap may have one null KEY & many null VALUES,\n");
		System.out.println("Clearing HashMap...\n");
		System.out.println("==============================================================================");
		System.out.println("[LinkedHashMap]");
		players = new LinkedHashMap<Integer, String>();
		players.put(3, "-Raina");
		players.put(1, "-Sachin");
		players.put(2, "-Dravid");

		for (Map.Entry<Integer, String> player : players.entrySet()) {
			System.out.println(player);
		}
		System.out.println("Checking whether \" -Raina \" is present in the Map..");

		System.out.println("isPresent : " + players.values().contains("-Raina"));

		players.clear();
		System.out.println("Points to remember...");
		System.out.println("*LinkedHashMap CANNOT hold duplicates,");
		System.out.println("*LinkedHashMap follows insertion order,");
		System.out.println("*LinkedHashMap may have one null KEY & many null VALUES,\n");
		System.out.println("Clearing LinkedHashMap...\n");
		System.out.println("==============================================================================");
		System.out.println("[TreeMap]");
		players = new TreeMap<Integer, String>();
		players.put(2, "-Sachin");
		players.put(3, "-Dravid");
		players.put(1, "-Raina");

		for (Map.Entry<Integer, String> player : players.entrySet()) {
			System.out.println(player);
		}
		players.clear();
		System.out.println("Points to remember...");
		System.out.println("*TreeMap CANNOT hold duplicates,");
		System.out.println("*TreeMap follows ascending order over KEYs,");
		System.out.println("*TreeMap cannot have null KEY &  can have many null VALUES,\n");
		System.out.println("Clearing TreeMap...\n");
	}
}
