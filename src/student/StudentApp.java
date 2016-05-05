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
	 * @param students list of students
	 * @param month
	 *            the month to use in selecting bithdays
	 */
	public void filterAndPrint(List<Student> students, Predicate<Student> filter, Consumer<Student> action,
			Comparator<Student> compare) {

		students.stream().filter(filter).sorted(compare).forEach(action);
	}

	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		
		Predicate<Student> birthdaytest = (s) -> (s.getBirthdate().getDayOfYear() > LocalDate.now().getDayOfYear())
				&& (s.getBirthdate().getDayOfYear() < (LocalDate.now().getDayOfYear() + 14));
		
		
		Consumer<Student> consumer = (s) -> System.out.println(s.getFirstname() + " will have birthday on "
				+ s.getBirthdate().getDayOfMonth() + " " + s.getBirthdate().getMonth() + ".");
		Comparator<Student> byName = (a, b) -> a.getFirstname().charAt(0) - b.getFirstname().charAt(0);
		Comparator<Student> byBirthday = (a, b) -> a.getBirthdate().getMonth().getValue() -
				b.getBirthdate().getMonth().getValue();
		
		StudentApp app = new StudentApp();
		app.filterAndPrint(students, birthdaytest, consumer, byBirthday);
	

	}

}
