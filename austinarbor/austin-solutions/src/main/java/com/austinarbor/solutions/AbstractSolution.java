/**
 * 
 */
package com.austinarbor.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Austin G. Arbor
 *
 */
public abstract class AbstractSolution implements Solution {
	
	protected static final transient Logger LOGGER = LoggerFactory.getLogger(AbstractSolution.class);
	
	/**
	 * The base input directory path on the classpath
	 */
	protected static String BASE_INPUT_PATH="input/";
	
	/**
	 * The directory to read input files from
	 */
	protected String inputFileDirectory;
	
	/**
	 * Constructor to be called by subclasses, passing the
	 * class name as a parameter.  The class name is used
	 * to find the directory where input files can be read.
	 * @param className The name of the class calling the constructor
	 * @see #getInputFiles
	 */
	protected AbstractSolution(final String className) {
		this.inputFileDirectory = BASE_INPUT_PATH + className;
	}
	
	/**
	 * This method iterates through all of the input files
	 * found in <code>inputDirectory</code> and creates a 
	 * scanner to read the file.  The scanner is then passed
	 * to  {@link com.austinarbor.solutions.AbstractSolution#doRun(Scanner)} method
	 * @see com.austinarbor.solutions.AbstractSolution#doRun(Scanner)
	 */
	@Override
	public void run() {
		for(final File file : getInputFiles()) {
			try(final Scanner scanner = new Scanner(file)) {
				doRun(scanner);
			}catch(FileNotFoundException fnfe) {
				LOGGER.error("Exception while trying to open file {}",file.getName(),fnfe);
			}
		}
	}
	
	/**
	 * Retrieves the list of files located in the class' input directory for use
	 * when calling the {@link com.austinarbor.solutions.AbstractSolution#run()} method
	 * @return An array of files from the specified input directory
	 * @see com.austinarbor.solutions.Solution#doRun(Scanner)
	 */
	protected File[] getInputFiles() {
		File inputDir = new File(this.getClass().getClassLoader().getResource(inputFileDirectory).getFile());
		File[] inputFiles = inputDir.listFiles();
		
		return inputFiles;
	}

}
