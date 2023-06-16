package baekjoon;

import java.util.*;

public class N°úM10_15664 {
	static HashSet<String> result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		result = new HashSet<>();
		int[] arr = new int[N];
		int[] temp = new int[M];
		boolean[] visited = new boolean[N];
		
		for (int i=0;i<N;i++) {
			arr[i]= sc.nextInt();
		}
		Arrays.sort(arr);
		
		perm(arr,temp,visited,0,M, 0);
				
		System.out.println(sb);
		
	}

	static void perm(int[] arr, int[] temp, boolean[] visited, int idx, int M, int start) {
		if (idx == M) {
			for (int i=0;i<M;i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int before=-1;
		for (int i=0;i<arr.length;i++) {
			if (visited[i]) {
				continue;
			}
			if (idx>=1 && temp[idx-1]>arr[i]) {
				continue;
			}
			
			if (before == arr[i]) {
				continue;
			}
			visited[i]=true;
			before=arr[i];
			temp[idx]=arr[i];
			perm(arr,temp,visited,idx+1,M, i);
			visited[i]=false;
		}
			
	}

}
