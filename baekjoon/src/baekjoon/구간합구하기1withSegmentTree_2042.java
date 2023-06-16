package baekjoon;

import java.io.*;
import java.util.*;

public class 구간합구하기1withSegmentTree_2042 {

	static Long N;
	static Long[] arr, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// Segment Tree 이용할거임

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new Long[N+1];
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		tree = new Long[1<<h+1];
		
		for (int i=1;i<N+1;i++) {
			arr[i]=Long.parseLong(br.readLine());
		}
		build (1, 1, N);
		
		for (int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			Long a = Long.parseLong(st.nextToken());
			Long b = Long.parseLong(st.nextToken());
			Long c = Long.parseLong(st.nextToken());
			
			if (a==1) {
				update(1,1,N,b,c);
			} else if (a==2) {
				System.out.println(query(1, 1, N, b, c));
			}
			
		}
		
		
	}
	
	private static Long build (int node, int start, int end) {
		if (start == end) {
			return tree[node]=arr[start];
		}
		int mid= (start+end)/2;
		return tree[node] = build(node*2,start,mid)+build(node*2+1,mid+1,end);
	}
	
	private static Long query (int node, int start, int end, long left, long right) {
		if (right < start || end < left) {
			return (long) 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start+end)/2;
		return query(node*2, start, mid, left, right)+query(node*2+1, mid+1, end, left,right); 
	}
	
	private static void update (int node, int start, int end, long idx, long val) {
		if (start==end) {
			tree[node]=val;
			return;
		}
		int mid = (start+end)/2;
		if (start <= idx && idx <= mid) {
			update(node*2, start, mid, idx, val);
		} else {
			update(node*2+1, mid+1, end, idx, val);
		}
		tree[node]= tree[node*2]+tree[node*2+1];
	}
	
	
}
