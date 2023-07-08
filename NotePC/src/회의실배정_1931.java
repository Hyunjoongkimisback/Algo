import java.util.*;
import java.io.*;

public class 회의실배정_1931 {
	
	public static class Node implements Comparable<Node>{
		int start, end;
		public Node(int s, int e) {
			this.start=s;
			this.end=e;
		}
		@Override
		public int compareTo(Node o) {
			if (end!=o.end) {
				return end-o.end;
			} else {
				return start-o.start;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		
		for (int i=0;i<N;i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			
			queue.add(new Node(a,b));
		}
		int cnt =0;
		
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			cnt++;
			
			while(!queue.isEmpty() && curr.end > queue.peek().start) {
				queue.poll();
			} 
		}
		System.out.println(cnt);
	}
}
