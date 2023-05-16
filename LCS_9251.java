package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class LCS_9251 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1 = br.readLine().split("");
		String[] str2 = br.readLine().split("");
		
		int len1=str1.length;
		int len2=str2.length;
		
		int[][] arr = new int[len1+1][len2+1];
		
		for (int i=1;i<=len1;i++) {
			for (int j=1;j<=len2;j++) {
				if (str1[i-1].equals(str2[j-1])) {
					arr[i][j]=arr[i-1][j-1]+1;
				} else {
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		
		System.out.println(arr[len1][len2]);
		
	}
}
