package baekjoon;

import java.util.*;

public class 로봇청소기_14503 {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static int N, M, cnt;
	static boolean[][] visited;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		int[] input = new int[3];
		for (int i = 0; i < 3; i++) {
			input[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		cnt = 1;

		dfs(input[0], input[1], input[2]);


		System.out.println(cnt);
	}

	public static void dfs(int r, int c, int direction) {
		
		//현재 위치를 청소한다.
		map[r][c] = -1;
		
		//현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		for(int i=0; i<4; i++) {
			direction = (direction + 3) % 4; // 왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동)
			int ny = r + dr[direction];
			int nx = c + dc[direction];
			
			// 청소가 안된 곳이 있으면 count++,  dfs
			if(ny >=0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 0) {
				cnt++;
				dfs(ny,nx, direction);
				
				return;
			}
		}
		
		//네 방향 모두 청소가 이미 되어있거나 벽인 경우에는
		//뒤쪽 칸이 벽이 아니라는 전제 하에, 바라보는 방향을 유지한 채로 한 칸 후진.
		int back = (direction + 2) % 4;
		int by = r + dr[back];
		int bx = c + dc[back];
        
		if(by>=0 && by<N && bx>=0 && bx<M && map[by][bx] != 1) {
			dfs(by,bx,direction);
		}
	}
}
