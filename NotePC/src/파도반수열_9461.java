
import java.util.*;
import java.io.*;

public class 파도반수열_9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {

			int N = Integer.parseInt(br.readLine());

			Long[] P = new Long[101];

			P[0] = (long) 0;
			P[1] = (long) 1;
			P[2] = (long) 1;
			P[3] = (long) 1;
			P[4] = (long) 2;
			P[5] = (long) 2;

			if (N > 5) {
				for (int i = 6; i < N+1; i++) {
					P[i] = P[i - 1] + P[i - 5];
				}
			} 
			
			
			sb.append(P[N] + "\n");

		}
		System.out.println(sb);

	}
}
