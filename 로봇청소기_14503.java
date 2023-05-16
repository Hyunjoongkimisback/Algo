package baekjoon;

import java.util.*;

public class �κ�û�ұ�_14503 {
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
		
		//���� ��ġ�� û���Ѵ�.
		map[r][c] = -1;
		
		//���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
		for(int i=0; i<4; i++) {
			direction = (direction + 3) % 4; // ���� �������� ��ȯ (�� -> �� -> �� -> ��)
			int ny = r + dr[direction];
			int nx = c + dc[direction];
			
			// û�Ұ� �ȵ� ���� ������ count++,  dfs
			if(ny >=0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 0) {
				cnt++;
				dfs(ny,nx, direction);
				
				return;
			}
		}
		
		//�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��
		//���� ĭ�� ���� �ƴ϶�� ���� �Ͽ�, �ٶ󺸴� ������ ������ ä�� �� ĭ ����.
		int back = (direction + 2) % 4;
		int by = r + dr[back];
		int bx = c + dc[back];
        
		if(by>=0 && by<N && bx>=0 && bx<M && map[by][bx] != 1) {
			dfs(by,bx,direction);
		}
	}
}
