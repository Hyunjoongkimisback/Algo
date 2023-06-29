package baekjoon;

import java.util.*;
import java.io.*;

public class ¡÷ªÁ¿ß_14499 {
	
	static int[] dice = new int[7];
	static int n,m,r,c;
	static int[][] map;
	static final int[] dr = {0, 0, -1, 1};
	static final int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int dir = Integer.parseInt(st.nextToken());
			moveDice(dir);
		}
	}
	
	private static void moveDice(int dir) { 
		int nr= r + dr[dir-1];
		int nc= c + dc[dir-1];	
		if (nr>=0 && nc >=0 && nr< n && nc <m) {
			roll(nr, nc, dir);
			r=nr;
			c=nc;
		}
	}
	
	private static void roll(int row, int col, int dir) {
		int temp = dice[3];
		switch(dir) {
		case 1: 
			dice[3]=dice[4];
			dice[4]=dice[6];
			dice[6]=dice[2];
			dice[2]=temp;
			break;
		case 2:
			dice[3] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[4];
			dice[4] = temp;
			break;
		case 3:
			dice[3] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[1];
			dice[1] = temp;
			break;
		case 4:
			dice[3] = dice[1];
			dice[1] = dice[6];
			dice[6] = dice[5];
			dice[5] = temp;
			break;
		}
		
		if (map[row][col]==0) {
			map[row][col]=dice[6];
			
		} else {
			dice[6]=map[row][col];
			map[row][col]=0;
		}
		System.out.println(dice[3]);
	}
	
	
	
}
