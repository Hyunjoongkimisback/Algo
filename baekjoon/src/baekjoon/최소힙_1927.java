package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class √÷º“»¸_1927 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i=0;i<N;i++) {
			int num= Integer.parseInt(br.readLine());
			
			if (num==0) {
				if (pq.isEmpty()) {
					bw.write("0");
				} else {
					bw.write(String.valueOf(pq.poll()));
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
