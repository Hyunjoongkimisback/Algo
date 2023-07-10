package Gold;

import java.util.*;
import java.io.*;

public class 팰린드롬_10942 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] ARR = br.readLine().split(" ");
		
		int[] arr = new int[N+1];
		
		boolean[][] dp = new boolean[N+1][N+1];
		
		for (int i=1;i<N+1;i++) {
			arr[i]=Integer.parseInt(ARR[i-1]);
		}
		
		
		// 길이 1
		for (int i=0;i<N+1;i++) {
			dp[i][i]=true;
		}
		
		// 길이 2
		for (int i=1;i<N;i++) {
			if (arr[i]==arr[i+1]) {
				dp[i][i+1]=true;
			}
		}
		
		// 길이 3이상
		for (int i=2;i<N;i++) {
			for (int j=1;j+i<N+1;j++) {
				if (dp[j+1][j+i-1] && arr[j]==arr[j+i]) {
					dp[j][j+i]=true;
				}
			}
		}
		
		
		int M = Integer.parseInt(br.readLine());
		for (int i=0;i<M;i++) {
			String[] LR = br.readLine().split(" ");
			int left = Integer.parseInt(LR[0]);
			int right= Integer.parseInt(LR[1]);
			sb.append(dp[left][right] ? 1 + "\n" : 0 + "\n");
		}
		System.out.println(sb);
	}
}
