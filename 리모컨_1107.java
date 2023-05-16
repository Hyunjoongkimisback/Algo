import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 리모컨_1107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int n = Integer.parseInt(N);  // 5457
		
		int b = Integer.parseInt(br.readLine());
		int[] bNums = new int[b];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<b;i++) {
			bNums[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(bNums);
		
		String[] arr = N.split("");
		int[] target = new int[arr.length];
		for (int i=0;i<arr.length;i++) {
			target[i]=Integer.parseInt(arr[i]);
		}
		//////////////////////////////////
		
		List<Integer> list = new ArrayList<>();
		for (int i=0;i<10;i++) {
			list.add(i);
		}
		for (int i=bNums.length-1;i>=0;i--) {
			list.remove(bNums[i]);
		}
		//이렇게 하면 고장난 버튼들 지움
		//////////////////////////////////
		
		int res= letsFind(target, list);
		
		//버튼 눌러가지고 가장 가까운 곳으로 갈때의 최소값
		//////////////////////////////////
		int min = Integer.MAX_VALUE;
		min= Math.min(res+target.length, Math.abs(n-100));
		//////////////////////////////////
		
		System.out.println(min);
	}
	
	static int letsFind(int[] arr, List<Integer> list) {
		int res=0;
		int temp=0;
		for (int i=0;i<arr.length;i++) {
			int min=10;
			for (int j=0;j<list.size();j++) {
				temp=Math.abs((arr[i]-list.get(j)));
				
				min=Math.min(min, temp);
				
				if (i==0&&min>10-arr[i]) {
					res+=(10-arr[i])*Math.pow(10, arr.length);
				}
			}
			res+=(int) (min*Math.pow(10, arr.length-i-1));
		}
		return res;
	}
	
}
/*
9999
8
2 3 4 5 6 7 8 9
 */


