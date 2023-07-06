import java.util.*;
import java.io.*;

public class 피자굽기_1756 {
	static int[] arr;
	static int dep, min;
	static int D, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] DN = br.readLine().split(" ");
		D = Integer.parseInt(DN[0]);
		N = Integer.parseInt(DN[1]);
		
		String[] BAKE = br.readLine().split(" ");
		arr = new int[D];
		
		for (int i=0;i<D;i++) {
			arr[i]=Integer.parseInt(BAKE[i]);
		}
		
		sorting();
		
		min= Integer.MAX_VALUE;
		dep= D-1;
				
		String[] PIZZA = br.readLine().split(" ");
		for (int i=0;i<N;i++) {
			int a=Integer.parseInt(PIZZA[i]);
			
			binary(a, 0, dep);
			
		}
		
		System.out.println(++min);
	}
	
	private static void sorting () {
		for (int i=1;i<D;i++) {
			if (arr[i]>arr[i-1]) {
				arr[i]=arr[i-1];
			}
		}
	}
	private static void binary (int val, int left, int right) {
		int result=-1;
		
		while (left<=right) {
			int mid = (left+right)/2;
			
			if (arr[mid] >= val) {
				result=mid;
				left=mid+1;
			} else {
				right=mid-1;
			}
			
		}
		
		min = Math.min(min,  result);
		dep=result-1;
		
	}
	
}

