package baekjoon;

import java.io.*;
import java.util.*;

public class 구간합구하기2Lasy_10999 {
//
//	static Long N;
//	static Long[] arr, tree, lazy;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		// Range Update lazy propagate 사용
//
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//
//		arr = new Long[N + 1];
//		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
//		tree = new Long[1 << h + 1];
//		lazy = new Long[1 << h + 1];
//
//		for (int i = 1; i < N + 1; i++) {
//			arr[i] = Long.parseLong(br.readLine());
//		}
//		build(1, 1, N);
//
//		for (int i = 0; i < M + K; i++) {
//			st = new StringTokenizer(br.readLine());
//			Long a = Long.parseLong(st.nextToken());
//			if (a == 1) {
//				Long b = Long.parseLong(st.nextToken());
//				Long c = Long.parseLong(st.nextToken());
//				Long diff = Long.parseLong(st.nextToken());
//				update(1, 1, N, b, c, diff);
//			} else if (a == 2) {
//				Long b = Long.parseLong(st.nextToken());
//				Long c = Long.parseLong(st.nextToken());
//				bw.write(query(1, 1, N, b, c)+"\n");
//			}
//		}
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//
//	private static Long build(int node, int start, int end) {
//		if (start == end) {
//			return tree[node] = arr[start];
//		}
//		int mid = (start + end) / 2;
//		return tree[node] = build(node * 2, start, mid) + build(node * 2 + 1, mid + 1, end);
//
//	}
//
//	private static Long query(int node, int start, int end, long left, long right) {
//		propagate(node, start, end);
//		if (right < start || end < left) {
//			return (long) 0;
//		}
//		if (left <= start && end <= right) {
//			return tree[node];
//		}
//		int mid = (start + end) / 2;
//		return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
//	}
//
//	private static void update(int node, int start, int end, long left, long right, long diff) {
//		propagate(node, start, end); // 갱신할 값 있으면 업데이트
//		if (right < start || end < left) {
//			return;
//		}
//
//		if (left <= start && end <= right) {
//			lazy[node] += (end-start+1)* diff;
//			if (start!=end) {
//				lazy[node*2]+=diff;
//				lazy[node*2+1]+=diff;
//			}
//			return;
//		}
//		int mid = (start + end) / 2;
//		update(node * 2, start, mid, left, right, diff);
//		update(node * 2 + 1, mid + 1, end, left, right, diff);
//		
//		//update 끝나고나서 부모 노드에 반영할거
//		tree[node]= tree[node*2]+tree[node*2+1];
//		
//	}
//
//	private static void propagate(int node, int start, int end) {
//		if (lazy[node] != 0) { // 업데이트 할것이 남아있으면
//			if (start != end) {
//				lazy[node * 2] += lazy[node];
//				lazy[node * 2 + 1] += lazy[node];
//			}
//			tree[node] += (end - start + 1) * lazy[node]; // 업데이트해라
//			lazy[node] = (long) 0; // 다시 초기화
//		}
	}

}
