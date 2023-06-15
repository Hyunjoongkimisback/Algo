package baekjoon;

import java.util.*;

public class ��������_10972 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N= sc.nextInt();
		int[] arr = new int[N];
		
		for (int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		if (isNext(arr)) {
			for (int i=0;i<N;i++) {
				System.out.print(arr[i]+" ");
			}
		} else {
			System.out.println(-1);
		}
		
	}
	
	
	private static boolean isNext(int[] arr) {
		int idx1 = arr.length-1;
		
		if (idx1==0) return false;
		
		//�������� �������� idx1 ã��
		while (arr[idx1-1]>arr[idx1]) {
			idx1--;
			if (idx1==0) return false;
		}
		
		//�̹��� �ٲ����� ã��
		int idx2 = arr.length-1;
		
		while(arr[idx1-1]>arr[idx2]) {
			idx2--;
		}
		//idx1-1 �κ��̶� idx2�� �ٲ��ְ�
		swap (arr, idx1-1, idx2);
		
		//idx1���� ������ reverse�ϼ�
		idx2=arr.length-1;
		while (idx1<idx2) {
			swap(arr,idx1,idx2);
			idx1++;
			idx2--;
		}
		return true;
	}
	
	private static void swap (int[] arr, int i, int j) { 
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
}
