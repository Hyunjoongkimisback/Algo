package baekjoon;

import java.util.*;
import java.io.*;

public class 숫자카드2_이진검색_10816 {
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<M;i++) {
			int a = Integer.parseInt(st.nextToken());
			int cnt = UpperBound(a, arr, 0, arr.length)-LowerBound(a, arr, 0, arr.length);
			sb.append(cnt).append(' ');
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int UpperBound(int key, int[] arr, int left, int right) {
		while (left<right) {
			int mid = left +(right-left)/2;
			
			if (arr[mid]>key) {
				right= mid;
			} else {
				left = mid+1;
			}
		}
		return left;
	}
	private static int LowerBound(int key, int[] arr, int left, int right) {
		while (left<right) {
			int mid = left+(right-left)/2;
			
			if (arr[mid]>=key) {
				right=mid;
			} else {
				left = mid+1;
			}
		}
		return left;
	}
	
}
