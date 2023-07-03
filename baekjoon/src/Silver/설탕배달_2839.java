package Silver;

import java.util.*;

public class ¼³ÅÁ¹è´Þ_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[5001];
		
		int cnt = 0;
		
		dp[0]=-1;
		dp[1]=-1;
		dp[2]=-1;
		dp[3]=1;
		dp[4]=-1;
		if (N>4) {
			if (N%5==1 || N%5==3) {
				dp[N] = N/5 + 1;
			} else if (N%5==2 || N%5==4) {
				dp[N] = N/5 + 2;
			} else {
				dp[N] = N/5;
			}
		}
		dp[7]=-1;
		
		System.out.println(dp[N]);
		
		
	}
	
	
	
}
