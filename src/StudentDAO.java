/**
* The purpose of this class is to provide an interface for the SQLite Database.
* The student database has already been created in the SQLite Manager add on in the Firefox browser. 
* The public classes below contain the CRUD methods, which are retrieve, update and delete.  
* @author Mohammed Adnan Hussain, 16028929
* @version 1.0
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {

	private Connection dbConnection;

	public Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");  //registers database driver
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String dbURL = "jdbc:sqlite:studentdb.sqlite"; //database name
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

		//get all students 
	public ArrayList<Student> getAllStudents() throws SQLException {
		Connection dbConnection = null; //creates connection
		Statement statement = null; //creates statement 
		ResultSet resultset = null; //creates a result set
		String query = "SELECT * FROM students;"; /** This query selects all the records from the students table. */
		Student temp = null;
		ArrayList<Student> allStudents = new ArrayList<>();

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// execute SQL query
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
				
				/** The code below gets all the student records that have data in the strings. */
				String name = resultset.getString("Name");
				String gender = resultset.getString("Gender");
				String dob = resultset.getString("DOB");
				String address = resultset.getString("Address");
				String postcode = resultset.getString("Postcode");
				int stuID = resultset.getInt("StudentNumber");
				String courseTitle = resultset.getString("CourseTitle");
				String startDate = resultset.getString("StartDate");
				Float bursary = resultset.getFloat("Bursary");
				String email = resultset.getString("Email");
				
				/** This code prints the data in each string, meaning that it will output all the student records. */
				System.out.println("Name: "+ name);
				System.out.println("Gender: "+gender);
				System.out.println("DOB: "+dob);
				System.out.println("Address: "+address);
				System.out.println("Postcode: "+postcode);
				System.out.println("Student ID: "+stuID);
				System.out.println("Course Title: "+courseTitle);
				System.out.println("Start Date: "+startDate);
				System.out.println("Bursary: "+bursary);
				System.out.println("Email: "+email);
				System.out.println(" ");
				temp = new Student(name, gender, dob, address, postcode, stuID, courseTitle, startDate,bursary ,email);

				allStudents.add(temp);			
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();	//closes result set
			}
			if (statement != null) {
				statement.close();	//closes statement
			}
			if (dbConnection != null) {
				dbConnection.close();	//closes connection
			}
		}
		return allStudents;
	}
		
		//get student by Student ID
	public Student getStudent(String id) throws SQLException {
		
		Student temp = null;
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		String query = "SELECT * FROM students WHERE StudentNumber='" + id + "'"; /** This query selects all the records from the students table
																				where the student number = x. */
		
		ArrayList<Student> getStudent = new ArrayList<>();
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);

			resultset = statement.executeQuery(query);
		
			while ( resultset.next() ) {
				/** The code below gets all the student records that have data in the strings. */
				String name = resultset.getString("Name");
				String gender = resultset.getString("Gender");
				String dob = resultset.getString("DOB");
				String address = resultset.getString("Address");
				String postcode = resultset.getString("Postcode");
				int stuID = resultset.getInt("StudentNumber");
				String courseTitle = resultset.getString("CourseTitle");
				String startDate = resultset.getString("startDate");
				Float bursary = resultset.getFloat("Bursary");
				String email = resultset.getString("Email");
				
				/** This code prints the student record. */
				System.out.println("Name: "+ name);
				System.out.println("Gender: "+gender);
				System.out.println("DOB: "+dob);
				System.out.println("Address: "+address);
				System.out.println("Postcode: "+postcode);
				System.out.println("Student ID: "+stuID);
				System.out.println("Course Title: "+courseTitle);
				System.out.println("Start Date: "+startDate);
				System.out.println("Bursary: "+bursary);
				System.out.println("Email: "+email);

				temp = new Student(name, gender, dob, address, postcode, stuID, courseTitle, startDate, bursary, email);
				getStudent.add(temp);
			}
		
		}catch (SQLException e){
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
		return temp;
	}

		//insert student
	public Boolean insertStu(Student stu) throws SQLException {
		
		Connection dbConnection = null;
		Statement statement = null;
		try {
		dbConnection = getDBConnection();
		dbConnection.setAutoCommit(false);
		statement = dbConnection.createStatement();
		/** The query inserts a record with all the fields below into the student database. */
		String query = "INSERT INTO students (name, gender, dob, address, postcode, studentNumber, courseTitle, startDate, bursary, email)"
		+ "VALUES ('"+ stu.getName()+"', '"+ stu.getGender()+"','"+ stu.getDob()+"', '"+ stu.getAddress()+"', '"+ stu.getPostcode()+"',"
		+ "'"+ stu.getStudentNumber()+"', '"+ stu.getCourseTitle()+"', '"+ stu.getStartDate()+"', '"+ stu.getBursary()+"', '"+ stu.getEmail() + "')";
		statement.executeUpdate(query);
		dbConnection.commit();

		} finally {
		}
		if (statement != null) {
		statement.close();
		}

		if (dbConnection != null) {
		dbConnection.close();
		}
		System.out.println("Successfully Inserted");
		return false;

	}
		//delete student by ID
	public Boolean deleteStu(String stuID) throws SQLException {
		
		Connection dbConnection = null;
		Statement statement = null;
		try {
		dbConnection = getDBConnection();
		dbConnection.setAutoCommit(false);
		statement = dbConnection.createStatement();
		String query = "DELETE from students WHERE StudentNumber='" + stuID + "'"; /** This deletes a student record when the user specifies a student number. */
		statement.executeUpdate(query);
		dbConnection.commit();

		} finally {
		}
		if (statement != null) {
		statement.close();
		}

		if (dbConnection != null) {
		dbConnection.close();
		}
		System.out.println("Successfully Deleted");
		
		return false;
	}

		//update student
	public Boolean updateStu(Student stu) throws SQLException {
		
		Connection dbConnection = null;
		Statement statement = null;
		try {
		dbConnection = getDBConnection();
		dbConnection.setAutoCommit(false);
		statement = dbConnection.createStatement();
		String query = "UPDATE students set email = 'update@test.com' WHERE studentNumber = 16028929;"; /** This updates the student email when the student number is specified. */  
		statement.executeUpdate(query);
		dbConnection.commit();

		} finally {
		}
		if (statement != null) {
		statement.close();
		}

		if (dbConnection != null) {
		dbConnection.close();
		}
		System.out.println("Successfully Updated");
		
		return false;
	}
		
		//check user login and password
	public Boolean checkLoginCredentials(String username, String password) throws SQLException {

		return false;	
	}

		//check API
	public boolean checkApiKey(String key) throws SQLException {
		
		return false;
	}
}
