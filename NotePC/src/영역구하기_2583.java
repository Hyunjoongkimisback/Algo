import java.util.*;
import java.io.*;

public class 영역구하기_2583 {
	static int[][] map;
	static boolean[][] visited;
	static int M, N;
	static int[] dr= {0, 0, -1, 1};
	static int[] dc= {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		String[] MNK = br.readLine().split(" ");
		M = Integer.parseInt(MNK[0]);
		N = Integer.parseInt(MNK[1]);
		int K = Integer.parseInt(MNK[2]);
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i=0;i<K;i++) {
			String[] str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);		
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			draw(x1,y1,x2,y2);
			
		}
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				if (map[i][j]==0&&!visited[i][j]) {
					list.add(bfs(i, j));
					cnt++;
				}
			}
		}
		Collections.sort(list);
//		for (int i=0;i<M;i++) {
//			for (int j=0;j<N;j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		sb.append(cnt).append("\n");
		for (int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
	private static int bfs (int row, int col) {
		int subCnt=1;
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {row, col});
		visited[row][col]=true;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for (int i=0;i<4;i++) {
				int nr = curr[0]+dr[i];
				int nc= curr[1]+dc[i];
				
				if (nr>=0 && nc>=0 && nr<M && nc <N && !visited[nr][nc] && map[nr][nc]==0) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc]=true;
					subCnt++;
				}
			}
		}
		return subCnt;
	}
	private static void draw (int x1, int y1, int x2, int y2) {
		for (int i=y1;i<y2;i++) {
			for (int j=x1;j<x2;j++) {
				map[i][j]=1;
			}
		}
	}
}
