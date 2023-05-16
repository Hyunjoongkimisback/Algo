package baekjoon;

import java.util.*;

public class 가장긴바이토닉부분수열_11054 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N= sc.nextInt();
		int[] arr= new int[N+2];
		int[] dp1 = new int[N+2];
		int[] dp2 = new int[N+2];
		
		for (int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		
		int LBS=0;
		
		for (int i=1;i<=N;i++) {
			for (int j=0;j<i;j++) {
				if (arr[i]>arr[j]) {
					dp1[i]=Math.max(dp1[i], dp1[j]+1);
				}
			}
		}	
		for (int i=N;i>=1;i--) {
			for (int j=N+1;j>=i;j--) {
				if (arr[i]>arr[j]) {
					dp2[i]=Math.max(dp2[i], dp2[j]+1);
				}
			}
		}
		for (int i=1;i<=N;i++) {
			LBS = Math.max(dp1[i]+dp2[i],LBS);
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(dp1));
//		System.out.println(Arrays.toString(dp2));
		System.out.println(LBS-1);
		
		
	}
}
