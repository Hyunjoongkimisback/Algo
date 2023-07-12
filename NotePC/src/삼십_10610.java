
import java.util.*;
import java.io.*;

public class 삼십_10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		boolean flag0=false;
		boolean flag3=false;
		int subSum=0;
		PriorityQueue<Integer> queue= new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i=0;i<str.length();i++) {
			int a =str.charAt(i)-'0';
			subSum+=a;
			if (a==0) {
				flag0=true;
			}
			queue.add(a);
		}
		if (subSum%3==0) {
			flag3=true;
		}
		if (flag0&&flag3) {
			while (!queue.isEmpty()) {
				sb.append(queue.poll());
			}
		} else {
			sb.append(-1);
		}
		
		System.out.println(sb);
//		//0이 있고, 나머지가 3으로 나눠지는지?
//		//판별하고 정렬
		
		
	}
}
