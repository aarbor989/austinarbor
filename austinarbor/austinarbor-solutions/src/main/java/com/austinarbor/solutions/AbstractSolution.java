/**
 * 
 */
package com.austinarbor.solutions;

import java.io.File;

/**
 * @author Austin G. Arbor
 *
 */
public abstract class AbstractSolution implements Solution {
	
	protected static final String BASE_INPUT_PATH="input/";
	
	protected String inputFileDirectory;
	
	protected AbstractSolution() { }
	
	protected AbstractSolution(final String className) {
		this.inputFileDirectory = BASE_INPUT_PATH + className;
	}
	
	protected File[] getInputFiles() {
		File inputDir = new File(this.getClass().getClassLoader().getResource(inputFileDirectory).getFile());
		File[] inputFiles = inputDir.listFiles();
		
		return inputFiles;
	}

}
