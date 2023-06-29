package baekjoon;

import java.util.*;
import java.io.*;

public class 연결요소의개수_11724 {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" "); 
				
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		graph = new ArrayList<>();
		visited = new boolean[n+1];
		
		for (int i=0;i<n+1;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i=0;i<m;i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		// 인풋 끝
		
		int result =0;
		for (int i=1;i<n+1;i++) {
			if (dfs(i)) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	private static boolean dfs(int x) {
		if (visited[x]) {
			return false;
		} else {
			visited[x]=true;

			for (int i=0;i<graph.get(x).size();i++) {
				int next = graph.get(x).get(i);
				if (!visited[next]) {
					dfs(next);
				}
			}
			return true;
		}
	}
	
//	private static boolean bfs (int x) {
//		Deque<Integer> queue = new ArrayDeque<>();
//		
//		if (visited[x]) {
//			return false;
//		} else {
//			queue.add(x);
//			visited[x]=true;
//			while (!queue.isEmpty()) {
//				int curr = queue.poll();
//				
//				for (int i=0;i<graph.get(curr).size();i++) {
//					int next = graph.get(curr).get(i);
//					if (!visited[next]) {
//						queue.add(next);
//						visited[next]=true;
//					}
//				}
//			}
//			return true;
//		}
//	}
	
	
}
