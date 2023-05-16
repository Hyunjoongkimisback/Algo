import java.util.*;

public class 치즈_2636 {
	static int[][] map;
	static boolean[][] visited;
	static final int[] dr = {1, -1, 0, 0};
	static final int[] dc = {0, 0, 1, -1};
	static int row, col, cnt;
	static Stack<Integer> stack;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		
		map= new int[row][col];
		visited= new boolean[row][col];
		stack = new Stack<>();
		
		for (int i=0;i<row;i++) {
			for (int j=0;j<col;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		//////////////////////////////
		
		
		int day = 0;
		
		while (cnt>0) {
			bfs();
			day++;
		}
		System.out.println(day);
		System.out.println(stack.pop());
		
	}
	
	static void bfs () {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,0});
		visited[0][0]=true;
		cnt=0;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for (int i=0;i<4;i++) {
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if (nr<0|| nc<0|| nr>=row||nc>=col) {
					continue;
				}
				if (!visited[nr][nc]) {
					if (map[nr][nc]==0) {
						visited[nr][nc]=true;
						queue.add(new int[] {nr,nc});
					} else {
						visited[nr][nc]=true;
						map[nr][nc]=0;
						cnt++;
					}
				}
			}
		}
		
		stack.push(cnt);		
	}
	
}
