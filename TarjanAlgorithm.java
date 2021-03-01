package com.graphs;

import java.util.*;

public class TarjanAlgorithm {
	
	
	int v;
	Map<Integer, List<Integer>> adjMap;
	int time; //really important for tarjan algorithm.. 
	
	
	public TarjanAlgorithm(int v) {
		this.v = v;
		adjMap = new HashMap<>();
		
		for(int i=0; i<v; i++) {
			adjMap.put(i, new LinkedList<>());
		}
		
	}
	
	//Adding edges to the given
	
	void addEdge(int v, int w) {
		adjMap.get(v).add(w);
	}
	
	void SCC() {
		
		int disc[] = new int[v];
		int low[] = new int[v];
		
		for(int i=0; i<v; i++) {
			disc[i]=-1;
			low[i]=-1;
		}
		
		boolean stackMember[] = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<v; i++) {
			if(!stackMember[i])
				SSCUtil(i, low, disc, stackMember, stack );
		}	
	}
	
	private void SSCUtil(int i, int[] low, int[] disc, boolean[] stackMember, Stack<Integer> stack) {
		
	low[i]=disc[i]=++time;
		
		stackMember[i]=true;
		
		stack.push(i);
		
		while(!stack.isEmpty()) {
			
		List list =	adjMap.get(i);
		Iterator<Integer> itr = list.listIterator();
		while(itr.hasNext()) {
			int n = itr.next();
			
			//if this is a root node.
			if(disc[n] == -1) {
				
				SSCUtil(n, low, disc, stackMember, stack );
				
				low[i]=Math.min(low[n], low[i]);
				
			} else if (stackMember[n] == true) {
				
				
				low[i]=Math.min(low[n], disc[i]);
			}
		}
		
		int w=-1;
		
		if(low[i]==disc[i]) {
			
			while(w != i) {
				 w = (int) stack.pop();
				System.out.println(w + " ");
				stackMember[w]=false;
			}
			System.out.println();

			
			
		}
		
		
			
			
		}
		
		
		
		
	}

	public static void main(String[] args) {
		  // Create a TarjanAlgorithm given in the above diagram  
	    TarjanAlgorithm g1 = new TarjanAlgorithm(5);  
	  
	    g1.addEdge(1, 0); 
	    g1.addEdge(0, 2); 
	    g1.addEdge(2, 1); 
	    g1.addEdge(0, 3); 
	    g1.addEdge(3, 4); 
	    System.out.println("SSC in first TarjanAlgorithm "); 
	    g1.SCC(); 
	  
	    TarjanAlgorithm g2 = new TarjanAlgorithm(4); 
	    g2.addEdge(0, 1); 
	    g2.addEdge(1, 2); 
	    g2.addEdge(2, 3); 
	    System.out.println("\nSSC in second TarjanAlgorithm "); 
	    g2.SCC(); 
	      
	    TarjanAlgorithm g3 = new TarjanAlgorithm(7); 
	    g3.addEdge(0, 1); 
	    g3.addEdge(1, 2); 
	    g3.addEdge(2, 0); 
	    g3.addEdge(1, 3); 
	    g3.addEdge(1, 4); 
	    g3.addEdge(1, 6); 
	    g3.addEdge(3, 5); 
	    g3.addEdge(4, 5); 
	    System.out.println("\nSSC in third TarjanAlgorithm "); 
	    g3.SCC(); 
	      
	    TarjanAlgorithm g4 = new TarjanAlgorithm(11); 
	    g4.addEdge(0, 1); 
	    g4.addEdge(0, 3); 
	    g4.addEdge(1, 2); 
	    g4.addEdge(1, 4); 
	    g4.addEdge(2, 0); 
	    g4.addEdge(2, 6); 
	    g4.addEdge(3, 2); 
	    g4.addEdge(4, 5); 
	    g4.addEdge(4, 6); 
	    g4.addEdge(5, 6); 
	    g4.addEdge(5, 7); 
	    g4.addEdge(5, 8); 
	    g4.addEdge(5, 9); 
	    g4.addEdge(6, 4); 
	    g4.addEdge(7, 9); 
	    g4.addEdge(8, 9); 
	    g4.addEdge(9, 8); 
	    System.out.println("\nSSC in fourth TarjanAlgorithm "); 
	    g4.SCC();  
	      
	    TarjanAlgorithm g5 = new TarjanAlgorithm (5); 
	    g5.addEdge(0, 1); 
	    g5.addEdge(1, 2); 
	    g5.addEdge(2, 3); 
	    g5.addEdge(2, 4); 
	    g5.addEdge(3, 0); 
	    g5.addEdge(4, 2); 
	    System.out.println("\nSSC in fifth TarjanAlgorithm "); 
	    g5.SCC(); 

	}

}
