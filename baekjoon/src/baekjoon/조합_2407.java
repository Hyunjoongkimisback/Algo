package baekjoon;

import java.math.BigInteger;
import java.util.*;

public class ����_2407 {
	public static void main(String[] args) {
		//nCm���
		
		Scanner sc = new Scanner(System.in);
		
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		
		BigInteger ����=new BigInteger("1");
		BigInteger �и�=new BigInteger("1");
		for (BigInteger i = n; i.compareTo(n.subtract(m)) > 0; i = i.subtract(BigInteger.ONE)) {
		    ���� = ����.multiply(i);
		}

		for (BigInteger i = m; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
		    �и� = �и�.multiply(i);
		}
		System.out.println(����.divide(�и�));
				
		
	}
}
