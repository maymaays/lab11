package student;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.time.LocalDate;

/**
 * Display reminders of students having a birthday soon.
 * @author Methawee Apinainarong 5810546714
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the specified month.
	 * @param students list of the student
	 * @param filter the specified condition to use in selecting bithdays
	 * @param action represents an operation that accepts a single input argument
	 *            and returns no result
	 * @param compare compare student a and student b with the specified condition
	 */
	public void filterAndPrint(List<Student> students, Predicate<Student> filter, Consumer<Student> action,
			Comparator<Student> compare) {
		students.stream().filter(filter).sorted(compare).forEach(action);
	}

	/**
	 * Main method of studentApp class
	 * @param args list of String
	 */
		public static void main(String[] args) {

		List<Student> students = Registrar.getInstance().getStudents();

		/** Represents the student's birthday in the next 2 weeks */
		Predicate<Student> birthdaytest = (s) -> (s.getBirthdate().getDayOfYear() > LocalDate.now().getDayOfYear())
				&& (s.getBirthdate().getDayOfYear() < (LocalDate.now().getDayOfYear() + 14));

		/**
		 * Represents the string as (Name Lastname) will have birthday on
		 * (his/her birthday)
		 */
		Consumer<Student> consumer = (s) -> System.out.println(s.getFirstname() + " will have birthday on "
				+ s.getBirthdate().getDayOfMonth() + " " + s.getBirthdate().getMonth() + ".");

		/** Compare the position in sort order of two student's name */
		Comparator<Student> byName = (a, b) -> a.getFirstname().charAt(0) - b.getFirstname().charAt(0);

		/** Compare the position in sort order of two student's birthday */
		Comparator<Student> byBirthday = (a, b) -> a.getBirthdate().getMonth().getValue()
				- b.getBirthdate().getMonth().getValue();

		StudentApp app = new StudentApp();
		app.filterAndPrint(students, birthdaytest, consumer, byBirthday);

	}

}
