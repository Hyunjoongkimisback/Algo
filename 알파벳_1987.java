import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알파벳_1987 {
	static final int[] dr= {1, -1, 0, 0};
	static final int[] dc= {0, 0, 1, -1};
	static ArrayList<Character> list;
	static char[][] map;
	static int[][] intmap; 
	static boolean[] visited;
	static int[] numArr;
	static int r, c, max;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		r= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		intmap = new int[r][c];
		visited = new boolean[27];

		for (int i=0;i<r;i++) {
			map[i]=br.readLine().toCharArray();
			for (int j=0;j<c;j++) {
				intmap[i][j]=map[i][j]-65;
			}
		}
		
		max=0;
		visited[intmap[0][0]]=true;
		dfs(0,0,1);
		
		System.out.println(max);
	}
	
	static int dfs (int row, int col, int idx) {
		if (max<idx) {
			max=idx;
		}
		for (int i=0;i<4;i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if (nr<0||nr>=r||nc<0||nc>=c) {
				continue;
			}
			
			if (!visited[intmap[nr][nc]]) {
				visited[intmap[nr][nc]]=true;
				dfs(nr,nc,idx+1);
				visited[intmap[nr][nc]]=false;
			}
		}
		return max;
	}
}
