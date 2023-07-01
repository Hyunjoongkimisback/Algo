package baekjoon;

import java.util.*;
import java.io.*;

public class 최단거리_1753 {
	
	public static class Node implements Comparable<Node> {
		int v, w;
		public Node (int v, int w) {
			this.v=v;
			this.w=w;
		}
		
		@Override
		public int compareTo(Node o) {
			return w-o.w;
		}
	}
	
	static int v, e, k;
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		String[] ve = br.readLine().split(" ");
		v = Integer.parseInt(ve[0]);
		e = Integer.parseInt(ve[1]);
		
		k = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i=0;i<v+1;i++) {
			graph.add(new ArrayList<>());
		}
		
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i=0;i<e;i++) {
			String[] uvw = br.readLine().split(" ");
			int a = Integer.parseInt(uvw[0]);
			int b = Integer.parseInt(uvw[1]);
			int c = Integer.parseInt(uvw[2]);
			
			graph.get(a).add(new Node(b,c));
		}
		dijkstra(k);
		
		for (int i=1;i<v+1;i++) {
			if (dist[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]+"\n");
			}
		}
		System.out.println(sb);
		
	}
	
	private static void dijkstra(int start) { 
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[v+1];
		queue.add(new Node(start, 0));
		dist[start]=0;
		
		while (!queue.isEmpty()) {
			Node currNode = queue.poll();
			int curr = currNode.v;
			
			if (!visited[curr]) {
				visited[curr]=true;
				
				for (Node node : graph.get(curr)) {
					if (dist[node.v] > dist[curr] + node.w) {
						dist[node.v] = dist[curr]+node.w;
						queue.add(new Node(node.v, dist[node.v]));
					}
				}
			}
		}
		
	}
}