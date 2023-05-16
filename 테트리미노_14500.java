package baekjoon;

import java.util.*;

public class 테트리미노_14500 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j]=true;
				dfs(i,j,map[i][j],1);
				visited[i][j]=false;
			}
		}
		
		System.out.println(max);
	}
	
	
	static void dfs (int r, int c, int s, int cnt) {
		if (cnt==4) {
			max=Math.max(max, s);
			return;
		}
		
		for (int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr<0||nc<0||nr>=N||nc>=M) {
				continue;
			}
			
			if (!visited[nr][nc]) {
				if (cnt==2) {
					visited[nr][nc]=true;
					dfs(r,c,s+map[nr][nc],cnt+1);
					visited[nr][nc]=false;
				}
				visited[nr][nc]=true;
				dfs(nr,nc,s+map[nr][nc],cnt+1);
				visited[nr][nc]=false;
			}
			
			
		}
		
	}
}
