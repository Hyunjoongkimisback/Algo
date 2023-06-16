package baekjoon;

import java.util.*;

public class Subset {
	static List<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N= sc.nextInt();
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		
		
		for (int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		subset(arr,visited,0);
		
		Collections.sort(result, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length()!=o2.length()) {
					return o1.length()-o2.length(); // 와우..
				} else {
					return o1.compareTo(o2); //스트링이니까 ..
				}
			}
		});
		
		System.out.println(result);
		
	}
	
	private static void subset (int[] arr, boolean[] visited, int idx) {
		if (idx==arr.length) {
			StringBuilder sb= new StringBuilder();
			for(int i=0;i<arr.length;i++) {
				if (visited[i]) {
					sb.append(arr[i]).append(" ");
				}
			}
			sb.append("\n");
			result.add(sb.toString());
			
			return;
		}
		visited[idx]=true;
		subset(arr,visited,idx+1);
		visited[idx]=false;
		subset(arr,visited,idx+1);
		
	}
	
	
}
