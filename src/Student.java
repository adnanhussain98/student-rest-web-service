/**
* The purpose of this class is to define attributes associated with a student e.g. student number, course title, start date, bursary, email.
* Student's variables have been added in the public student class.
* Getters and setters have been added so that I can add validation in the StudentDAO class. 
* @author Mohammed Adnan Hussain, 16028929
* @version 1.0
*/
public class Student extends Person{
	
	private int studentNumber; 
	private String courseTitle; 
	private String startDate; 
	private float bursary; 
	private String email;
	public Student(String name, String gender, String dob, String address, String postcode, int studentNumber,
			String courseTitle, String startDate, float bursary, String email) {
		super(name, gender, dob, address, postcode);
		
		this.studentNumber = studentNumber;
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.bursary = bursary;
		this.email = email;
	}
	
	/**
	 * @return the studentNumber
	 */
	public int getStudentNumber() {
		return studentNumber;
	}
	/**
	 * @param studentNumber the studentNumber to set
	 */
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}
	/**
	 * @param courseTitle the courseTitle to set
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the bursary
	 */
	public float getBursary() {
		return bursary;
	}
	/**
	 * @param bursary the bursary to set
	 */ 
	public void setBursary(float bursary) {
		this.bursary = bursary;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}	
}
