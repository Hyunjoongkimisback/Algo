package baekjoon;

import java.util.*;

public class ����䰨���ϴ¼��� {
	static int[] arr, dp;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		N =sc.nextInt();
		arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i]= sc.nextInt();
		}
		
		dp = new int[N];
		Arrays.fill(dp, 9999);
		int LDS =0; 
		
		for (int i=0;i<N;i++) {
			int idx = binarySearch(arr[i], 0, LDS, LDS+1);
			
			// idx==-1 �̶�� ���� dp���� �� �ڸ��� ��ã�Ҵٴ°�
			// ��ã�Ҵٴ� ���� dp�� �� ���� ��� �꺸�� ũ��.
			// �׷� LDS ++ ���ְ� dp�� �־�����
			if (idx==-1) {
				dp[LDS++]=arr[i];
			} else {
				//�ƴ϶�� res���� ��ü������
				dp[idx]=arr[i];
			}
		}
		
		System.out.println(LDS);
		
	}
	
	static int binarySearch(int num, int start, int end, int size) {
		int res = 0;
		
		while (start<=end) {
			int mid = (start+end)/2;
			
			//dp�� ������������ �Ǿ���������
			//���࿡ num�� dp�� �߾Ӱ����� ũ�ų� ������?
			//�ϴ� �ְ� �պκ��� �� Ž���غ��ߵ�
			if (num>=dp[mid]) {
				//��ġ ����صд�
				res = mid;
				end=mid-1;
			} else {
				//�ƴϸ� num�� dp�߾Ӱ����� �۴�?
				//�޺κ� Ž��
				start=mid+1;
			}
			
		}

		// ���࿡ �� �ڸ��� ������
		// dp�� ��� ������ num���� �۴ٴ°�
		// �׷� �־�����
		if (start == size) {
			return -1;
		} else {
			return res;
		}
		
	}
	
}
