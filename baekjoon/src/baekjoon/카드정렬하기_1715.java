package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 카드정렬하기_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1>o2?1:-1;
			}
		});
		
		Integer result=0;
		
		for (int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(num);
		}
		
		while (pq.size()>1) {
			Integer n1= pq.poll();
			Integer n2= pq.poll();
			
			result+=n1+n2;
			pq.add(n1+n2);
			
		}
		
		System.out.println(result);
		
		
	}
}
