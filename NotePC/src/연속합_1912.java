import java.util.*;
import java.io.*;

public class 연속합_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		arr[0]=Integer.parseInt(str[0]);
		dp[0]= arr[0];

		int max = dp[0];
		
		for (int i=1;i<N;i++) {
			arr[i]=Integer.parseInt(str[i]);
			
			dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
			
			max = Math.max(max, dp[i]);
			
			if (dp[i]<0) {
				dp[i]=0;
			}
		}
		if (N==1) {
			System.out.println(arr[0]);
		} else {
			System.out.println(max);
		}
		
		
	}
}
