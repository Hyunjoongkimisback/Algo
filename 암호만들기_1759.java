import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 암호만들기_1759 {
	static char[] arr, result;
	static boolean[] visited;
	
	static final char[] moum = {'a', 'e', 'i', 'o', 'u'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		arr= new char[n];
		result = new char[r];
		visited= new boolean[n];
		String str = br.readLine();
		
		for (int i=0;i<n;i++) {
			arr[i]=str.charAt(2*i);
		}
		
		comb(0, n, r);
	}
	
	static void comb (int idx, int n, int r) {
		if (r==0) {
			int index=0;
			Arrays.sort(arr);
			for (int i=0;i<n;i++) {
				if (visited[i]) {
					result[index++]=arr[i];
				}
			}
			if (check(result)) {
				System.out.println(result);	
			}
			return;
		}
		
		for (int i=idx;i<n;i++) {
			visited[i]=true;
			comb(i+1, n, r-1);
			visited[i]=false;
		}
		
	}
	
	static boolean check (char[] arr) {
		int cnt = 0;
		int len = arr.length;
		for (int i=0;i<len;i++) {
			for (int j=0;j<5;j++) {
				if (moum[j]==arr[i]) {
					cnt++;
				}
			}
		}
		if (cnt>=1&&cnt<=len-2) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
