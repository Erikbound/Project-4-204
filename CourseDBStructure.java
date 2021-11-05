import java.io.IOException;
import java.util.LinkedList;

/**
 * This is the class where the Course Database Structure is created.
 * It holds all the elements that the Structure will use.
 * 
 * @author Erik Umoh
 *
 */
public class CourseDBStructure<T> implements CourseDBStructureInterface{

	public LinkedList<CourseDBElement>[] hashTable;
	
	public CourseDBStructure(int i) {
		hashTable = new LinkedList[i];
	}

	public CourseDBStructure(String string, int i) {
		string = "Testing";
		hashTable = new LinkedList[i];
	}

	/**
	 * This method adds an element to the hash table.
	 * 
	 * @param the element to be added
	 *
	 */
	@Override
	public void add(CourseDBElement element) {
		int index = (element.hashCode() % getTableSize());
		
		//If spot in table is empty, create a new spot
		if (hashTable[index] == null) { 
			hashTable[index] = new LinkedList<CourseDBElement>();
			hashTable[index].add(element);
		}
	}
	
	/**
	 * This method retrieves an element to be used in a different object
	 * 
	 * @param The CRN used to lookup it's corresponding element.
	 * @return The element being searched for.
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement element = null;
		
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				if (hashTable[i].get(0).getCRN() == crn) {
					element = hashTable[i].get(0);
				}
			}
		
		}
		return element;
	}
	
	/**
	 * This method retrieves the hash table size
	 * 
	 * @return The length of the hash table
	 *
	 */
	@Override
	public int getTableSize() {
		return hashTable.length;
	}

}
