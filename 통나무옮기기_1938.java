import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 통나무옮기기_1938 {
	static int N;
	static String[][] map;
	static boolean[][] visited, rotated;
	static boolean flag;
	static final int[] dr = { -2, 2, -1, -1, -1, 0, 0, 1, 1, 1, 0, 0 }; //서있을땐 i가 0=~<10
	static final int[] dc = { 0, 0, -1, 0, 1, -1, 1, -1, 0, 1, -2, 2 }; //누워있을땐 i=2~<12;

	static List<int[]> Blist, Elist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new String[N][N];

		Blist = new ArrayList<>();
		Elist = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken();
				if (map[i][j].equals("B")) {
					Blist.add(new int[] { i, j });
				} else if (map[i][j].equals("E")) {
					Elist.add(new int[] { i, j });
				}
			}
		}

		visited = new boolean[N][N];
		rotated = new boolean[N][N];

		///////////////////////////////////////////
		if (Blist.get(0)[0] == Blist.get(1)[0]) {
			flag = false; // false는 누워있는거
		} else if (Blist.get(0)[1] == Blist.get(1)[1]) {
			flag = true; // true는 서있는거
		}
		//////////////////////////////////////////

	}

	static boolean canRotate(int row, int col, boolean[][] rotated) {
		if (rotated[row][col]) {
			return false;
		}
		for (int i = 2; i < 10; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				return false;
			}
			if (map[nr][nc].equals("1")) {
				return false;
			}
		}
		return true;
	}

	static void bfs() {
		Deque<int[]> queue = new ArrayDeque<>();
		int[] start = new int[3];
		start[0] = Blist.get(1)[0]; // 시작 r 좌표
		start[1] = Blist.get(1)[1]; // 시작 c 좌표
		if (flag) {
			start[2] = 1; // 시작 상태, 서있음
		} else {
			start[2] = 0; // 누워있음
		}

		queue.add(new int[] { start[0], start[1], start[2] });

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			int cs = curr[2];
			
//			if (canRotate(cr, cc, rotated)) {
//				rotated[cr][cc]=true;
//				queue.add(new int[] {cr,cc,(cs+1)%2});
//			}
			
			if (cs == 1) {
				// 현재 서있으면
				// 행동할수 있는건 다같이 왼쪽, 오른쪽, 위, 아래, 회전
				// 각각에 대해 가능한지 보고 움직일것
				for (int i = 0; i < 2; i++) {
					int nr = cr + dr[i];
					int nc = cc + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
						continue;
					}
					if (visited[nr][nc]) {
						continue;
					}
					if (map[nr][nc].equals("1")) {
						continue;
					}
					visited[cr+dr[i]/2][cc+dc[i]/2]=true;
					queue.add(new int[] {cr+dr[i]/2, cc+dc[i]/2, cs});
				}
				for (int i=2;i<5;i++) {
					int nr = cr + dr[i];
					int nc = cc + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
						break;
					}
					if (visited[nr][nc]) {
						break;
					}
					if (map[nr][nc].equals("1")) {
						break;
					}
					visited[nr][nc]=true;
					queue.add(new int[] {nr,nc,cs});
				}
				for (int i=5;i<8;i++) {
					int nr = cr + dr[i];
					int nc = cc + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
						break;
					}
					if (visited[nr][nc]) {
						break;
					}
					if (map[nr][nc].equals("1")) {
						break;
					}
					visited[nr][nc]=true;
					queue.add(new int[] {nr,nc,cs});
				}
			}

		}

	}

}
