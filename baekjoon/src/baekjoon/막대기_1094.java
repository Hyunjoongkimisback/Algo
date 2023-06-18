package baekjoon;

import java.util.*;

public class ¸·´ë±â_1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int a = 64;
		int x = sc.nextInt();
		
		// 23 = 10111
		// 32 = 100000
		// 48 = 110000
		
		int idx=0;
		int cnt=0;
		
		while ((1<<idx)<=a) {
			if (((1<<idx)&x) ==(1<<idx)) {
				cnt++;
			}
			idx++;
		}
		
		System.out.println(cnt);
		
		
		
	}
}
