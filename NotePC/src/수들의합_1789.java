import java.util.*;

public class 수들의합_1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Long N = sc.nextLong();
		
		int idx=0;
		
		while (true) {
			if (N<cal(idx)) {
				idx--;
				break;
			}
			idx++;
		}
		
		System.out.println(idx);
		
	}
	
	static Long cal(long idx) {
		return idx*(idx+1)/2;
	}
	
}
