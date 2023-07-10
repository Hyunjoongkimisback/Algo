package Silver;

import java.util.*;
import java.io.*;

public class 신입사원_1946 {
	
	public static class Node implements Comparable<Node> {
		int paper, interview;
		
		public Node(int paper, int interview) {
			this.paper=paper;
			this.interview=interview;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.paper-o.paper;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0;tc<T;tc++) {
			List<Node> list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			for (int i=0;i<N;i++) {
				String[] ab = br.readLine().split(" ");
				int a = Integer.parseInt(ab[0]);
				int b = Integer.parseInt(ab[1]);
				list.add(new Node(a, b));
			}
			Collections.sort(list);
			
			int cnt = 1;
			int min = list.get(0).interview;
			
			
			for (int i=1;i<list.size();i++) {
				if (list.get(i).interview <min) {
					cnt++;
					min=list.get(i).interview;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		
	}
}
