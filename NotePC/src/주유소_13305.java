import java.util.*;
import java.io.*;

public class 주유소_13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str1 = br.readLine().split(" ");
		String[] str2 = br.readLine().split(" ");
		
		Long[] dist = new Long[N];
		Long[] price = new Long[N];
		
		Long currPrice = (long) 1000000000;
		
		Long total=(long) 0;
		
		for (int i=0;i<N-1;i++) {
			dist[i]=(long) Integer.parseInt(str1[i]);
			price[i]=(long) Integer.parseInt(str2[i]);
			
			if (price[i]<currPrice) {
				currPrice=price[i];
			}
			total+=currPrice*dist[i];
			
		}
		System.out.println(total);
		
	}
}
