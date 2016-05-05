package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*; // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks using different programming
 * constructs.
 * 
 * TODO Improve this code by restructuring it to eliminate duplicate code.
 */
public class TaskTimer {
	static class IntCounter implements IntConsumer {
		// count the values
		public int count = 0;
		// total of the values
		private long total = 0;

		/**
		 * accept consumes an int. In this method, count the value and add it to
		 * total.
		 */
		public void accept(int value) {
			count++;
			total += value;
		}

		/** Get the average of all the values consumed. */
		public double average() {
			return (count > 0) ? ((double) total) / count : 0.0;
		}

		public int getCount() {
			return count;
		}
	}

	/**
	 * Process all the words in a file (one word per line) using BufferedReader
	 * and the lines() method which creates a Stream of Strings (one item per
	 * line). Then use the stream to compute summary statistics. This is same as
	 * task3, except we use a Collector instead of Consumer.
	 */

	public static void execAndPrint(Runnable task) {

		System.out.println(task.toString());
		StopWatch watch = new StopWatch();
		watch.start();
		task.run();
		watch.stop();
		out.printf("Elapsed time is %f sec\n", (watch.getElapsed()) * 1.0E-9);


	}

	/** Run all the tasks. */
	public static void main(String[] args) {
		
		execAndPrint(new Task1());
		execAndPrint(new Task2());
		execAndPrint(new Task3());
		execAndPrint(new Task4());
		execAndPrint(new Task5());
		execAndPrint(new Task6());

	}

}
