import java.util.*;
import java.io.*;

//이건 크루스칼 알고리즘
// parent[], union find로 하는거
// Node는 start, end, weight 세개 다하고
// 한방향만 받아도 된다는 것

public class 최소스패닝트리_1197 {

	public static class Node {
		int start, end, weight;

		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] VE = br.readLine().split(" ");
		int V = Integer.parseInt(VE[0]);
		int E = Integer.parseInt(VE[1]);

		ArrayList<Node> graph = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			String[] vew = br.readLine().split(" ");
			int a = Integer.parseInt(vew[0]);
			int b = Integer.parseInt(vew[1]);
			int c = Integer.parseInt(vew[2]);

			graph.add(new Node(a, b, c));
		}

		graph.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight - o2.weight;
			}
		});

		parent = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parent[i] = i;
		}

		int total = 0;

		for (int i = 0; i < E; i++) {
			Node curr = graph.get(i);
			if (!isSameP(curr.start, curr.end)) {
				union(curr.start, curr.end);
				total += curr.weight;
			}
		}
		System.out.println(total);
		
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x!=y) {
			if (x>y) {
				parent[x]=y;
			}else {
				parent[y]=x;
			}
		}
	}
	private static boolean isSameP(int x, int y) {
		x = find(x);
		y = find(y);
		if (x==y) {
			return true;
		} else {
			return false;
		}
	}

}
