package tasktimer;

/**
 * Calculating the start running time, the stop time, and the elapsed time
 * @author Methawee Apinainarong 5810546714
 *
 */
public class StopWatch {

	private double startTime;
	private double stopTime;
	private boolean running;

	/**
	 * Compute the starting time
	 */
	public void start() {
		startTime = System.nanoTime();
	}

	/**
	 * Compute the end time
	 */
	public void stop() {
		stopTime = System.nanoTime();
	}

	/**
	 * Compute the elapsed time
	 * @return the elapsed time
	 */
	public double getElapsed() {
		return (stopTime - startTime);
	}

}
