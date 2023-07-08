import java.util.*;
import java.io.*;

public class 타일링_11727 {
	static Long[] dp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		dp = new Long[1001];
		dp[0] = (long) 0;
		dp[1] = (long) 1;
		dp[2] = (long) 3;

		if (N > 2) {
			System.out.println(recur(N));
		} else {
			System.out.println(dp[N]);
		}
	}

	static Long recur(int N) {
		if (dp[N] == null) {
			dp[N] = recur(N - 2) * 2 + recur(N - 1);
		}
		return dp[N]%10007;
	}

}