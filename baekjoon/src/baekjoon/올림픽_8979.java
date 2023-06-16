package baekjoon;

import java.util.*;
import java.io.*;

public class ¿Ã¸²ÇÈ_8979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1]) {
					return o2[1] - o1[1];
				} else {
					if (o1[2] != o2[2]) {
						return o2[2] - o1[2];
					} else {
						return o2[3] - o1[3];
					}
				}
			}
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.add(new int[] { a, b, c, d });
		}
		
		int idx = 1;

		Stack<int[]> s = new Stack<>();
		
		while(!pq.isEmpty()) {
			if (pq.peek()[0]!=K) {
				s.add(pq.poll());
				idx++;
			} else {
				if (!s.isEmpty()) {
					while (pq.peek()[1]==s.peek()[1]&&pq.peek()[2]==s.peek()[2]&&pq.peek()[3]==s.peek()[3]) {
						s.pop();
						idx--;
					}
				}
				break;
			}
		}
		
		System.out.println(idx);

	}

}
