
import java.util.*;
import java.io.*;

public class 뒤집기_1439 {
	public static void main(String[] args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		
		int cnt1=0;
		int cnt0=0;
		
		if (str[0].equals("0")) {
			cnt0++;
		} else {
			cnt1++;
		}
		
		for (int i=1;i<str.length;i++) {
			if(!str[i].equals(str[i-1])) {
				if (str[i].equals("0")) {
					cnt0++;
				} else {
					cnt1++;
				}
			}
		}
		
		System.out.println(Math.min(cnt0, cnt1));
	}
}
