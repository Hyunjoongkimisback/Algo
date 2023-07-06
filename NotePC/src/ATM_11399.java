import java.util.*;
import java.io.*;

public class ATM_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr =new int[N];
		
		String[] str = br.readLine().split(" ");
		
		for (int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		
		Arrays.sort(arr);
		
		// 1
		int sum= arr[0];
		
		// 1 2 3 3 4
		
		// 1 3 3 3 4
		// sum = 4, arr[1]=3
		for (int i=1;i<N;i++) {
			arr[i]+=arr[i-1];
			sum += arr[i]; 	
		}
		
		System.out.println(sum);
		
	}
}
