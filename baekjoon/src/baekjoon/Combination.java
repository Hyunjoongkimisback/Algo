package baekjoon;

import java.util.*;

public class Combination {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();

		int[] arr = new int[n];
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		
		comb(arr, visited, 0, r);
	}

	static void comb(int[] arr, boolean[] visited, int start, int r) {
		if (r == 0) {
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		for (int i = start; i < arr.length; i++) {
			visited[i] = true;
			comb(arr, visited, i + 1, r - 1);
			visited[i] = false;
		}

	}

}
