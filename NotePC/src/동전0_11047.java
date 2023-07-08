import java.util.*;
import java.io.*;

public class 동전0_11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int N = Integer.parseInt(nk[0]);
		int K = Integer.parseInt(nk[1]);
		
		int[] arr = new int[N];
		int cnt = 0;
		
		for (int i=0;i<N;i++) {
			String a = br.readLine(); 
			arr[N-1-i]=Integer.parseInt(a);
		}
		
		int idx= 0;
		
		while (K>0) {
			if (K/arr[idx]>0) {
				cnt+=K/arr[idx];
				K=K%arr[idx];
			}
			idx++;
		}
		
		System.out.println(cnt);
		
	}
}
