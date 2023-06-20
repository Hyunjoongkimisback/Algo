package baekjoon;

import java.util.*;
import java.io.*;

public class 나무자르기_2805 {

	static int M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		long start = 0;
		long end = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > end) {
				end = arr[i];
			}
		}

		long result = binarySearch(start, end)-1;
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}

	private static long binarySearch(long left, long right) {
		while (left<right) {
			long mid = left + (right - left) / 2;
			if (check(mid)) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private static boolean check(long height) {
		long sum= 0;
		
		for (int i=0;i<arr.length;i++) {
			if (arr[i]>=height) {
				sum+=arr[i]-height;
			}
		}
		
		if (sum>=M) {
			return true;
		}
		return false;
	}

}
