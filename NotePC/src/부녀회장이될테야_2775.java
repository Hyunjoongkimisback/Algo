import java.util.*;

public class 부녀회장이될테야_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for (int tc=0;tc<N;tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] arr = new int[k+1][n+1];
			
			for (int j=0;j<n+1;j++) {
				arr[0][j]=j;
			}
			
			for (int i=1;i<k+1;i++) {
				
				for (int j=0;j<n+1;j++) {
					for (int m=1;m<=j;m++) {
						arr[i][j]+=arr[i-1][m];
					}
				}
			}
			sb.append(arr[k][n]).append("\n");
		}
		System.out.println(sb);
	}
}
