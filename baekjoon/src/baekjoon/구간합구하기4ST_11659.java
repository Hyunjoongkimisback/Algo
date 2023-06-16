package baekjoon;

import java.util.*;
import java.io.*;

public class 구간합구하기4ST_11659 {

	static int N;
	static int[] arr, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new int[1 << h + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		build(1, 1, N);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = query(1, 1, N, a, b);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static int build(int node, int start, int end) {
		// 리프노드는 집어넣어라
		if (start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = build(node * 2, start, mid) + build(node * 2 + 1, mid+1, end);
	}

	private static int query (int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		return query(node*2, start, mid, left, right)+query(node*2+1, mid+1, end, left, right);
	}
	
	private static void update (int node, int start, int end, int idx, int value) {
		// 리프노드면 배열값 업데이트
		if (start==end) {
			tree[node]=value;
			return;
		}
		
		int mid = (start+end)/2;
		
		if (start <= idx && idx <= mid) {
			update(2*node,start, mid, idx, value);
		} else {
			update(2*node+1, mid+1, end, idx, value);
		}
		tree[node]=tree[2*node]+tree[2*node+1];
	}
	
}
