import java.util.*;
import java.io.*;

public class RGB거리_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		
		int[] red = new int[N];
		int[] green = new int[N];
		int[] blue = new int[N];
		
		String[] str = br.readLine().split(" ");
		red[0]=Integer.parseInt(str[0]);
		green[0]=Integer.parseInt(str[1]);
		blue[0]=Integer.parseInt(str[2]);
		
		for (int i=1;i<N;i++) {
			String[] str2 = br.readLine().split(" ");
			red[i]=Integer.parseInt(str2[0]);
			green[i]=Integer.parseInt(str2[1]);
			blue[i]=Integer.parseInt(str2[2]);
			
			red[i]+=Math.min(green[i-1], blue[i-1]);
			green[i]+=Math.min(blue[i-1], red[i-1]);
			blue[i]+=Math.min(green[i-1], red[i-1]);
		}
		
		int min = Integer.MAX_VALUE;
		
		min = Math.min(min, red[N-1]);
		min = Math.min(min, blue[N-1]);
		min = Math.min(min, green[N-1]);
		
		System.out.println(min);
	}
}
