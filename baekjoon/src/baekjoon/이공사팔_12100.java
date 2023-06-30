package baekjoon;

import java.util.*;

public class ÀÌ°ø»çÆÈ_12100 {

	static int N;
	static int[][] map;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		
		System.out.println(ans);
		
	}

	private static void dfs(int cnt) {
		if (cnt == 5) {
			if (ans < maxCheck()) {
				ans = maxCheck();
			}
			return;
		}
		int[][] mapCopy = new int[N][N];
		for (int i = 0; i < N; i++) {
			mapCopy[i] = map[i].clone();
		}

		for (int i = 0; i < 4; i++) {
			move(i);
			dfs(cnt + 1);
			for (int j = 0; j < N; j++) {
				map[j] = mapCopy[j].clone();
			}
		}
	}

	private static void move(int dir) {
		LinkedList<Integer> queue = new LinkedList<>();

		if (dir == 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						queue.add(map[i][j]);
					}
					map[i][j]=0;
				}
				int idx=0;
				while (!queue.isEmpty()) {
					int curr = queue.poll();
					if (map[i][idx] ==0) {
						map[i][idx] = curr;
					} else if (map[i][idx]==curr) {
						map[i][idx]=curr*2;
						idx++;
					} else {
						idx++;
						map[i][idx]=curr;
					}
				}
			}
		} else if (dir == 1) { // ÁÂ
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (map[i][j] != 0)
                        queue.add(map[i][j]);
                    map[i][j] = 0;
                }

                int idx = N - 1;
                while (!queue.isEmpty()) {
                    Integer curr = queue.poll();

                    if (map[i][idx] == 0) {
                        map[i][idx] = curr;
                    } else if (map[i][idx] == curr) {
                        map[i][idx] = curr * 2;
                        idx--;
                    } else {
                        idx--;
                        map[i][idx] = curr;
                    }
                }
            }
        } else if (dir == 2) { // ÇÏ
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (map[j][i] != 0)
                        queue.add(map[j][i]);
                    map[j][i] = 0;
                }

                int idx = N - 1;
                while (!queue.isEmpty()) {
                    Integer curr = queue.poll();

                    if (map[idx][i] == 0) {
                        map[idx][i] = curr;
                    } else if (map[idx][i] == curr) {
                        map[idx][i] = curr * 2;
                        idx--;
                    } else {
                        idx--;
                        map[idx][i] = curr;
                    }
                }
            }
        } else if (dir == 3) { // »ó
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[j][i] != 0)
                        queue.add(map[j][i]);
                    map[j][i] = 0;
                }

                int idx = 0;
                while (!queue.isEmpty()) {
                    Integer curr = queue.poll();

                    if (map[idx][i] == 0) {
                        map[idx][i] = curr;
                    } else if (map[idx][i] == curr) {
                        map[idx][i] = curr * 2;
                        idx++;
                    } else {
                        idx++;
                        map[idx][i] = curr;
                    }
                }
            }
        }

		
		
	}

	private static int maxCheck() {
		int maxResult = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (maxResult < map[i][j]) {
					maxResult = map[i][j];
				}
			}
		}

		return maxResult;
	}

}
