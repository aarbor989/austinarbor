/**
 * 
 */
package com.austinarbor.solutions;

import java.util.Scanner;

/**
 * @author Austin G. Arbor
 *
 */
public interface Solution {
	/**
	 * The wrapper method to call to run the solution.  This method
	 * performs common functionality such as gathering all of the input
	 * files and creating a scanner for the file. The scanner is then passed
	 * to the {@link #doRun(Scanner)} method to perform the actual work
	 * @see #doRun(Scanner)
	 */
	public void run();
	
	/**
	 * The method called by {@link #run()} to execute the actual
	 * code.
	 * @param scanner The file scanner containing input data
	 * @see #run()
	 */
	public void doRun(Scanner scanner);
}
