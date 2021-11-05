import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class creates is allows the user to read element data through a file.
 * 
 *@author Erik Umoh
 */
public class CourseDBManager<T> implements CourseDBManagerInterface{

	CourseDBStructure<T> struct;
	ArrayList<String> list;
	int listIndex;
	
	public CourseDBManager() {
		struct = new CourseDBStructure<T>(500);
		list = new ArrayList<String>();
		listIndex = 0;
	}
	
	/**
	 * This is the student test for the Manager class.
	 * 
	 * 
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		list.add("\nCourse:" + id + " CRN:" + Integer.toString(crn) + " Credits:" + Integer.toString(credits) + " Instructor:" + instructor + " Room:" + roomNum);

		struct.add(element);
		
	}
	
	/**
	 * This method retrieves an element to be used in a different object
	 * 
	 * @param The CRN used to lookup it's corresponding element.
	 * @return The element being searched for.
	 */
	@Override
	public CourseDBElement get(int crn) {
		CourseDBElement element = null;
		
		for (int i = 0; i < struct.hashTable.length; i++) {
			if (struct.hashTable[i] != null) {
				if (struct.hashTable[i].get(0).getCRN() == crn) {
					element = struct.hashTable[i].get(0);
				}
			}
		
		}	
		return element;
	}
	
	/**
	 * This method reads a file and uses that data to create a new element,
	 * which it then adds to the Manager.
	 * 
	 * @param A .txt file.
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scan = new Scanner(input);
		
		String newID;
		int newCrn;
		int newCredits;
		String newRoomNum;
		String newInstructor;
		
		while(scan.hasNextLine()) {
		newID = scan.next();
		newCrn = Integer.parseInt(scan.next());
		newCredits = Integer.parseInt(scan.next());
		newRoomNum = scan.next();
		newInstructor = scan.nextLine();
		add(newID, newCrn, newCredits, newRoomNum, newInstructor);
		}
		scan.close();
	}

	/**
	 * This method returns an ArrayList of all the elements in
	 * the Manager.
	 * 
	 * @returns An ArrayList of all the elements in the manager.
	 */
	@Override
	public ArrayList<String> showAll() {

		return list;
	}

}
