package Gold;

import java.util.*;
import java.io.*;

public class 평범한배낭_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		int[] dp = new int[K+1]; 
		
		for (int i=1;i<N+1;i++) {
			String[] WV = br.readLine().split(" ");
			W[i] = Integer.parseInt(WV[0]);
			V[i] = Integer.parseInt(WV[1]);
		}
		// 입력 끝
		
		// bottom UP 방식
		for (int i=1;i<N+1;i++) {
			for (int j=K;j-W[i]>=0;j--) {
				dp[j] = Math.max(dp[j], dp[j-W[i]]+V[i]);
			}
		}
		System.out.println(dp[K]);
		
//		// 이거는 Top-down, dp의 정석
//		Integer[][] dpTobDown = new Integer[N][K+1];
//		System.out.println(knapsack(N-1,K,dpTobDown,W,V));
		
	}
	
	
//	// 이거는 Top-down, dp의 정석
//	static int knapsack(int i, int k, Integer[][] dp, int[] W, int[] V) {
//		if (i<0) {
//			return 0;
//		}
//		
//		if (dp[i][k]==null) {
//			if (W[i]> k) {
//				dp[i][k] = knapsack(i-1,k,dp,W,V);
//			}
//			else {
//				dp[i][k]= Math.max(knapsack(i-1,k,dp,W,V), knapsack(i-1,k-W[i],dp,W,V)+V[i]);
//			}
//		}
//		return dp[i][k];
//	}
	
	
	
	
}
