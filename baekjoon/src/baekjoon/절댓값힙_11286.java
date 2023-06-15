package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;

public class Àý´ñ°ªÈü_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1)<Math.abs(o2)) {
					return -1;
				} else if (Math.abs(o1)==Math.abs(o2)) {
					if (o1<o2) {
						return -1;
					} else return 1;
				} else return 1;
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num==0) {
				if (!pq.isEmpty()) {
					bw.write(String.valueOf(pq.poll()));
				} else {
					bw.write("0");
				}
				bw.newLine();
			} else {
				pq.add(num);
			}
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
