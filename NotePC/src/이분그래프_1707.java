
import java.util.*;
import java.io.*;

public class 이분그래프_1707 {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=0 ; tc<T;tc++) {
			String[] VE = br.readLine().split(" ");
			int V = Integer.parseInt(VE[0]);
			int E = Integer.parseInt(VE[1]);
			
			visited = new int[V+1];
			
			graph = new ArrayList<>();
			for (int i=0;i<V+1;i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i=0;i<E;i++) {
				String[] ab = br.readLine().split(" ");
				int a = Integer.parseInt(ab[0]);
				int b = Integer.parseInt(ab[1]);
				
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			flag=false;
			
			for (int i=1;i<V+1;i++) {
				if (visited[i]==0) {
					checkDFS(i,1);
				}

			}
			if (!flag) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void checkDFS(int idx, int color) {
		visited[idx]=color;
		if (flag) {
			return;
		}
		
		for (int i=0;i<graph.get(idx).size();i++) {
			int next = graph.get(idx).get(i);
			
			if (visited[next]==visited[idx]) {
				flag=true;
				return;
			}
			if (visited[next]==0) {
				checkDFS(next, color*(-1));
			}
		}
	}
	
	
}
