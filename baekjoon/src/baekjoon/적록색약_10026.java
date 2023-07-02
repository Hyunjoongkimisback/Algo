package baekjoon;

import java.util.*;
import java.io.*;

public class 적록색약_10026 {
	static int N;
	static final int[] dr = { 1, -1, 0, 0 };
	static final int[] dc = { 0, 0, 1, -1 };
	static String[][] map, RGmap;
	static boolean[][] visited, RGvisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		RGmap = new String[N][N];
		visited = new boolean[N][N];
		RGvisited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j=0;j<N;j++) {
				map[i][j]=str[j];
				if (str[j].equals("R")) {
					RGmap[i][j]="G";
				} else {
					RGmap[i][j]=str[j];
				}
			}
		}
		
		//// 인풋 끝
		
		int normalCnt = 0;
		int RGCnt = 0;
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (!visited[i][j]) {
					bfs(map, visited, i,j);
					normalCnt++;
				}
				if (!RGvisited[i][j]) {
					bfs(RGmap, RGvisited, i,j);
					RGCnt++;
				}
			}
		}
		
		System.out.printf("%d %d", normalCnt, RGCnt);
		
	}
	
	private static void bfs (String[][] arr, boolean[][] visited, int row, int col) {
		Deque<int[]> queue= new ArrayDeque<>();
		queue.add(new int[] {row,col});
		visited[row][col]=true;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for (int i=0;i<4;i++) {
				int nr= curr[0]+dr[i];
				int nc= curr[1]+dc[i];
				
				if (nr>= 0 && nc >=0 && nr< N && nc < N && !visited[nr][nc]) {
					if (arr[nr][nc].equals(arr[curr[0]][curr[1]])){
						visited[nr][nc]=true;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
		
		
	}
	
	
}
