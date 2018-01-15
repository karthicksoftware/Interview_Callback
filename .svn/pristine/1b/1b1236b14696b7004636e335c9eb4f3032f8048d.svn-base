package project.interview.java;

import org.testng.annotations.Test;

public class StringManipulations {

	@Test
	public void testStringManipulations() throws Exception{
		
		String text1 = "softcrylic";
		String text2 = "softcrylic";
		String text3 = new String("softcrylic");
		
		System.out.println("String literals shares the memory in the temporary stack storage..");
		if(text1 == text2) {
			System.out.println(System.identityHashCode(text1));
			System.out.println(System.identityHashCode(text2));
			System.out.println("Equal");
		}
		else {
			System.out.println("Not Equal");
		}
			
		if(text2 == text3) {
			System.out.println("Equals");
		}
		else {
			System.out.println(System.identityHashCode(text2));
			System.out.println(System.identityHashCode(text3));
			System.out.println("Not equal");
			System.out.println("String literals and objects differs in its memory storage. Objects are stored in permanent heap space");
		}
		
		System.out.println("Using intern() method..");
		if(text2 == text3.intern()) {
			System.out.println("True, because intern method make string objects as a literal in a string pool..\nFind out the hashcode below,");
			System.out.println(System.identityHashCode(text2));
			System.out.println(System.identityHashCode(text3));
			System.out.println("Even if an object is created using new operator, intern method put the string value in the string pool and it is considered as a literal\n");
		}
		else {
			System.out.println("False");
		}
		
		if(text2.equals(text3)) {
			System.out.println("Equals");
			System.out.println("-equals method deal with comparing words of two different objects");
		}
		else {
			System.out.println("Not equals");
		}
		
		if(text1.compareTo(text3) == 0) {
			System.out.println("Equals");
			System.out.println("compareTo method returns 0 if both are equal, and returns non zero if both are not equal");
		}
		else {
			System.out.println("Not equals");
		}
		
		System.out.println("Concating two strings: "+text1.concat(text2));
		StringBuilder str1 = new StringBuilder("softcrylic");
		System.out.println("Appending text to existing string: "+str1.append(" technologies"));
		System.out.println("After appending to stringbuilder and concating to string looks like: \n"+str1+"\n"+text1+"\nStringBuilder retains the appended value whereas String doesn't.\nString is mutable and Stringbuilder is immutable.\nString buffer does the same but it is in synchronized block (thread safe.)");
		
		if(text1.startsWith("soft") && text1.endsWith("crylic")) {
			System.out.println("-startsWith check whether string is starting with the given prefix and -endWith checks for given suffix. It is case sensitive");
		}
		else {
			System.out.println("False");
		}
		
		String text4 = " men in blue ";
		System.out.println("Replacing s to S in String: "+text1.replace("s", "S"));
		System.out.println("Omitting leading and trailing white spaces of "+text4+":"+text4.trim());
		System.out.println("Omitting all white spaces of"+text4+":"+text4.replaceAll(" ", ""));
		System.out.println(text4);
		System.out.println("Getting substring by index: "+text4.substring(text4.indexOf("b"), text4.lastIndexOf(" ")));
		System.out.println("Getting substring by its position: "+text4.substring(8, 12));
		System.out.println("Getting char using charAt fn:"+text4.charAt(1));
		char[] char1 = text4.toUpperCase().trim().toCharArray();
		System.out.println("Converting "+text4+" to upper case and to character array..");
		for(int i = 0 ; i < char1.length; i++) {
			System.out.print(char1[i]+" ");
		}
		
		System.out.println("\nUsing equalIgnoreCase..");
		if(text4.trim().equalsIgnoreCase("Men In bLue")) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		System.out.println("Using spilt function..");
		String text5 = "a b c d e f g";
		String [] stext5 = text5.split(" ");
		int i = 0;
		while (i < stext5.length) {
			System.out.println(stext5[i]);
			i++;
		}
		System.out.println("We can retrieve the array by its array location..\nPrinting letters after c:\n"+text5.split("c ")[1]);
	}
	
}
