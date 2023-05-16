package baekjoon;

import java.util.*;

public class 연구소_14502 {
	static int R, C, min;
	static int[][] map, wallMap;
	static boolean[][] mapVisited;
	static boolean[] visited;
	
	static final int[] dr = {1,-1,0,0};
	static final int[] dc = {0,0,1,-1};
	static Deque<XY> queue;
	static List<XY> listvirus;
	static List<XY> listWall;
	
	static class XY {
		int row, col;

		public XY(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		R=sc.nextInt();
		C=sc.nextInt();
		map = new int[R][C];
		min = Integer.MAX_VALUE;
		

		//벽 세울곳 후보지 list
		listWall = new ArrayList<>();
		
		//바이러스 위치
		listvirus = new ArrayList<>();
		
		for (int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				map[i][j]=sc.nextInt();
				if (map[i][j]==0) {
					listWall.add(new XY(i,j));
				} else if (map[i][j]==2) {
					listvirus.add(new XY(i,j));
				}
			}
		}
		// 이건 벽을 세울 위치 combination용
		visited = new boolean[listWall.size()];
		
		// 벽 세움
		comb(0, listWall.size(), 3);
		
//		System.out.println(min);
		
		System.out.println(listWall.size()-min-3);
		
	}
	
	static void bfs(boolean[][] visited, int[][] copymap) {
		visited = new boolean[R][C];

		int birus = 0;
		//bfs돌릴 queue
		queue = new ArrayDeque<>();
		for (int i=0;i<listvirus.size();i++) {
			queue.add(new XY(listvirus.get(i).row, listvirus.get(i).col));	
		}
		
		while (!queue.isEmpty()) {
			XY curr= queue.poll();
			
			for (int i=0;i<4;i++) {
				int nr = curr.row + dr[i];
				int nc = curr.col + dc[i];
				
				if (nr<0||nc<0||nr>=R||nc>=C) {
					continue;
				}
				if (visited[nr][nc]) {
					continue;
				}
				if (copymap[nr][nc]==0) {
					visited[nr][nc]=true;
					copymap[nr][nc]=2;
					birus++;
					queue.add(new XY(nr,nc));
				} 	
			}
		}
		min=Math.min(min, birus);
	}
	
	static void comb (int idx, int n, int r) {
		if (r==0) {
			int[][] copymap = new int[R][C];
			for (int i=0;i<R;i++) {
				copymap[i] = map[i].clone();
			}

			
			for (int i=0;i<n;i++) {
				if (visited[i]) {
					XY xy = listWall.get(i);
					copymap[xy.row][xy.col]=1;
				}
			}
			
			bfs(mapVisited, copymap);
			return;
		}
		
		for (int i=idx;i<n;i++) {
			if (!visited[i]) {
				visited[i]=true;
				comb(i+1,n,r-1);
				visited[i]=false;
			}
		}
	}
}
