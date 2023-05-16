package baekjoon;

import java.util.*;

public class 가장큰증가하는부분수열_11055 {
	static int[] arr, dp;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N= sc.nextInt();
		arr= new int[N];
		for (int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		dp= new int[N];
		dp[0]=arr[0];
		
		for (int i=1;i<N;i++) {
			dp[i]=arr[i];
			for (int j=0;j<i;j++) {
				if (arr[i]>arr[j]) {
					dp[i]=Math.max(dp[j]+arr[i], dp[i]);
				}
			}
		}
		int max= 0;
		for (int i=0;i<N;i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}
