/**
 * This is the class where the Course Database Element is created.
 * 
 * @author Erik Umoh
 *
 */
public class CourseDBElement implements Comparable<Object>{

	private String CourseID;
	private int crn;
	private int credits;
	private String roomNum;
	private String instructor;
	
	public CourseDBElement() {
		// TODO Auto-generated constructor stub
	}
	
	public CourseDBElement(String CourseID, int crn, int credits, String roomNum, String instructor){
		this.CourseID = CourseID;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}

	/**
	 * This method sets the CRN
	 * 
	 *@param parseInt
	 */
	public void setCRN(int parseInt) {
		crn = parseInt;
		
	}

	/**
	 * This method compares a different element with this one
	 * 
	 *@param the object to be compared
	 */
	@Override
	public int compareTo(Object o) {
		int result = 0;
		
		return result;
	}

	/**
	 * This method retrieves the CRN for another object to use
	 * 
	 *@return CRN
	 */
	public int getCRN() {
		return crn;
	}

}
