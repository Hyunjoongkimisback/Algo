import java.util.*;

public class 로프_2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		for (int i=0;i<N;i++) {
			queue.add(sc.nextInt());
		}
		
		int maxValue=0;
		
		
		for (int i=0;i<N;i++) {
			maxValue=Math.max(maxValue, (i+1)*queue.poll());
		}
		
		System.out.println(maxValue);
		
		
		
	}
}
