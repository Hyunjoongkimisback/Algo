import java.util.*;
import java.io.*;

public class 타일채우기_2133 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+2];
		dp[0]=1;
		dp[2]=3;
		
		if (N%2==0) {
			for (int i=4;i<N+1;i+=2) {
				dp[i]= dp[i-2]*dp[2];
				for (int j=i-4;j>=0;j-=2) {
					dp[i]+=dp[j]*2;
				}
			}
		}
		if (N%2==0) {
			System.out.println(dp[N]);
		} else {
			System.out.println(0);
		}
		
	}
}
