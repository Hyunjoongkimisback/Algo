package baekjoon;

import java.math.BigInteger;
import java.util.*;

public class 조합_2407 {
	public static void main(String[] args) {
		//nCm출력
		
		Scanner sc = new Scanner(System.in);
		
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		
		BigInteger 분자=new BigInteger("1");
		BigInteger 분모=new BigInteger("1");
		for (BigInteger i = n; i.compareTo(n.subtract(m)) > 0; i = i.subtract(BigInteger.ONE)) {
		    분자 = 분자.multiply(i);
		}

		for (BigInteger i = m; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
		    분모 = 분모.multiply(i);
		}
		System.out.println(분자.divide(분모));
				
		
	}
}
