package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기2heapSort_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N= Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for (int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		sort(arr);
		
		for (int i=0;i<N;i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
	}
	
	
	
	private static int getParent(int child) { 
		return (child-1)/2;
	}
	
	private static void swap (int[] arr, int i, int j) {
		int temp= arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void sort (int[] arr) {
		sort (arr, arr.length);
	}
	
	private static void sort (int[] arr, int size) {
		if (size<2) {
			return;
		}
		
		int last = size-1;
		int par = getParent(last);
		
		//최대 heap 만들기
		while (par>=0) {
			heapify(arr, par, last);
			par--;
		}
		
		//sort 진행
		int end = size-1;
		while (end>0) {
			swap (arr, 0, end);
			end--;
			heapify(arr, 0, end);
		}
		
	}
	
	private static void heapify (int[] arr, int cur, int last) {
		int left;
		int right;
		int large;
		
		while ((cur<<1)+1<=last) {
			left = (cur<<1)+1;
			right = (cur<<1)+2;
			large = cur;
			
			if (arr[left]> arr[large]) {
				large = left;
			}
			if (right<=last && arr[right] > arr[large]) {
				large = right;
			}
			
			if (large != cur) {
				swap(arr, cur, large);
				cur = large;
			} else {
				return;
			}
			
		}
		
	}
	
}
