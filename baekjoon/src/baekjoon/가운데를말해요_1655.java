package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 가운데를말해요_1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minPQ = new PriorityQueue<>((o1,o2) -> o1-o2);
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2) -> o2-o1);
		
		for (int i=0;i<N;i++) {
			Integer num = Integer.parseInt(br.readLine());
			
			if (maxPQ.size()==minPQ.size()) {
				maxPQ.add(num);
			} else {
				minPQ.add(num);
			}
			
			if (!minPQ.isEmpty()&&!maxPQ.isEmpty()) {
				if (minPQ.peek()<maxPQ.peek()) {
					Integer temp = minPQ.poll();
					minPQ.add(maxPQ.poll());
					maxPQ.add(temp);
				}
			}
			
			bw.write(String.valueOf(maxPQ.peek()));
			bw.newLine();
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
