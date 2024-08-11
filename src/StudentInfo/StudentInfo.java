package StudentInfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class stores and manages information about students.
 * 
 * @author Yanis Sebastian Zürcher
 * @author <a href="https://yanissebastianzuercher.ch">Authors Website</a>
 */

public class StudentInfo implements Comparable<StudentInfo> {	
	
	@Override
	public int compareTo(StudentInfo other) {
		return Double.compare(other.GPA, this.GPA);
	}

	private final String fullName; 
	private final String firstName;
	private final String lastName;
	private final int age; 
	private final double GPA;
	
	private static final double PASSING_GPA = 2.5; // Declare the limit of the passing GPA grade
	
	
	// Constructor
	public StudentInfo(String fullName, String firstName, String lastName, int age, double GPA) {
		if (fullName == null || firstName == null || lastName == null || fullName.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty, please add a name.");
		}
		
		if (age < 15 || age > 30) {
			throw new IllegalArgumentException("Age cannot be below 15 or above 50.");
		}
		
		// Valid GPA range
		if (GPA < 0.0 || GPA > 4.5) {
	        throw new IllegalArgumentException("GPA must be between 0.0 and 4.5");
	    }
		
		this.fullName = fullName;
		this.firstName = firstName; 
		this.lastName = lastName;
		this.age = age;
		this.GPA = GPA;
	}
	
	// Getters
	public String getFullName() {
		return fullName;
	}
	public String getFirstName() {
		return firstName; 
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public double getGpa() {
		return GPA;
	}
	public boolean willPassSemester() {
		return GPA >= PASSING_GPA;
	}
	
	public static void printInitialNotesOrWarnings() {
		System.out.println("WARNINGS/NOTES:");
		System.out.println("The standart GPA scale is up to 4.0, however if the student is performing perfectly and does more work than needed, we'll adjust the score up to 4.5.");
		System.out.println("The ☆ symbol means that the student is doing extraordinarily well.");
		System.out.println("The 👑 symbol means that the student is likely to ascend.");
		System.out.println("The ⚠️ symbol means that the student will fail and needs to show more effort.");
		System.out.println("------------------------------------");
		System.out.print("\n");
	}
	
	public static void printStudentInfo(StudentInfo student) {
	    
	    System.out.println("====================================");
	    System.out.println(student.getFullName().toUpperCase());
	    System.out.println("====================================");
	    System.out.println(" Name        : " + student.getFullName());
	    System.out.println(" Age         : " + student.getAge());
	    
	    // Check GPA and add symbols
	    if (student.getGpa() >= 4.0) {
	        System.out.print(" GPA         : " + student.getGpa() + " 👑\n");
	    } else if (student.getGpa() >= 3.5) {
	        System.out.print(" GPA         : " + student.getGpa() + " ☆\n");
	    } else if (student.getGpa() < PASSING_GPA) {
	        System.out.print(" GPA         : " + student.getGpa() + " ⚠️\n");
	    } else {
	        System.out.print(" GPA         : " + student.getGpa() + "\n");
	    }

	    System.out.println("------------------------------------");
	    System.out.println(" Will Pass   : " + (student.willPassSemester() ? "Yes" : "No"));
	    
	    // Check if the student is able to ascend
	    if (student.getGpa() >= 4.0) {
	        System.out.println(" Will Ascend : Yes");
	    } 
	    System.out.println("====================================\n");
	}
	
	public static void main(String[] args) {
		// Create and use the students
		StudentInfo student_data_id01 = new StudentInfo("Yanis Sebastian Zürcher", "Yanis Sebastian", "Zürcher", 16, 3.9);
		StudentInfo student_data_id02 = new StudentInfo("Koichiro Möller", "Koichiro", "Möller", 16, 3.0);
		StudentInfo student_data_id03 = new StudentInfo("Cem Kurd", "Cem", "Kurd", 16, 2.0);
		StudentInfo student_data_id04 = new StudentInfo("Leart Azemi", "Leart", "Azemi", 16, 2.4);
		StudentInfo student_data_id05 = new StudentInfo("Smart Student", "Smart", "Student", 16, 4.2);
		StudentInfo student_data_id06 = new StudentInfo("TEst Test", "TEst", "Test", 15, 2); //Passing gpa is 2.5, this is just a test
		
		// Create a list of students
		List<StudentInfo> students = Arrays.asList(
				student_data_id01, 
				student_data_id02, 
				student_data_id03, 
				student_data_id04,
				student_data_id05,
				student_data_id06
		);
		// Sort the students by GPA in decending order
		Collections.sort(students);
		
		// Print the initial warning and notes
		printInitialNotesOrWarnings();
		
		// Print Student Info according to the above thing 
		for (StudentInfo student : students) {
			printStudentInfo(student);
		}
	}
}
