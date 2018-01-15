package project.interview.java;

import org.testng.annotations.Test;

public class DataTypes {

	@Test
	public void testDataTypes() throws Exception {

		System.out.println("Primitive data types are shown below,");
		System.out.println("[Byte]");
		byte aByte = -100;
		byte bByte = 99;
		byte rByte;
		rByte = (byte) (aByte + bByte);
		System.out.println("Result : " + rByte);

		System.out.println("[Short]");
		short aShort = 1000;
		short bShort = -99;
		short rShort;
		rShort = (short) (aShort + bShort);
		System.out.println("Result : " + rShort);

		System.out.println("[Int]");
		int aInt = -10000;
		int bInt = -9999;
		int rInt;
		rInt = (aInt + bInt);
		System.out.println("Result : " + rInt);

		System.out.println("[Long]");
		long aLong = -1000000;
		long bLong = -99999;
		long rLong;
		rLong = (aLong + bLong);
		System.out.println("Result : " + rLong);

		System.out.println("[Float]");
		float aFloat = 54.15f;
		float bFloat = (float) -99.78;
		float rFloat;
		rFloat = (aFloat + bFloat);
		System.out.println("Result : " + rFloat);

		System.out.println("[Double]");
		double aDouble = 543.152d;
		double bDouble = (double) -993.7823;
		double rDouble;
		rDouble = (aDouble + bDouble);
		System.out.println("Result : " + rDouble);

		System.out.println("[Boolean]");
		boolean aBoolean = true;
		if (aBoolean == true) {
			aBoolean = false;
			System.out.println("The Boolean Value is : " + aBoolean);
		}

		System.out.println("[Char]");
		char aChar = 'A';
		char bChar = 'B';
		System.out.println("Result : " + aChar + bChar);
	}
}
