import java.util.*;
import java.io.*;

public class 일이삼더하기_9095 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N= sc.nextInt();
		for (int i=0;i<N;i++) {
			int a = sc.nextInt();
			
			if (a>3) {
				int[] dp = new int[a+1];
				dp[1]=1;
				dp[2]=2;
				dp[3]=4;
				for (int j=4;j<=a;j++) {
					dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
				}
				sb.append(dp[a]+"\n");
			} else {
				int[] dp = new int[4];
				dp[1]=1;
				dp[2]=2;
				dp[3]=4;
				sb.append(dp[a]+"\n");
			}
			
		}
		System.out.println(sb);
	}
}
