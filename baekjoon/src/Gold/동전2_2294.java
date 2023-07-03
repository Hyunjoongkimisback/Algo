package Gold;

import java.util.*;
import java.io.*;

public class 동전2_2294 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NK = br.readLine().split(" ");

		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		int[] coin = new int[N];
		int[] dp = new int[K+1];
		
		for (int i=0;i<N;i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		// 입력 끝
		
		Arrays.fill(dp, 100001);
		dp[0]=0;
		
		for (int i=0;i<N;i++) {
			for (int j=coin[i];j<K+1;j++) {
				dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);	
			}
		}
		
		if (dp[K]==100001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}

	}
}
