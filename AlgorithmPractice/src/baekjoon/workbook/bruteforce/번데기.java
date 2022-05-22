package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¹øµ¥±â {
	private static final int START_MAIN_RHYTHM = 4;
	private static int solution(int n, int t, int a) {
		int answer = 0;
		int round = 2;
		int index = 0;
		int number = 1;
		boolean isPupa = a == 0 ? true : false;
		while(true) {
			if(isPupa) {
				if(isRhythmBun(number)) {
					t--;
				}else if(isRountRhythmBun(number, round)) {
					t--;
				}
			}else {
				if(isRhythmDaegi(number)) {
					t--;
				}else if(isRountRhythmDaegi(number, round)) {
					t--;
				}
			}
			if(isGoal(t)) {
				answer = index;
				break;
			}
			number++;
			index = (index + 1) % n;
			if(isNextRound(number, round)) {
				round++;
				number = 0;
			}
		}
		return answer;
	}

	private static boolean isRhythmBun(int number) {
		return number <= START_MAIN_RHYTHM && number % 2 == 1;
	}
	private static boolean isRhythmDaegi(int number) {
		return number <= START_MAIN_RHYTHM && number % 2 == 0;
	}
	private static boolean isRountRhythmBun(int number, int round) {
		return number > START_MAIN_RHYTHM && number <= START_MAIN_RHYTHM + round;
	}
	private static boolean isRountRhythmDaegi(int number, int round) {
		return number > START_MAIN_RHYTHM + round && number <= START_MAIN_RHYTHM + round + round;
	}
	private static boolean isGoal(int t) {
		return t == 0;
	}
	private static boolean isNextRound(int number, int round) {
		return number == (START_MAIN_RHYTHM + (round * 2));
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int t = Integer.parseInt(reader.readLine());
		int a = Integer.parseInt(reader.readLine());
		System.out.println(solution(n, t, a));
	}
}
