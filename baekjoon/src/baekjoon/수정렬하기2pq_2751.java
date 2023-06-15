package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 수정렬하기2pq_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N= Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i=0;i<N;i++) {
			int a = Integer.parseInt(br.readLine());
			pq.add(a);
		}
		
		while(!pq.isEmpty()) {
			int result = pq.poll();
			bw.write(result+"\n");
		}
		bw.flush();
		
		
	}
	
	
}
