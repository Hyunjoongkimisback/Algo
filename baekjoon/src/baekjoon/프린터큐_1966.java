package baekjoon;

import java.util.*;

public class 프린터큐_1966 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for (int tc=0;tc<T;tc++) {
			
			int N = sc.nextInt();
			int M=sc.nextInt();
			
			LinkedList<int[]> q = new LinkedList<>();
			
			for (int i=0;i<N;i++) {
				int num = sc.nextInt();
				q.add(new int[] {num, i});
			}
			
			int seq=0;
			
			while (!q.isEmpty()) {
				boolean flag= true;
				
				int[] curr = q.poll();
				
				for (int i=0;i<q.size();i++) {
					if (curr[0] < q.get(i)[0]) {
						q.addLast(curr);
						for (int j=0;j<i;j++) {
							q.add(q.poll());
						}
						flag=false;
						break;
					}
				}
				if (flag) {
					seq++;
					if (curr[1]==M) {
						sb.append(seq).append('\n');
						break;
					} 
				}
			}
		}
		System.out.println(sb);
		
	}
}
