package student;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * A student with a name, student id, and birthday.
 * 
 * @author jim
 */
public class Student {
	private String id;
	private String firstname, lastname;
	private LocalDate birthdate;

	/**
	 * Initialize attributes of a new student
	 * 
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param birthdate
	 */
	public Student(String id, String firstname, String lastname, String birthday) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		setBirthdate(birthday);
	}

	/**
	 * Get the student's first name.
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Get the student's last name.
	 * 
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Get the student's birth date.
	 * 
	 * @return the birthdate as a LocalDate instance.
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * Get the student's ID.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * A hacky method for setting the birthdate using String.
	 * 
	 * @param datestr
	 *            is a String containing birthday in the format "dd/mm/yyyy".
	 * @throws IllegalArgumentException
	 *             if datestr is not in the correct format.
	 */
	// TODO Improve this code. Let LocalDate and DateTimeFormatter parse
	// the string for you. Eliminate the use of Scanner!
	private void setBirthdate(String datestr) {
		
		

		
//		String strDate = "2015-08-04";
//		LocalDate aLD = LocalDate.parse(strDate);
//		System.out.println("Date: " + aLD);
//
//		String strDatewithTime = "2015-08-04T10:11:30";
//		LocalDateTime aLDT = LocalDateTime.parse(strDatewithTime);
//		System.out.println("Date with Time: " + aLDT);

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
			birthdate = LocalDate.parse(datestr, formatter);
		} catch (DateTimeException exception) {
			throw exception;
		}

	}

	@Override
	public String toString() {
		return firstname + " " + lastname;
	}
}
