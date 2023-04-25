import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//90 나누기 5 = 18
		//그안에 소수 2 3 5 7 11 13 17 : 7개
		//소수 아닌거 0,1,4,6,8,9,10,12,14,15,16,18 : 12개
		//둘다 못할 확률
		
		//18C1*확률^1,(18Ci)*(확률^i), ...18C17  : A팀
		
		double pa=sc.nextDouble()/100;
		double pb=sc.nextDouble()/100;
		
		int[] arr= {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
		
		double totalPa=0;
		double totalPb=0;
		
		for (int i=0;i<arr.length;i++) {
			if (arr[i]>9) {
				int n=18-arr[i];
				totalPa+=comb(n)*Math.pow(1-pa, n) * Math.pow(pa, arr[i]);
				totalPb+=comb(n)*Math.pow(1-pb, n) * Math.pow(pb, arr[i]);
			} else {
				int n=arr[i];
				totalPa+=comb(n)*Math.pow(pa, n) * Math.pow(1-pa, 18-n) ;
				totalPb+=comb(n)*Math.pow(pb, n) * Math.pow(1-pb, 18-n);
			}
		}
		
		System.out.println(1-totalPa*totalPb);
		
	}
	
	
	static double comb(int n) {
		double m = 1;
		double s = 1;
		for (int i=18;i>18-n;i--) {
			m*=i;
		}
		for (int i=1;i<=n;i++) {
			s*=i;
		}
		return m/s;
	}
}