package baekjoon;

import java.util.*;
import java.io.*;

public class 숫자카드2_HashMap_10816 {
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			map.put(a, map.getOrDefault(a, 0)+1);
		}
		
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<M;i++) {
			int a = Integer.parseInt(st.nextToken());
			Integer count = map.get(a);
			if (count == null) {
				count=0;
			}
			sb.append(count).append(' ');
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
