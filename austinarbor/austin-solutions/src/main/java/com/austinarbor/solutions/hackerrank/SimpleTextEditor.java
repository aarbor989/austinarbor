package com.austinarbor.solutions.hackerrank;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.ds.Stack;
import com.austinarbor.solutions.AbstractSolution;
import com.austinarbor.solutions.SolutionsRunner;
import com.austinarbor.solutions.annotation.RunnableSolution;

/**
 * <p>In this problem, your task is to implement a simple text editor. 
 * Initially, a file contains an empty string . Your task is to perform  
 * operations consisting of the following  types:<br/>
 * <ol><li><i>append(W)</i> - Appends the string <i>W</i>  at the end of <i>S</i></li>
 * <li><i>erase(k)</i> - Erase the last <i>k</i> character of <i>S</i></li>
 * <li><i>get(k)</i> - Returns the <i>kth</i> character of <i>S</i></li>
 * <li><i>undo()</i> - Undo the last not previously undone operation of type <b>1</b> or <b>2</b>, 
 * so it reverts <i>S</i> to the state before that operation.</li></ol>
 * <p><b>Constraints:</b><br>
 * 1 <= Q <= 10^5<br/>
 * 1 <= k <= |S|<br/>
 * The sum of the lengths of all W in the input <= 10^6 <br>
 * All input characters are lowercase English letters<br>
 * It is guaranteed that the sequence of input operation is possible to perform
 * <p><b>Input Format:</b><br>
 * The first line contains <i>Q</i>, the number of operations<br>
 * Each of the following <i>Q</i> lines contains a single integer <i>t</i>, denoting
 * the type of operation listed in the problem statement.  Then, <i>t</i> is followed by the
 * argument of the operation, if it has any, separated by a space.<br><br>
 * For example, if <i>t</i> = 1 then a single string <i>W</i> follows.  If <i>t</i>=2 or 3, a single
 * integer <i>k</i> follows.
 * <p><b>Output Format:</b><br>
 * For each operation of type <b>3</b>, print a single line with the returned character
 * of that operation
 * @author Austin G. Arbor
 * @see <a href="https://www.hackerrank.com/challenges/simple-text-editor">HackerRank Simple Text Editor </a>
 */
@RunnableSolution
public class SimpleTextEditor extends AbstractSolution {
	
	private static final transient Logger LOGGER = LoggerFactory.getLogger(SimpleTextEditor.class);
	
	private Stack<StringBuffer> stack;
	
	public SimpleTextEditor() {
		super(SimpleTextEditor.class.getSimpleName());
	}

	@Override
	public void doRun(Scanner scanner) {
		stack = new Stack<StringBuffer>();
		
		int N = scanner.nextInt();
		LOGGER.info("File has {} test cases", N);
		scanner.nextLine();
		StringBuffer sb = new StringBuffer();
		stack.push(sb);
		//Problem statement incorrectly has Q as the number
		//of operations, but in the sample input provided
		//on the website, there are Q-1 operations.  Added
		// the scanner.hasNext() condition to prevent
		// errors
		for(int i=0; i < N && scanner.hasNext(); i++) {
			LOGGER.info("i: {} ",i);
			int action = scanner.nextInt();
			switch(action) {
			case 1:
				append(scanner.next());
				break;
			case 2:
				erase(scanner.nextInt());
				break;
			case 3:
				get(scanner.nextInt());
				break;
			case 4:
				undo();
				break;
			}
		}
		
	}
	
	public void append(String s) {
		StringBuffer sb = new StringBuffer(stack.peek());
		LOGGER.info("Append {} to {}",s,sb.toString());
		sb.append(s);
		stack.push(sb);
	}
	
	public void erase(int k) {
		StringBuffer sb = new StringBuffer(stack.peek());
		// System.out.println("Delete " + k + " characters from " + sb.toString());
		LOGGER.info("Delete {} characters from {}", k, sb.toString());
		sb.delete(sb.length()-k, sb.length());
		stack.push(sb);
	}
	
	public void get(int k) {
		LOGGER.info("Get character {} from {}", k, stack.peek().toString());
		System.out.println(stack.peek().charAt(k-1));
	}
	
	public void undo() {
		StringBuffer original = stack.pop();
		LOGGER.info("Undo: {} -> {}", original.toString(), stack.peek().toString());
	}

}
