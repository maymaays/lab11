package tasktimer;

import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Process all the words in a file (one word per line) using BufferedReader and
 * the readLine() method. readLine() returns null when there is no more input.
 */

public class Task2 implements Runnable {

	private InputStream instream = Dictionary.getWordAsStream();
	private BufferedReader br = null;

	/**
	 * Runs the task2
	 */
	public void run() {

		try {
			br = new BufferedReader(new InputStreamReader(instream));
		} catch (Exception ex) {
			out.println("Could not open dictionary: " + ex.getMessage());
			return;
		}

		try {
			int count = 0;
			long totalsize = 0;
			String word = null;
			while ((word = br.readLine()) != null) {
				totalsize += word.length();
				count++;
			}
			double averageLength = ((double) totalsize) / (count > 0 ? count : 1);
			out.printf("Average length of %,d words is %.2f\n", count, averageLength);
		} catch (IOException ioe) {
			out.println(ioe);
			return;
		} finally {
			try {
				br.close();
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * Get the description of task 2
	 */
	public String toString() {
		return "Starting task: read words using BufferedReader.readLine() with a loop";
	}

}
