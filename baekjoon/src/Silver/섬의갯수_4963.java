package Silver;

import java.util.*;
import java.io.*;

public class ¼¶ÀÇ°¹¼ö_4963 {

	static final int[] dr = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static final int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String[] NM = br.readLine().split(" ");
			int M = Integer.parseInt(NM[0]);
			int N = Integer.parseInt(NM[1]);

			if (N == 0 && M == 0) {
				break;
			}

			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					map[i][j]=Integer.parseInt(str[j]);
				}
			}
			///// ÀÎÇ² ³¡
			
			int islandCnt =0;
			
			for (int i=0;i<N;i++) {
				for (int j=0;j<M;j++) {
					if (map[i][j]==1 && !visited[i][j]) {
						bfs(map, visited, i, j, N, M);
						islandCnt++;
					}
				}
			}
			sb.append(islandCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs (int[][] map, boolean[][] visited, int row, int col, int N, int M) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {row,col});
		visited[row][col]=true;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for (int i=0;i<8;i++) {
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if (nr >=0 && nc >=0 && nr< N && nc < M && !visited[nr][nc] && map[nr][nc]==1) {
					visited[nr][nc]=true;
					queue.add(new int[] {nr,nc});
				}
				
			}
			
		}
	}
}
