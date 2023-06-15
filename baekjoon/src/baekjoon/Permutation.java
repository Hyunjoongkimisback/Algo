package baekjoon;

import java.util.*;

public class Permutation {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N= sc.nextInt();
		int[] arr= new int[N];
		int[] result=new int[N];
		boolean[] visited = new boolean[N];
		
		for (int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		perm(arr,result,visited,0);
		
	}
	
	private static void perm(int[] arr, int[] result, boolean[] visited, int idx) {
		if (idx==arr.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i=0;i<arr.length;i++) {
			if (visited[i]) {
				continue;
			}
			result[idx]=arr[i];
			visited[i]=true;
			perm(arr,result,visited,idx+1);
			visited[i]=false;
		}
	}
	
}
