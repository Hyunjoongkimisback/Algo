
//프림으로 최소스패닝트리 해보자
// priorityQueue로 하는거
// 크루스칼하고 차이는 Node를 end, weight만 두고
// 양방향 다 입력해주는것.

import java.util.*;
import java.io.*;

public class 네트워크연결_1922 {
	
	public static class Node implements Comparable<Node>{
		int end, weight;
		
		public Node (int end, int weight) {
			this.end=end;
			this.weight=weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for (int i=0;i<V+1;i++) {
			graph.add(new ArrayList<>());
		}
		boolean[] visited = new boolean[V+1];
		
		
		for (int i = 0; i < E; i++) {
			String[] sew = br.readLine().split(" ");
			int a = Integer.parseInt(sew[0]);
			int b = Integer.parseInt(sew[1]);
			int c = Integer.parseInt(sew[2]);
			
			graph.get(a).add(new Node(b,c));
			graph.get(b).add(new Node(a,c));
		}
		
		int total =0;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(1,0));
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if (!visited[curr.end]) {
				visited[curr.end]=true;
				total+=curr.weight;
				
				for (Node next : graph.get(curr.end)) {
					if (!visited[next.end]) {
						queue.add(next);
					}
				}
				
			}
		}
		System.out.println(total);
		
		
	}
}
