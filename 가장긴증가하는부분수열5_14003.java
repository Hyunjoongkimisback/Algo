package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장긴증가하는부분수열5_14003 {
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}   
		
		dp= new int[N];
		Arrays.fill(dp, Integer.MIN_VALUE);
		int LIS=0;
		
		for (int i=0;i<N;i++) {
			int idx= binarySearch(arr[i], 0, LIS, LIS+1);
			if (idx==-1) {
				dp[LIS++]=arr[i];
			} else {
				dp[idx]=arr[i];
			}
		}
		System.out.println(LIS);
		
		for (int i=0;i<N;i++) {
			if (dp[i]!=Integer.MIN_VALUE) {
				System.out.printf("%d ",dp[i]);	
			}
		}
	}
	
	static int binarySearch(int num, int start, int end, int size) {
		int res = 0;
		while (start<=end) {
			int mid = (start+end)/2;
			if (num <= dp[mid]) {
				res=mid;
				end=mid-1;
			} else {
				start=mid+1;
			}
		}	
		if (start==size) {
			return -1;
		}
		else {
			return res;
		}
	}
}
