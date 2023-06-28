package baekjoon;

import java.util.*;
import java.io.*;

public class Åé´Ï¹ÙÄû_14891 {

	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			visited = new boolean[4];

			rotate(a-1, b);
		}

		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (arr[i][0] == 1) {
				sum += arr[i][0] * (1 << i);
			}
		}
		System.out.println(sum);

	}

	private static void rotate(int wheel, int dir) {
		visited[wheel] = true;

		if (wheel - 1 >= 0 && arr[wheel - 1][2] != arr[wheel][6] && !visited[wheel - 1]) {
			rotate(wheel - 1, dir * (-1));
		}
		if (wheel + 1 <= 3 && arr[wheel][2] != arr[wheel + 1][6] && !visited[wheel + 1]) {
			rotate(wheel + 1, dir * (-1));
		}

		if (dir == 1) {
			int temp = arr[wheel][7];
			for (int i = 6; i >= 0; i--) {
				arr[wheel][i + 1] = arr[wheel][i];
			}
			arr[wheel][0] = temp;
		} else {
			int temp = arr[wheel][0];
			for (int i = 0; i < 7; i++) {
				arr[wheel][i] = arr[wheel][i + 1];
			}
			arr[wheel][7] = temp;
		}

	}

}
