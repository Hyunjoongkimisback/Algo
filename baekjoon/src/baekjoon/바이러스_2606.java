package baekjoon;

import java.util.*;
import java.io.*;

public class 바이러스_2606 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int E = sc.nextInt();
		
		parent = new int[N+1];
		for (int i=0;i<N+1;i++) {
			parent[i]=i;
		}
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		
		for (int i=0;i<N+1;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i=0;i<E;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
			
			union(a,b);
		}
		
		int num = find(1);
		int cnt = 0;
		
		for (int i=2;i<N+1;i++) {
			if (find(i)==num) {
				cnt++;
			}
		}
		
		
		
		System.out.println(cnt);
		
		
	}
	
	private static int find(int x) {
		if (parent[x]==x) {
			return x;
		}
		return parent[x]=find(parent[x]);
	}
	
	private static void union (int i, int j) {
		i = find(i);
		j = find(j);
		
		if (i!=j) {
			if (i>j) {
				parent[i]=j;
			} else {
				parent[j]=i;
			}
		}
	}
	
}
