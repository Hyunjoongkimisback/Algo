
import java.util.*;
import java.io.*;

public class 보물_1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arrA = new ArrayList<>();
		ArrayList<Integer> arrB = new ArrayList<>();
		
		String[] strA = br.readLine().split(" ");
		String[] strB = br.readLine().split(" ");
		
		for (int i=0;i<N;i++) {
			arrA.add(Integer.parseInt(strA[i]));
			arrB.add(Integer.parseInt(strB[i]));
		}
		
		Collections.sort(arrA);
		Collections.sort(arrB, Comparator.reverseOrder());
		
		int sum =0;
		
		for (int i=0;i<N;i++) {
			sum+= arrA.get(i)*arrB.get(i);
		}
		
		System.out.println(sum);
		
	}
}
