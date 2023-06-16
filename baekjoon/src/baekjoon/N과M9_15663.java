package baekjoon;

import java.util.*;

public class N°úM9_15663 {
	static StringBuilder sb;
	static LinkedHashSet<String> result;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		int[] perm = new int[M];
		boolean[] visited= new boolean[N];
		result = new LinkedHashSet<>();
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
//		Arrays.stream(arr).forEach(System.out::println);
		
		perm(arr, perm, visited, 0, M);
		
		result.forEach(System.out::println);
		
	}
	
	
	private static void perm(int[] arr, int[] perm, boolean[] visited, int idx, int M) {
		if (idx==M) {
			sb = new StringBuilder();
			
			for (int p : perm) {
				sb.append(p).append(" ");
			}
			result.add(sb.toString());
			return;
		}
		
		for (int i=0;i<arr.length;i++) {
			if (visited[i]) {
				continue;
			}
			visited[i]=true;
			perm[idx]=arr[i];
			perm(arr,perm,visited,idx+1, M);
			visited[i]=false;
		}
		
	}
	
}
