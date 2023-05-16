package baekjoon;

import java.util.*;

public class 아기상어_16236 {
	static int[][] map;
	static int X, Y;
	static int N, totaldist, size, cnt;
	static final int[] dr = { -1, 0, 0, 1 };
	static final int[] dc = { 0, -1, 1, 0 };
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					X = i;
					Y = j;
					map[i][j] = 0;
				}
			}
		}

		totaldist = 0;
		size = 2;
		cnt = 0;
		flag = true;

		while (flag) {
			bfs(X, Y);
		}
		System.out.println(totaldist);
	}

	static void bfs(int row, int col) {
		boolean[][] visited = new boolean[N][N];

		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] != o2[2] ? Integer.compare(o1[2], o2[2])
				: (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));
		queue.add(new int[] { row, col, 0 });
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if (map[curr[0]][curr[1]]<size&&map[curr[0]][curr[1]]!=0) {
				cnt++;
				map[curr[0]][curr[1]] = 0;
				if (cnt == size) {
					size++;
					cnt = 0;
				}
				X = curr[0];
				Y = curr[1];
				totaldist += curr[2];
				queue.clear();
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}
				if (visited[nr][nc]) {
					continue;
				}
				if (map[nr][nc] > size) {
					continue;
				}
				if (map[nr][nc] <= size) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc, curr[2] + 1 });
				} 
			}
		}

		flag = false;
		return;
	}

}
