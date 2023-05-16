package baekjoon;

import java.util.*;

public class 음악프로그램_2623 {
	
	static int v, e, num;
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
			num = sc.nextInt();
			int[] temp = new int[num];
			
			for (int j=0;j<num;j++) {
				temp[j]=sc.nextInt();
			}
			
			for (int j=0;j<num-1;j++) {
				int from = temp[j];
				int to = temp[j+1];
				graph.get(from).add(to);
				indegree[to]++;
			}
		}
		
		topologicalSort(indegree, graph);
		
		
	}
	
	static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		
		for (int i=1;i<=v;i++) {
			if (indegree[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			result.add(node);
			
			for (Integer i : graph.get(node)) {
				indegree[i]--;
				if (indegree[i]==0) {
					queue.add(i);
				}
			}
		}
		if (result.size()!=v) {
			System.out.println(0);
		} else {
			for (int i=0;i<v;i++) {
				System.out.println(result.poll());	
			}	
		}
	}
	
}
