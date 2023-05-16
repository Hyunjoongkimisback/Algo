package baekjoon;

import java.util.*;

public class 가장긴감소하는수열 {
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
			
			// idx==-1 이라는 것은 dp에서 들어갈 자리를 못찾았다는것
			// 못찾았다는 것은 dp의 수 들이 모두 얘보다 크다.
			// 그럼 LDS ++ 해주고 dp에 넣어주자
			if (idx==-1) {
				dp[LDS++]=arr[i];
			} else {
				//아니라면 res값과 교체해주자
				dp[idx]=arr[i];
			}
		}
		
		System.out.println(LDS);
		
	}
	
	static int binarySearch(int num, int start, int end, int size) {
		int res = 0;
		
		while (start<=end) {
			int mid = (start+end)/2;
			
			//dp는 내림차순으로 되어있을것임
			//만약에 num가 dp의 중앙값보다 크거나 같으면?
			//일단 넣고 앞부분을 더 탐색해봐야됨
			if (num>=dp[mid]) {
				//위치 기억해둔다
				res = mid;
				end=mid-1;
			} else {
				//아니면 num가 dp중앙값보다 작다?
				//뒷부분 탐색
				start=mid+1;
			}
			
		}

		// 만약에 들어갈 자리가 없으면
		// dp의 모든 값들이 num보다 작다는것
		// 그럼 넣어주자
		if (start == size) {
			return -1;
		} else {
			return res;
		}
		
	}
	
}
