/**
* The purpose of this class is test/validate the CRUD methods created in the StudentDAO class. 
* To test a CRUD method, the user will need to comment out the other methods as it will throw errors if not.
* @author Mohammed Adnan Hussain, 16028929
* @version 1.0
*/
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;


public class DatabaseTester {

	public static void main(String[] args) {
		
		ArrayList<Student> allStudents = new ArrayList<>();
		StudentDAO dao = new StudentDAO();
		Gson gson = new Gson();
		
		// insert Test Student
		//Student stu = new Student ("Test", "M", "10-03-1995", "Glasgow", "GL2 6HB", 13049587, "Computer Science", "01-10-2010", 300.0f, "test@testing.com");
		
		//update Student 16028929
		Student stu = null;
		try {
			//get student by Student ID test
			//dao.getStudent("16028929");
			
			//get all Students test
			allStudents = dao.getAllStudents();
			
			//insert Student test
			//dao.insertStu(stu);
			
			//delete Student test
			//dao.deleteStu("13049587");
			
			//update Student test
			//dao.updateStu(stu);
			
		} catch (SQLException e) {
			System.out.println("SQL exception: "+e.getMessage());
			
		}
		
		String myJson = gson.toJson(allStudents);
		System.out.println(myJson);
		
		System.out.println(allStudents);
	}
}
