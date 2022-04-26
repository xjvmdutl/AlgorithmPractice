package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		int studentCount = Integer.parseInt(reader.readLine());
		int[][] students = new int[studentCount][2];
		for(int i=0;i<studentCount;++i) {
			tokens = new StringTokenizer(reader.readLine());
			students[i][0] = Integer.parseInt(tokens.nextToken());
			students[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, students, n, studentCount));
	}

	private static String solution(int[] arr, int[][] students, int n, int studentCount) {
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<studentCount;++i) {
			int gender = students[i][0];
			if(isMan(gender)) {
				multiple(arr, students[i][1]);
			}else if(isWoman(gender)) {
				symmetry(arr, students[i][1] - 1);
			}else {
				throw new IllegalArgumentException("Gender Is Error");
			}
		}
		print(answer, arr);
		return answer.toString();
	}

	private static void symmetry(int[] arr, int index) {
		arr[index] = change(arr[index]);
		if(index < arr.length / 2) {
			for(int i=1;index - i >= 0; ++i) {
				if(arr[index-i] != arr[index+i]) {
					return;
				}
				arr[index+i] = change(arr[index + i]);
				arr[index-i] = change(arr[index - i]);
			}	
		}else {
			for(int i=1;index + i < arr.length; ++i) {
				if(arr[index-i] != arr[index+i]) {
					return;
				}
				arr[index+i] = change(arr[index + i]);
				arr[index-i] = change(arr[index - i]);
			}
		}
		
	}

	private static void multiple(int[] arr, int index) {
		for(int i=index - 1;i<arr.length;i += index) {
			arr[i] = change(arr[i]);
		}
	}

	private static int change(int number) {
		return isZero(number) ? 1 : 0;
	}

	private static boolean isZero(int number) {
		return number == 0;
	}

	private static boolean isMan(int gender) {
		return gender == 1;
	}

	private static boolean isWoman(int gender) {
		return gender == 2;
	}

	private static void print(StringBuilder answer, int[] arr) {
		for(int i=1;i<=arr.length;++i) {
			answer.append(arr[i - 1] + " ");
			if(i % 20 == 0) {
//				answer.delete(answer.length()-1, answer.length());
				answer.append("\n");
			}
			
		}
	}

}
