package baekjoon;

import java.util.*;

public class 줄세우기_2252 {
	
	static int v, e;
	static int[] indegree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v= sc.nextInt();
		e= sc.nextInt();
		
		indegree = new int[v+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i=0;i<=v;i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0;i<e;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			graph.get(from).add(to);
			indegree[to]++;
		}
		
		topologicalSort(indegree, graph);
		
		
	}
	
	static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb= new StringBuilder();
		
		for (int i=1;i<=v;i++) {
			if (indegree[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node+" ");
			
			for (Integer i : graph.get(node)) {
				indegree[i]--;
				if (indegree[i]==0) {
					queue.add(i);
				}
			}
		}
		System.out.println(sb);
	}
	
}
