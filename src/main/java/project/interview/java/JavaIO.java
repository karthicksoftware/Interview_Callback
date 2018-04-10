package project.interview.java;

import java.io.File;
import java.io.FileOutputStream;

import org.testng.annotations.Test;

public class JavaIO {

	@Test(enabled = true)
	/**
	 * Java FileOutputStream is an output stream used for writing data to a
	 * file. If you have to write primitive values into a file, use
	 * FileOutputStream class. You can write byte-oriented as well as
	 * character-oriented data through FileOutputStream class. But, for
	 * character-oriented data, it is preferred to use FileWriter than
	 * FileOutputStream.
	 * 
	 * @throws Exception
	 */
	public void testFileOutputStream() throws Exception {

		FileOutputStream fos = new FileOutputStream(new File("C://sample.txt"));
		fos.write(65); // accepts only byte data
		fos.close();
		File file = new File("C://IO");
		if (!(file.isDirectory())) {
			file.mkdir();
			file = new File("C://IO//sample.txt");
		} else {
				file = new File("C://IO//sample.txt");
		}
		fos = new FileOutputStream(file);
		String a = "Hello Karthick";
		byte[] b = a.getBytes();
		fos.write(b);
		fos.close();
		System.out.println("Done");

	}
	
	

}
