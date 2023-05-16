import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class N과M4_15652 {
	static int n, r;
	static int[] arr, result;
	static boolean[] visited;
	static StringBuilder sb= new StringBuilder();

	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		
		make(n);
		perm(0, n, r);
		System.out.println(sb);
	}
	
	static void make(int N) {
		arr = new int [N];
		result= new int[r];
		visited = new boolean[N];
		for (int i=0;i<N;i++) {
			arr[i]=i+1;
		}
	}
	static void print (int r) throws IOException {

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
			result[idx]=arr[i];
			perm(idx + 1, n, r);
		}
		
	}
	
}
