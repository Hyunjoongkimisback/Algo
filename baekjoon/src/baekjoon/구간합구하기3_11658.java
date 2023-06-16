package baekjoon;

import java.util.*;
import java.io.*;

public class 구간합구하기3_11658 {
	static long[][] arr, tree;
	static int n;

	static void update(int y, int x, long diff) {
		int r=y;
		while (r <= n) {
			int c=x;
			while (c <= n) {
				tree[r][c] += diff;
				c += (c & -c);
			}
			r += (r & -r);
		}
	}

	static long sum(int y, int x) {
		long res = 0;
		int r=y;
		while (r > 0) {
			int c=x;
			while (c > 0) {
				res += tree[r][c];
				c -= (c & -c);
			}
			r -= (r & -r);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new long[n + 1][n + 1];
		tree = new long[n + 1][n + 1];
		for (int y = 1; y <= n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				update(y, x, arr[y][x]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			if (w == 0) {
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				update(y, x, c - arr[y][x]);
				arr[y][x] = c;
			} else {
				int y1 = Integer.parseInt(st.nextToken());
				int x1 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				long res = sum(y2, x2) - sum(y2, x1 - 1) - sum(y1 - 1, x2) + sum(y1 - 1, x1 - 1);
				sb.append(res + "\n");
			}
		}
		System.out.println(sb);
	}
}