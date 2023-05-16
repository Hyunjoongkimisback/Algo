package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 가장긴증가하는부분수열4_14002 {
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}   
		
		dp= new int[N+1];
		int LIS=0;
		
		for (int i=1;i<=N;i++) {
			for (int j=0;j<=i;j++) {
				if (arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
					LIS = Math.max(dp[i], LIS);
				}
			}
		}
		
		System.out.println(LIS);
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i=N;i>0;i--) {
			if (dp[i]==LIS) {
				stack.add(arr[i]);
				LIS--;
			}
			if (LIS==0) break;
		}
		
		while (!stack.isEmpty()) {
			System.out.printf("%d ",stack.pop());
		}
		
	}
	
}
