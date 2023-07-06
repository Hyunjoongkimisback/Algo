package Silver;

import java.util.*;
import java.io.*;

public class 포도주시식_2156 {
	static Integer[] dp;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N+1];
		dp = new Integer[N+1];
		
		for (int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		
		dp[0]=0;
		dp[1]=arr[1];
		
		if (N>1) {
			dp[2]=arr[1]+arr[2];
		}
		
		
		System.out.println(recur(N));
	}
	
	private static int recur (int N) {
		if (dp[N]==null) {
			dp[N]= Math.max(Math.max(recur(N-3) + arr[N-1] , recur(N-2))+arr[N], recur(N-1));
		}
		return dp[N];
	}
}
