package project.interview.java;

import org.testng.annotations.Test;

public class WrapperClasses {

	@Test
	public void testWrapperClasses() throws Exception{
		
		// Converting from integer object to primitive type
		Integer value1 = new Integer(3);
		int value2 = value1.intValue();
		System.out.println("Result : "+value2);
		
		//Converting from integer primitive to object type
		int value3 = 5;
		Integer value4 = Integer.valueOf(value3);
		System.out.println("Result : "+value4);
		
		//Converting from integer object to String object
		Integer value5 = new Integer(7);
		String str1 = String.valueOf(value5.intValue());
		System.out.println("Result : "+str1);
		
		//Converting from string object to integer object
		String str2 = "22";
		Integer value6 = Integer.parseInt(str2); 
		System.out.println("Result : "+value6);
		
		//Converting from string object to float primitive
		String str3 = "45.12";
		Float value7 = Float.valueOf(str3);
		float value8 = Float.parseFloat(str3);
		System.out.println("Result of valueOf : "+value7);
		System.out.println("Result of parseFloat : "+value8);
		
		System.out.println("valueOf returns new of type");
		System.out.println("parseFloat returns primitive type");
		
	}
	
}
