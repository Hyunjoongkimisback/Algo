import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		
		for (int i=0;i<N;i++) {
			A[i]=sc.nextInt();
			B[i]=A[i];
		}
		
		Arrays.sort(B);
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (A[i]==B[j]) {
					sb.append(j+ " ");
					B[j]=-1;
					break;
				}
			}
		}
		System.out.println(sb);
		
	}
	
}

//8
//4 1 6 1 3 6 1 4
//1 1 1 3 4 4 6 6

//4 0 6 1 3 7 2 5