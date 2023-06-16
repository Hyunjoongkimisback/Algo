package baekjoon;

import java.util.*;
import java.io.*;

public class �����ձ��ϱ�5_11660 {
	
	static int[][] sumMap;
	static int[][] com;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		sumMap = new int[N+1][N+1];
		com = new int[M][4];
		
		//map �ޱ�
		//�Է°� ���ÿ� �չ迭 ���ϱ�
		//S[i][j] = S[i-1][j]+S[i][j-1]-S[i-1][j-1]+map[i][j];
		for (int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1;j<N+1;j++) {
				sumMap[i][j]=sumMap[i-1][j]+sumMap[i][j-1]-sumMap[i-1][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
		//command�ޱ�
		//�޾Ƽ� ��Ƴ������� �ٷ� �ٷ� ����������
		//�������� ���Ҷ��
		//S[x2][y2] - S[x1-1][y2]-S[x2][y1-1]+S[x1-1][y1-1]
		int result=0;
		for (int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int x1= Integer.parseInt(st.nextToken());
			int y1= Integer.parseInt(st.nextToken());
			int x2= Integer.parseInt(st.nextToken());
			int y2= Integer.parseInt(st.nextToken());
			result= sumMap[x2][y2]-sumMap[x1-1][y2]-sumMap[x2][y1-1]+sumMap[x1-1][y1-1];
			System.out.println(result);
		}
	}
}
