import java.util.*;

public class Main {
	static double xa,ya,xb,yb,xc,yc;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		xa=sc.nextDouble();
		ya=sc.nextDouble();
		xb=sc.nextDouble();
		yb=sc.nextDouble();
		xc=sc.nextDouble();
		yc=sc.nextDouble();
		
		double dist1=distance(xa,xb,ya,yb);
		double dist2=distance(xa,xc,ya,yc);
		double dist3=distance(xb,xc,yb,yc);
		
		double[] list = new double[3];
		list[0]=makeSquareDist(dist1, dist2);
		list[1]=makeSquareDist(dist2, dist3);
		list[2]=makeSquareDist(dist1, dist3);
		
		Arrays.sort(list);
		
		if (check()) {
			System.out.print(compare(list));
		} else {
			System.out.println("-1.0");
		}
		
	}
	
	static boolean check() {
		if (xa==xb&&ya==yb) {
			return false;
		}
		if (xb==xc&&yb==yc) {
			return false;
		}
		if (xa==xc&&ya==yc) {
			return false;
		}
		
		if (xb==xa&&xc==xb) {
			return false;
		} else {
			double slope2=(yc-yb)/(xc-xb);
			double slope1=(yb-ya)/(xb-xa);
			if (slope1==slope2) return false;
			else return true;
		}
	}
	
	static double distance(double x1, double x2, double y1, double y2) {
		double dist= ((double) Math.pow(x1-x2,2) + (double) Math.pow(y1-y2, 2));
		dist=(double) Math.sqrt(dist);
		return dist; 
	}
	
	static double makeSquareDist(double dist1, double dist2) {
		return 2*(dist1+dist2);
	}
	
	static double compare(double[] list) {
		return list[2]-list[0];
	}
	
}