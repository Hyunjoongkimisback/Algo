
import java.util.*;
import java.io.*;

public class 다리놓기_1010 {
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc<T;tc++) {
			String[] NM =br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			dp= new int[30][30];
			
			
			sb.append(comb(M, N)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	private static int comb (int n, int r) {
		if (dp[n][r]>0) {
			return dp[n][r];
		}
		
		if (n==r || r==0) {
			return dp[n][r]=1;
		}
		
		return dp[n][r]=comb(n-1, r) + comb(n-1, r-1);
	}
}
