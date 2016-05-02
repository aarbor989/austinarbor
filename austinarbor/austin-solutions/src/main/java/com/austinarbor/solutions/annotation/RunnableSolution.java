package com.austinarbor.solutions.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies that a class can automatically be discovered
 * and executed by SolutionsRunner
 * @author Austin G. Arbor
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RunnableSolution {
	/**
	 * The name of the method for SolutionsRunner to invoke. Default "run"
	 * @return The name of the method to invoke
	 */
	String methodName() default "run";
	/**
	 * The number of times to run the method.  Default 1.
	 * @return The number of times to run the method
	 */
	int times() default 1;
}
