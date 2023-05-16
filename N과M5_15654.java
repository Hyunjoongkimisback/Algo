import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class N과M5_15654 {
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
		
		perm(0, n, r);
		System.out.println(sb);
	}
	
	static void perm(int idx, int n, int r) throws IOException {
		if (idx==r) {
			for (int i=0;i<r;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=0;i<n;i++) {
			if (!visited[i]) {
				visited[i]=true;
				result[idx]=arr[i];
				perm(idx + 1, n, r);
				visited[i]=false;
			}
		}
		
	}
	
}
