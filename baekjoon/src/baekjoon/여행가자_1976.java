package baekjoon;

import java.util.*;
import java.io.*;

public class 여행가자_1976 {
	static int[] arr, parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent= set(N+1);
		
		for (int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1;j<N+1;j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if (temp==1) {
					union(i,j);
				}
			}
		}
		
		boolean flag = true;
		
		st = new StringTokenizer(br.readLine());
		
		int first = find(Integer.parseInt(st.nextToken()));
		for (int i=1;i<M;i++) {
			int next = Integer.parseInt(st.nextToken());
			
			if (first != find(next)) {
				flag=false;
				break;
			}
		}
		
		if (flag) {
			bw.write("YES\n");
		} else {
			bw.write("NO\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	private static int find (int x) {
		if (x== parent[x]) {
			return x;
		}
		return parent[x]=find(parent[x]);
	}
	
	private static void union (int x, int y) {
		x= find(x);
		y= find(y);
		
		if (x!=y) {
			if (x>y) {
				parent[x]=y;
			} else {
				parent[y]=x;
			}
			
		}
		
	}
	
	private static int[] set (int size) {
		int[] arr = new int[size+1];
		for (int i : arr) {
			arr[i]=i;
		}
		return arr;
	}
	
}
