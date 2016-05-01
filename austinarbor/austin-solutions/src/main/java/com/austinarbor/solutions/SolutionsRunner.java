package com.austinarbor.solutions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.solutions.annotation.RunnableSolution;

import javassist.Modifier;

public class SolutionsRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(SolutionsRunner.class);

	private String basePackage;
	private Reflections reflections;
	
	private static final String DEFAULT_PACKAGE = "com.austinarbor.solutions";
	
	public SolutionsRunner() {
		this(DEFAULT_PACKAGE);
	}
	
	public SolutionsRunner(final String basePackage) {
		this.basePackage = basePackage;
		reflections = new Reflections(this.basePackage);
	}
	
	public Set<Class<?>> getRunnableClasses() {
		Set<Class<?>> classes = reflections.getTypesAnnotatedWith(RunnableSolution.class);
		return classes;
	}
	
	public void runSolutions() {
		LOGGER.info("BEGIN");
		final Set<Class<?>> runnableClasses = getRunnableClasses();
		for(Class<?> clazz : runnableClasses) {
			if(!Modifier.isAbstract(clazz.getModifiers())) {
				try {
					LOGGER.info("Creating instance of class " + clazz.getName());
					RunnableSolution annotation = clazz.getAnnotation(RunnableSolution.class);
					final String methodName = annotation.methodName();
					Object obj = (Solution)clazz.newInstance();
					Method runMethod = clazz.getDeclaredMethod(methodName, new Class<?>[0]);
					int numRuns = annotation.times();
					for(int i=0; i < numRuns; i++) {
						runMethod.invoke(obj);
					}
				} catch(NoSuchMethodException nsme) {
					LOGGER.error("Cannot find method run",nsme );
				} catch (InstantiationException | IllegalAccessException e) {
					LOGGER.error("Exception while instantiating class " + clazz.getName(), e);
				} catch (IllegalArgumentException | InvocationTargetException e) {
					LOGGER.error("Exception while invoking the run() method on class " + clazz.getName(), e);
				}
			} 
		}
		LOGGER.info("END");
	}
	
	public static void main(String[] args) {
		SolutionsRunner runner =new SolutionsRunner();
		runner.runSolutions();

	}
	
	
}
