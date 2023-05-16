import java.util.*;

public class N과M2_15650 {
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		make(n);
		comb(0, n, r);
	}
	
	static void make(int N) {
		arr = new int [N];
		visited = new boolean[N];
		for (int i=0;i<N;i++) {
			arr[i]=i+1;
		}
	}
	
	static void comb(int idx, int n, int r) {
		if (r==0) {
			for (int i=0;i<n;i++) {
				if (visited[i]) {
					System.out.printf("%d ",arr[i]);	
				}
			}
			System.out.println();
			return;
		}
		
		for (int i=idx;i<n;i++) {
			if (!visited[i]) {
				visited[i]=true;
				comb(i+1, n, r-1);
				visited[i]=false;
			}
		}
	}
	
}
