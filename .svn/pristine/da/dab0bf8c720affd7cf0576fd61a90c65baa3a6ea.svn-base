package project.interview.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AccessControlException;

import org.testng.annotations.Test;

public class Exceptions {

	/**
	 * Checked exceptions lets programmer to handled it before successful
	 * compilation. They are, 
	 * ClassNotFoundException 
	 * IllegalAccessException
	 * NoSuchFieldException
	 * IOException
	 * InterruptedException, etc..
	 * 
	 */
	@Test
	public void testCheckedException() throws IOException, FileNotFoundException{
		FileInputStream fis = new FileInputStream(new File(""));
		System.out.println(fis.read());
		fis.close();
	}
	
	/**
	 * Unchecked exceptions happens at the runtime. They are,
	 * ArithmeticException 
	 * ArrayIndexOutOfBoundsException 
	 * NullPointerException
	 * NegativeArraySizeException
	 * NumberFormatException
	 * StringIndexOutOfBoundsException
	 */
	@Test
	public void testUnCheckedException(){
		try {
		int a = 5;
		System.out.println(a/0);
		}
		catch(ArithmeticException e) {
			System.out.println("Unchecked exception handled");
		}
	}
	
	/**
	 * Finally will execute every time followed by catch block. Until System.exit() is called;
	 */
	@Test
	public void testTryCatchFinally() {
		try {
			String text1 = "msdhoni";
			System.out.println(text1.charAt(99));
		}
		catch(StringIndexOutOfBoundsException e) {
			System.out.println("StringIndexOutOfBoundsException handled in catch block");
		}
		finally {
			System.out.println("Finally will execute everytime");
		}
	}
	
	/**
	 * Catch block is optional only if finally block is given
	 */
	@Test
	public void testTryFinally() {
		try {
			int a[] = {1,2,3};
			System.out.println(a[115]);
		}
		finally {
			System.out.println("ArrayIndexOutOfBoundsException handled in finally block");
		}
	}
	
	/**
	 * Multiple catch is possible, but only one catch blocks gets invoked leaving others skipped.
	 */
	@SuppressWarnings("null")
	@Test
	public void testTryWithMultipleCatch() {
		try {
			String text1 = null;
			System.out.println(text1.charAt(99));
		}
		catch(StringIndexOutOfBoundsException e) {
			System.out.println("StringIndexOutOfBoundsException handled in catch block");
		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException handled in catch block");
		}
		catch(AccessControlException e) {
			System.out.println("AccessControlException handled in catch block");
		}
	}
	
	/**
	 * Try returns value in the below program since, catch will execute only if exception occurs. 
	 * But if finally contains return statement then it will override try's return value.
	 */	
	@Test
	public void testTryCatchFinallyReturn(){
		System.out.println(getMethod(false));
	}
	
	public int getMethod(boolean value) {
		try {
			return 78;
		}
		catch(Exception e) {
			return 56;
		}
		finally {
			if(value == true)
				return 100;
		}
	}
	
	/**
	 * Throw keyword is used when certain exception condition happens in the program. 
	 * Throws keyword used for throwing checked exception and indicating the programmer 
	 * that the method has following checked exception occurrence.
	 * @throws InterruptedException 
	 */
	@Test
	public void testThrowThrowsKeyword() throws InterruptedException {
		Thread.sleep(1000L);
		boolean flag = false;
		if(flag) 
			throw new ArithmeticException("ArithmeticException thrown");
		else
			throw new ClassCastException("ClassCastException thrown");
	}
	
	@Test
	public void testUserDefinedException() throws Karthick{
	          throw new Karthick("My exception");
	}
	
}

@SuppressWarnings("serial")
class Karthick extends Exception {
	String reason1;
	Karthick(String reason) {
		reason1 = reason;
	}
	public String toString() {
		return ("Output = " + reason1);
	}
}
