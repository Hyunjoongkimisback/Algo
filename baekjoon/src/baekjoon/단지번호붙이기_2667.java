package baekjoon;

import java.util.*;
import java.io.*;

public class 단지번호붙이기_2667 {
	static int N;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					q.add(bfs(map, visited, i, j));
				}
			}
		}
		if (q.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(q.size());
			while (!q.isEmpty()) {
				System.out.println(q.poll());
			}
		}
	}

	private static int bfs(int[][] arr, boolean[][] visited, int row, int col) {
		int cnt = 0;
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { row, col });
		visited[row][col] = true;
		cnt++;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}
				if (!visited[nr][nc] && arr[nr][nc] == 1) {
					visited[nr][nc] = true;
					cnt++;
					queue.add(new int[] { nr, nc });
				}
			}
		}

		return cnt;
	}

}
