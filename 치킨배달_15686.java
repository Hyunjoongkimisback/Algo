import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치킨배달_15686 {
	static final int[] dr = { 1, -1, 0, 0 };
	static final int[] dc = { 0, 0, 1, -1 };
	static int N, M, min;
	static int size1, size2;
	static int[][] map;

	static class XY {
		int row, col, dist;

		public XY(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<XY> list1 = new ArrayList<>();
		List<XY> list2 = new ArrayList<>();

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					list1.add(new XY(i, j));
				} else if (map[i][j] == 2) {
					list2.add(new XY(i, j));
				}
			}
		}

		size1 = list1.size();
		size2 = list2.size();

		min = Integer.MAX_VALUE;

		boolean[] visited = new boolean[size2];
		comb(0, visited, 0, size2, M, list1, list2);

		System.out.println(min);
	}

//	static int bfs(boolean[][] visited, int[][] copymap, int r, int c) {
//
//		visited = new boolean[N][N];
//		Deque<XY> queue = new ArrayDeque<>();
//		queue.add(new XY(r, c));
//		visited[r][c] = true;
//
//		while (!queue.isEmpty()) {
//			XY curr = queue.poll();
//
//			for (int i = 0; i < 4; i++) {
//				int nr = curr.row + dr[i];
//				int nc = curr.col + dc[i];
//
//				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
//					continue;
//				}
//				if (copymap[nr][nc] == 2) {
//					queue.clear();
//					return Math.abs(nr - r) + Math.abs(nc - c);
//				}
//				if (visited[nr][nc]) {
//					continue;
//				}
//				if (copymap[nr][nc] != 2) {
//					visited[nr][nc] = true;
//					queue.add(new XY(nr, nc));
//				}
//			}
//		}
//		return -1;
//	}

	static void comb(int depth, boolean[] visited, int idx, int n, int r, List<XY> list1, List<XY> list2) {
		if (r == 0) {
			int totaldist = 0;
			
			for (int i = 0; i <list1.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for (int j=0;j<list2.size();j++) {
					if (visited[j]) {
						int dist = Math.abs(list1.get(i).row-list2.get(j).row)
								+ Math.abs(list1.get(i).col-list2.get(j).col);
						temp=Math.min(temp, dist);
					}
				}
				totaldist+=temp;
			}
			min = Math.min(min, totaldist);
			return;
		}
		if (depth >= M) {
			return;
		}

		for (int i = idx; i < n; i++) {
			visited[i] = true;
			comb(depth + 1, visited, i + 1, n, r - 1, list1, list2);
			visited[i] = false;
		}
	}

}
