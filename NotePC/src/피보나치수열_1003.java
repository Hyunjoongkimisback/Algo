import java.util.*;

public class 피보나치수열_1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N= sc.nextInt();
		for (int tc=0;tc<N;tc++) {
			int a = sc.nextInt();
			
			if (a>1) {
				int[][] dp = new int[a+1][2];
				dp[0]= new int[] {1,0};
				dp[1]= new int[] {0,1};
				
				for (int i=2;i<a+1;i++) {
					for (int j=0;j<2;j++) {
						dp[i][j]= dp[i-1][j]+dp[i-2][j];
					}
				}
				for (int i=0;i<2;i++) {
					sb.append(dp[a][i]).append(" ");
				}
				sb.append("\n");
			} else {
				if (a==0) {
					sb.append("1 0\n");
				} else {
					sb.append("0 1\n");
				}
			}
		}
		System.out.println(sb);
		
		
	}
}
