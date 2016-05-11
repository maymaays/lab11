package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * Process all the words in a file (one word per line) using BufferedReader and
 * the lines() method which creates a Stream of Strings (one item per line).
 * Then use the stream to compute summary statistics.
 */
public class Task4 implements Runnable {

	InputStream instream = Dictionary.getWordAsStream();
	BufferedReader br = null;

	/**
	 * Runs the task 4
	 */
	public void run() {

		try {
			br = new BufferedReader(new InputStreamReader(instream));
		} catch (Exception ex) {
			out.println("Could not open dictionary: " + ex.getMessage());
			return;
		}

		final AtomicLong total = new AtomicLong();
		final AtomicInteger counter = new AtomicInteger();
		// TODO Use a Collector instead of Consumer
		Consumer<String> consumer = new Consumer<String>() {
			public void accept(String word) {
				total.getAndAdd(word.length());
				counter.incrementAndGet();
			}
		};

		br.lines().forEach(consumer);
		try {
			br.close();
		} catch (IOException ex) {
		}
		int count = counter.intValue();
		double averageLength = (count > 0) ? total.doubleValue() / count : 0.0;
		out.printf("Average length of %,d words is %.2f\n", count, averageLength);

	}

	/**
	 * Get the description of task 4
	 */
	public String toString() {
		return "Starting task: read words using BufferedReader and Stream with Collector";
	}

}
