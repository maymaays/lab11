package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*; // hack, using AtomicInteger as accumulator

/**
 * Computing time how long it takes to perform some tasks by using different
 * programming constructs.
 * @author Methawee Apinainarong 5810546714
 */
public class TaskTimer {

	/**
	 * An IntConsumer is a special Consumer interface the has an 'int' parameter in accept().
	 */
	static class IntCounter implements IntConsumer {
		public int count = 0;
		private long total = 0;

		/**
		 * Accept consumes an int. In this method, 
		 * count the value and add it to total.
		 */
		public void accept(int value) {
			count++;
			total += value;
		}

		/** Get the average of all the values consumed. */
		public double average() {
			return (count > 0) ? ((double) total) / count : 0.0;
		}

		/** Get the counting times */
		public int getCount() {
			return count;
		}
	}

	/**
	 * Run the task (Runnable), prints description of the task, and prints
	 * elapsed time - how much time we used
	 * @param task - task that user want to run and print
	 */
	public static void execAndPrint(Runnable task) {
		System.out.println(task.toString());
		StopWatch watch = new StopWatch();
		watch.start();
		task.run();
		watch.stop();
		out.printf("Elapsed time is %f sec\n", (watch.getElapsed()) * 1.0E-9);
	}

	/** Run all the tasks */
	public static void main(String[] args) {
		execAndPrint(new Task1());
		execAndPrint(new Task2());
		execAndPrint(new Task3());
		execAndPrint(new Task4());
		execAndPrint(new Task5());
		execAndPrint(new Task6());
	}

}
