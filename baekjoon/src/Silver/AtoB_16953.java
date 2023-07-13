package Silver;

import java.util.*;
import java.io.*;

public class AtoB_16953 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();

		System.out.println(bfs(a, b));

	}

	private static Long bfs(Long a, Long b) {
		PriorityQueue<Long[]> queue = new PriorityQueue<>(new Comparator<Long[]>() {
			@Override
			public int compare(Long[] o1, Long[] o2) {
				return o1[1].compareTo(o2[1]);
			}
		});

		queue.add(new Long[] { a, (long) 1 });

		while (!queue.isEmpty()) {
			Long[] curr = queue.poll();
			if (curr[0].equals(b)) {
				return curr[1];
			}

			if (curr[0] * 2 <= b && curr[0] < 1000000001L) {
				queue.add(new Long[] { curr[0] * 2, (long)(curr[1] + 1) });
			}
			if (curr[0] * 10 + 1 <= b && curr[0] < 1000000001L) {
				queue.add(new Long[] { curr[0] * 10 + 1, (long) (curr[1] + 1) });
			}
		}
		return (long) -1;
	}

}
