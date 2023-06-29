package baekjoon;

import java.util.*;
import java.io.*;

public class ≈‰∏∂≈‰2_7569 {
	static int[][][] map;
	static int n, m, h;
	static Deque<Node> queue;
	static final int[] dr = { 1, -1, 0, 0, 0, 0 };
	static final int[] dc = { 0, 0, 1, -1, 0, 0 };
	static final int[] dh = { 0, 0, 0, 0, 1, -1 };

	public static class Node {
		int r, c, h;

		public Node(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][n][m];
		queue = new ArrayDeque<>();
		
		for (int k=0;k<h;k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if (map[k][i][j] == 1) {
						queue.add(new Node(k, i, j));
					}
				}
			}
		}

//		for (int k=0;k<h;k++) {
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[k][i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}

		bfs(queue);

		int max = 0;

		if (check()) {
			for (int k=0;k<h;k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (max < map[k][i][j]) {
							max = map[k][i][j];
						}
					}
				}
			}
			System.out.println(max - 1);
		} else {
			System.out.println(-1);
		}

	}

	private static void bfs(Deque<Node> queue) {
		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nh = curr.h + dh[i];
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nc < 0 || nh<0 || nh >= h || nr >= n || nc >= m ) {
					continue;
				}

				if (map[nh][nr][nc] == 0) {
					map[nh][nr][nc] = map[curr.h][curr.r][curr.c] + 1;
					queue.add(new Node(nh, nr, nc));
				}
			}
		}
	}

	private static boolean check() {
		for (int k=0;k<h;k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[k][i][j] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
