package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import tasktimer.TaskTimer.IntCounter;

/**
 *
 * Process all the words in a file (one word per line) using BufferedReader and
 * the lines() method which creates a Stream of Strings (one item per line).
 */
public class Task3 implements Runnable {

	private InputStream instream = Dictionary.getWordAsStream();
	private BufferedReader br = null;

	/** Runs the task 3 */
	public void run() {

		try {
			br = new BufferedReader(new InputStreamReader(instream));
		} catch (Exception ex) {
			out.println("Could not open dictionary: " + ex.getMessage());
			return;
		}

		IntCounter counter = new IntCounter();
		br.lines().mapToInt(word -> word.length()).forEach(counter);

		try {
			br.close();
		} catch (IOException ex) {
		}
		out.printf("Average length of %,d words is %.2f\n", counter.getCount(), counter.average());
	}

	/**
	 * Get the description of task 3
	 */
	public String toString() {
		return "Starting task: read words using BufferedReader and Stream";
	}

}
