package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class È¦¼öÈ¦¸¯È£¼® {
	private static int min;
	private static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String number = reader.readLine();
		System.out.println(solution(number));
	}

	private static String solution(String number) {
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		permutation(number, 0);
		return min + " " + max;
	}

	private static void permutation(String number, int count) {
		count += countNumber(number);
		if(isFinsh(number)) {
			max = Math.max(max, count);
			min = Math.min(min, count);
			return;
		}
		if(isOverSizeThree(number)) {
			overThreeSizeWay(number, count);
			
		}else if(isSizeEqualSecond(number)){
			equalSecondSizeWay(number, count);
		}
	}
	
	private static void overThreeSizeWay(String number, int count) {
		for(int i=1;i<number.length()-1;++i) {
			for(int j=i+1;j<number.length();++j) {
				int index1 = i;
				int index2 = j;
				int number1 = convert(number, 0, index1);
				int number2 = convert(number, index1, index2);
				int number3 = convert(number, index2);
				permutation(String.valueOf(number1 + number2 + number3), count);
			}	
		}
	}
	
	private static void equalSecondSizeWay(String number, int count) {
		for(int i=1;i<number.length();++i) {
			int number1 = convert(number, 0, i);
			int number2 = convert(number, i);
			permutation(String.valueOf(number1 + number2), count);
		}
	}




	private static int convert(String number, int start, int end) {
		return Integer.parseInt(number.substring(start, end));
	}
	private static int convert(String number, int start) {
		return Integer.parseInt(number.substring(start));
	}

	private static int countNumber(String number) {
		int count = 0;
		for(int i=0;i<number.length();++i) {
			int num = Character.digit(number.charAt(i), 10);
			if(isHolsu(num)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isHolsu(int num) {
		return num % 2 == 1;
	}

	private static boolean isFinsh(String number) {
		return number.length() <= 1;
	}
	private static boolean isOverSizeThree(String number) {
		return number.length() >= 3;
	}
	private static boolean isSizeEqualSecond(String number) {
		return number.length() == 2;
	}

}
