package baekjoon;

import java.util.*;

public class HeapSort {

	private static int getParent(int child) {
		return (child-1)/2;
	}
	
	private static void swap (int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void sort(int[] arr) {
		sort (arr, arr.length);
	}
	
	private static void sort (int[] arr, int size) {
		if (size<2) {
			return;
		}
		
		int last = size-1;
		int par= getParent(last);
		
		// 최대힙으로 만들기
		while (par>=0) {
			heapify(arr, par, last);
			par--;
		}
		
		//sort 진행
		int end = size-1;
		while (end>0) {
			swap(arr, 0, end);
			end--;
			heapify(arr,0,end);
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
			
			if (arr[left] > arr[large]) {
				large = left;
			}
			if (right <= last && arr[right] > arr[large]) {
				large = right;
			}
			if (large != cur) {
				swap(arr, cur, large);
				cur=large;
			} else {
				return;
			}
		}
	}
	
}
