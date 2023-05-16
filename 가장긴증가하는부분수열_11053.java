package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장긴증가하는부분수열_11053 {
	static int[] dp, indexarr;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}   
		
		dp= new int[N];
		indexarr = new int[N];
		
		Arrays.fill(dp, Integer.MIN_VALUE);

		int LIS=0;
		
		for (int i=0;i<N;i++) {
			int idx= binarySearch(arr[i], 0, LIS, LIS+1);
			if (idx==-1) {
				indexarr[i]=LIS;
				dp[LIS++]=arr[i];
			} else {
				indexarr[i]=idx;
				dp[idx]=arr[i];
			}
		}
		System.out.println(LIS);
		
		Stack<Integer> stack = new Stack<>();
		for (int i=N-1;i>=0;i--) {
			if (indexarr[i]==LIS-1) {
				stack.add(arr[i]);
				LIS--;
			}
			if (LIS==-1) break;
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		System.out.println(sb);
		
		
	}
	
	static int binarySearch(int num, int start, int end, int size) {
		int res = 0;
		while (start<=end) {
			int mid = (start+end)/2;
			if (num <= dp[mid]) {
				res=mid;
				end=mid-1;
			} else {
				start=mid+1;
			}
		}	
		if (start==size) {
			return -1;
		}
		else {
			return res;
		}
	}
}

/* 
7
10 30 5 7 50 9 15
 */

