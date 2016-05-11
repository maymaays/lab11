package tasktimer;

import java.io.InputStream;

/**
 * Creating an InputStream to read from the file
 * 
 * @author Methawee Apinainarong 5810546714
 */
public class Dictionary {

	public static InputStream getWordAsStream() {
		return TaskTimer.class.getClassLoader().getResourceAsStream("wordlist.txt");
	}

}
