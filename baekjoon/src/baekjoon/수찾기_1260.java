package baekjoon;

import java.util.*;
import java.io.*;

public class 수찾기_1260 {
	
	static StringBuilder sb; 
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		visited = new boolean[N+1];
		
		// 정점 셋팅
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// 간선 셋팅
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i=0;i<N+1;i++) {
			Collections.sort(graph.get(i));
		}
		
		sb = new StringBuilder();
		DFS(graph, V);
		System.out.println(sb);
		
		Arrays.fill(visited, false);
		
		sb = new StringBuilder();
		BFS(graph, V);
		System.out.println(sb);
	}

	private static void DFS(ArrayList<ArrayList<Integer>> graph, int node) {
		visited[node]=true;
		sb.append(node).append(' ');
		
		for (int i=0;i<graph.get(node).size();i++) {
			int next= graph.get(node).get(i);
			if (!visited[next]) {
				DFS(graph,next);
			}
		}
	}

	private static void BFS(ArrayList<ArrayList<Integer>> graph, int start) {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		visited[start] = true;
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int node= queue.poll();
			sb.append(node).append(' ');
			
			for (int i=0;i<graph.get(node).size();i++) {
				int next = graph.get(node).get(i);
				if (!visited[next]) {
					visited[next]=true;
					queue.add(next);
				}
			}
		}
	}

}
