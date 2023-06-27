package baekjoon;

import java.util.*;

public class �α��̵�_16234 {
	static int N,L,R;
	static int[][] map;
	static boolean[][] visited;
	static final int[] dr= {1, -1, 0, 0};
	static final int[] dc= {0, 0, 1, -1};
	
	public static class Node {
		int x, y;
		
		public Node (int x, int y) { 
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		///// input //////
			
		// �� ���� visited�ϸ鼭
		// bfs�� add�Ǵ� ���� ������ �α��� sum�ϰ� ArrayList�� ����
		// ��ȸ�� ������ ���� List.size();�� sum �������� �� avg�� ����
		// �ش� ��ǥ�����ٰ� avg�� �ٲ��ְ� day++;
		// ���࿡ list.size()�� 1�̸� while�� �������ͼ� day�� ���
		
		int day=0;
		
		while (true) {
			visited = new boolean[N][N];
			
			int isMove = 0;
			
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					if (!visited[i][j]) {
						isMove += bfs(new Node(i,j));
					}
				}
			}
			
			if (isMove==0) {
				break;
			} else {
				day++;
			}
			
		}
		
		System.out.println(day);
	}
	
	private static int bfs (Node node) {
		List<Node> list = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		
		int sum=map[node.x][node.y];
		
		queue.add(node);
		list.add(node);
		
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			visited[curr.x][curr.y]=true;
			
			for (int i=0;i<4;i++) {
				int nr = curr.x+dr[i];
				int nc = curr.y+dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
					
					int diff = Math.abs(map[nr][nc]-map[curr.x][curr.y]); 
					
					if (diff >= L && diff <= R) {
						sum+=map[nr][nc];
						visited[nr][nc]=true;
						list.add(new Node(nr,nc));
						queue.add(new Node(nr,nc));
					}
				}
			}
		}
		
		
		if (list.size()>1) {
//			System.out.printf("list size = %d\n",list.size());
//			System.out.printf("sum = %d\n",sum);
			letsMove(list, sum);
			
//			for (int i=0;i<N;i++) {
//				for (int j=0;j<N;j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			return 1;
		} else {
			return 0;
		}
	}
	
	private static void letsMove(List<Node> list, int sum) {
		int avg = sum/list.size();
		for (int i=0;i<list.size();i++) {
			map[list.get(i).x][list.get(i).y]=avg;
		}
	}
	
}
