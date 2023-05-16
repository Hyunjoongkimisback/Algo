import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class N과M6_15655 {
	static int n, r;
	static int[] arr, result;
	static boolean[] visited;
	static StringBuilder sb= new StringBuilder();

	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		
		arr = new int [n];
		result= new int[r];
		visited = new boolean[n];
		for (int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		comb(0, n, r);
		System.out.println(sb);
	}
	
	static void comb(int idx, int n, int r) throws IOException {
		if (r==0) {
			for (int i=0;i<n;i++) {
				if (visited[i])
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=idx;i<n;i++) {
			if (!visited[i]) {
				visited[i]=true;
				comb(i + 1, n, r-1);
				visited[i]=false;
			}
		}
		
	}
	
}
