package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class °Å½º¸§µ· {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(reader.readLine());
		System.out.println(solution(1000-money));
		
	}

	private static int solution(int money) {
		int[] moneys = {500,100,50,10,5,1};
		int returnMoneyCount = 0;
		for(int i=0;i<moneys.length;++i) {
			returnMoneyCount += money/moneys[i];
			money %= moneys[i];
		}
		return returnMoneyCount;
	}

}
