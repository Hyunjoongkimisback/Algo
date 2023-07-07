import java.util.*;
import java.io.*;

public class 잃어버린괄호_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split("-");

		int Total = 0;

		int minusSum = 0;
		int addSum = 0;

		for (int i = 0; i < str.length; i++) {
			String[] numbers = str[i].split("\\+");
			if (i == 0) {
				for (int j = 0; j < numbers.length; j++) {
					addSum += Integer.parseInt(numbers[j]);
				}
			} else {

				for (int j = 0; j < numbers.length; j++) {
					minusSum += Integer.parseInt(numbers[j]);
				}
			}
		}
		Total = addSum - minusSum;
		System.out.println(Total);

		// 10 + 15 -20 - 10 +20 +30 - 15 + 20
		// str0, str1 str2 str3
		// n[0] n[1] n[0]
	}
}
