import java.util.*;
import java.io.*;

public class 정수삼각형_1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		map[0][0] = Integer.parseInt(br.readLine());
		int max = 0;
		
		for (int i=1;i<N;i++) {
			String[] str = br.readLine().split(" ");
			
			for (int j=0;j<i+1;j++) {
				map[i][j]= Integer.parseInt(str[j]);
				
				if (j==0) {
					map[i][j]+=map[i-1][0];
				} else if (j==i) {
					map[i][j]+=map[i-1][j-1];
				} else {
					map[i][j]+=Math.max(map[i-1][j-1], map[i-1][j]);
				}
				max= Math.max(max, map[i][j]);
			}
		}
		if (N==1) {
			System.out.println(map[0][0]);
		} else {
			System.out.println(max);
			
		}
	}
}
