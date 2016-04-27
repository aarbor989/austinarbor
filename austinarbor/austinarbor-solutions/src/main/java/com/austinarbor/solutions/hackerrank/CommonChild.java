/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Austin
 *
 */
public class CommonChild {

/*	public static void main(String[] args) {
		Map<Character, List<Integer>> charIndex = new HashMap<Character, List<Integer>>();
		String a= "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS";
		String b = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC";
		//output should be 15
		int maxLength = 0;
		//int curLength;		

		List<Integer> backTracks = new ArrayList<Integer>();
		Set<Integer> backTrackIdxs = new HashSet<Integer>();
		List<State> retraceList = new ArrayList<State>();
		Set<Integer> retraceSet = new HashSet<Integer>();
		for(int i=0; i < a.length(); i++) {
			char c = a.charAt(i);
			if(!charIndex.containsKey(c)) {
				List<Integer> indexes = new ArrayList<Integer>();
				indexes.add(i);
				charIndex.put(c, indexes);
			} else {
				charIndex.get(c).add(i);
			}
		}
		backTracks.add(0);
		boolean retrace = false;
		int start;
		int otherStartIdx;
		int startIdx;
		int prevMatchIdx;
		int curLength;
		while(!backTracks.isEmpty() || !retraceList.isEmpty()) {
			if(retrace && !retraceList.isEmpty()) {
				State prevState = retraceList.remove(0);
				start = prevState.idx;
				
				startIdx = prevState.startIdx;
				System.out.println("Retrace from index " + start  + "\tStarted at " + startIdx);
				curLength = prevState.curLength;
				otherStartIdx = prevState.otherStartIdx;
				prevMatchIdx = prevState.prevMatchIdx;
				if(retraceList.isEmpty()) {
					retrace=false;
				}
			} else {
			 start = backTracks.remove(0);
			  otherStartIdx=-1;
			 startIdx=-1;
			 prevMatchIdx = -1;
			 curLength=0;
			}
			
			for(int i=start; i < b.length(); i++) {
				char c = b.charAt(i);
				if(charIndex.containsKey(c)) {
					
					if(startIdx==-1) {
						System.out.print(c + " ");
						//System.out.println("Starting new match " + c);
						startIdx = i;
						curLength=1;
						otherStartIdx = charIndex.get(c).get(0);
						prevMatchIdx = otherStartIdx;
					} else {
						for(Integer idx : charIndex.get(c)) {
							if(idx < otherStartIdx) {
								//System.out.println("Adding " + i + " to backtracks");
								if(!backTrackIdxs.contains(idx)) {
									backTracks.add(i);
								}
							}else if(idx > otherStartIdx && idx < prevMatchIdx) {
								retrace = true;
								if(!retraceSet.contains(i)) {
									State state = new State(i, otherStartIdx, curLength, prevMatchIdx, startIdx);
									retraceList.add(state);
									retraceSet.add(i);
								}
							}
							else if(idx > prevMatchIdx) {
								//System.out.println("Will use idx: " + idx + " for char " + c);
								System.out.print(c + " ");
								prevMatchIdx=idx;
								curLength++;
								if(curLength > maxLength) {
									maxLength = curLength;
								}
								break;
							}
						}
					}
				}
			}
			System.out.println();
		}
		System.out.println(maxLength);

	}*/
    public static void main(String[] args) {
        String x = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS";
        String y = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC";
        int M = x.length();
        int N = y.length();

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }
        System.out.println(opt[0][0]);

        // recover LCS itself and print it to standard output
       /* int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();
*/
    }
	
	public static class State {
		public int idx;
		public int otherStartIdx;
		public int curLength;
		public int prevMatchIdx;
		public int startIdx;
		
		public State(int idx, int otherStartIdx, int curLength, int prevMatchIdx, int startIdx) {
			this.idx = idx;
			this.otherStartIdx = otherStartIdx;
			this.curLength = curLength;
			this.prevMatchIdx = prevMatchIdx;
			this.startIdx = startIdx;
		}
	}

}
