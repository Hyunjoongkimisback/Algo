package Silver;

import java.util.*;

public class 계단오르기_test {
	static int[] arr;
	static Integer[] dp;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		
		arr = new int[301];
		dp=new Integer[301];
		
		for (int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		
		
		dp[0]=0;
		dp[1]=arr[1];
		dp[2]=arr[1]+arr[2];
		if (N>2) {
			System.out.println(recur(N));
		} else {
			System.out.println(dp[N]);
		}
		
	}
	
	static int recur (int n) {
		if (dp[n]==null) {
			dp[n]=Math.max(recur(n-3)+arr[n-1]+arr[n], recur(n-2)+arr[n]);
		}
		return dp[n];
	}
}	