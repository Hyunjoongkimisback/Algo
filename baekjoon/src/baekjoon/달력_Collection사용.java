package baekjoon;

import java.time.LocalDate;

public class 달력_Collection사용 {
	public static void main(String[] args) {
		
		LocalDate currentDate = LocalDate.now();
		
		int year = currentDate.getYear();
		int month = currentDate.getMonthValue()-1;
		int date=0;
		
		int[] Months = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if (month==1 && year%4==0 && year%100!=0 || year%400==0) {
			date+=1;
		}
		date +=Months[month];
		
		System.out.printf("%d년의 %d월의 일 수는 %d일 입니다\n", year, month+1, date);
		
		
	}
}
