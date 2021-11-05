import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;

/**
 * This is the student test for the Manager class.
 * 
 *@author Erik Umoh
 */
class CourseDBManager_STUDENT_Test {
	
	private CourseDBManagerInterface dataMgr = new CourseDBManager();
	
	/**
	 * A manager object is created here.
	 *
	 */
	@Before
	public void setUp() throws Exception{
		dataMgr = new CourseDBManager();
	}
	
	/**
	 * The manager object is reset here.
	 *
	 */
	@After
	public void tearDown() throws Exception{
		dataMgr = null;
	}
	
	/**
	 * The Add and Show All methods are tested here.
	 * 
	 *
	 */
	@Test
	void testAddAndShowAll() {
		dataMgr.add("MATH181",38212,1,"MT111","Mr. Krabs");
		dataMgr.add("MATH181",38213,2,"MT112","Bingus");
		ArrayList<String> list = dataMgr.showAll();
		
		assertEquals(list.get(0),"\nCourse:MATH181 CRN:38212 Credits:1 Instructor:Mr. Krabs Room:MT111");
		assertEquals(list.get(1),"\nCourse:MATH181 CRN:38213 Credits:2 Instructor:Bingus Room:MT112");
	}

	/**
	 * The read file method is tested here.
	 * 
	 *
	 */
	@Test
	void testReadFile() throws FileNotFoundException{
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("MATH181 38212 1 MT111 Mr. Krabs");
			inFile.print("MATH181 38213 2 MT112 Bingus");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			
			ArrayList<String> list = dataMgr.showAll();
			assertEquals(list.get(0),"\nCourse:MATH181 CRN:38212 Credits:1 Instructor: Mr. Krabs Room:MT111");
			assertEquals(list.get(1),"\nCourse:MATH181 CRN:38213 Credits:2 Instructor: Bingus Room:MT112");
		}
		catch (FileNotFoundException e){
			fail("A file couldn't be found.");
		}
	}

}
