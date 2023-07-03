package Gold;

import java.util.*;
import java.io.*;

public class µ¿Àü1_2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NK = br.readLine().split(" ");

		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		int[] arr = new int[N];
		int[] dp = new int[K+1];
		
		for (int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		dp[0]=1;
		for (int i=0;i<N;i++) {
			for (int j=arr[i];j<K+1;j++) {
				dp[j]+=dp[j-arr[i]];
			}
		}
		
		System.out.println(dp[K]);
		
		
	}
}
