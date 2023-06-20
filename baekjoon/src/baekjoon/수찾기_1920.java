package baekjoon;

import java.util.*;
import java.io.*;

public class ¼öÃ£±â_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<M;i++) {
			int a = Integer.parseInt(st.nextToken());
			
			int result = binarySearch(a, arr, 0, arr.length-1);
			sb.append(result).append('\n');
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int binarySearch(int a, int[] arr, int left, int right){
		int mid;
		
		while (left<=right) {
			mid = (left+right)/2;
			if (arr[mid]==a) {
				return 1;
			} else if (arr[mid] < a) {
				left = mid+1;
			} else if (arr[mid] > a) {
				right = mid-1;
			}
		}
		return 0;
	}
	
	
}
