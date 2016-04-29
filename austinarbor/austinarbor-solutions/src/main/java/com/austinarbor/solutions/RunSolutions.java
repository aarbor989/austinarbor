package com.austinarbor.solutions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javassist.Modifier;

public class RunSolutions {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunSolutions.class);

	public static void main(String[] args) {

		Reflections reflections = new Reflections("com.austinarbor.solutions");
		Set<Class<? extends Solution>> classes = reflections.getSubTypesOf(Solution.class);
		/*for(Class<? extends Solution> c : classes) {
			LOGGER.info("Class: " + c.getName());
		}*/
		for(Class<? extends Solution> clazz : classes) {
			if(!Modifier.isAbstract(clazz.getModifiers())) {
				try {
					LOGGER.info("Creating instance of class " + clazz.getName());
					Object obj = (Solution)clazz.newInstance();
					Method runMethod = clazz.getDeclaredMethod("run", new Class<?>[0]);
					runMethod.invoke(obj);
				} catch(NoSuchMethodException nsme) {
					LOGGER.error("Cannot find method run",nsme );
				} catch (InstantiationException | IllegalAccessException e) {
					LOGGER.error("Exception while instantiating class " + clazz.getName(), e);
				} catch (IllegalArgumentException | InvocationTargetException e) {
					LOGGER.error("Exception while invoking the run() method on class " + clazz.getName(), e);
				}
			} 
		}

	}
}
