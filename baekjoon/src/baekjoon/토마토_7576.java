package baekjoon;

import java.util.*;
import java.io.*;

public class ≈‰∏∂≈‰_7576  {
	static int[][] map;
	static int n, m;
	static Deque<Node> queue;
	static final int[] dr = {1, -1, 0, 0};
	static final int[] dc = {0, 0, 1, -1};
	
	public static class Node {
		int r, c;
		public Node(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		queue = new ArrayDeque<>();
		
		for (int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if (map[i][j]==1) {
					queue.add(new Node(i,j));
				}
			}
		}
		
		bfs(queue);
		
		int max = 0;
		
		if (check()) {
			for (int i=0;i<n;i++) {
				for (int j=0;j<m;j++) {
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			System.out.println(max-1);
		} else {
			System.out.println(-1);
		}
		
	}
	
	private static void bfs (Deque<Node> queue) {
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for (int i=0;i<4;i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr>= n || nc >= m) {
					continue;
				}
				
				if (map[nr][nc]==0) {
					map[nr][nc]= map[curr.r][curr.c]+1;
					queue.add(new Node(nr,nc));
				}
			}
		}
	}
	
	private static boolean check () {
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (map[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
}
