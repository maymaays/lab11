package tasktimer;

import static java.lang.System.out;
import java.io.InputStream;
import java.util.*;

/**
 * Process all the words in a file using Scanner to read and parse input.
 */
public class Task1 implements Runnable {

	private InputStream instream = Dictionary.getWordAsStream();
	private Scanner in = new Scanner(instream);

	/**
	 * Runs the task 1
	 */
	public void run() {

		int count = 0;
		long totalsize = 0;
		while (in.hasNext()) {
			String word = in.next();
			totalsize += word.length();
			count++;
		}
		double averageLength = ((double) totalsize) / (count > 0 ? count : 1);
		out.printf("Average length of %,d words is %.2f\n", count, averageLength);

	}

	/**
	 * Get the description of the task
	 */
	public String toString() {
		return "Starting task: read words using Scanner and a while loop";

	}

}
