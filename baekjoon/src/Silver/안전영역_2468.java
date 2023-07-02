package Silver;

import java.util.*;
import java.io.*;

public class 안전영역_2468 {
	static int maxCnt = 0;
	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		int groundMax = 0;
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] > groundMax) {
					groundMax = map[i][j];
				}
			}
		}
		/// 인풋 끝

		int height = 0;

		while (height <= 100) {
			int cnt = 0;
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > height && !visited[i][j]) {
						bfs(visited, map, i, j, height, N);
						cnt++;
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
			height++;
		}
		System.out.println(maxCnt);
	}

	private static void bfs(boolean[][] visited, int[][] arr, int row, int col, int height, int N) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {row, col});
		visited[row][col]=true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for (int i=0;i<4;i++) {
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if (nr>=0 && nc >=0 && nr< N && nc < N && !visited[nr][nc] && arr[nr][nc]>height) {
					visited[nr][nc]=true;
					queue.add(new int[] {nr,nc});
				}
			}
		}
	}
}
