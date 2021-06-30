package backJun.greedy;

import java.util.Scanner;

public class °Å½º¸§µ· {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		System.out.println(solution(1000-money));
		
	}

	private static int solution(int money) {
		int cnt = 500;
		int returnMoneyCount = 0;
		for(int i=5;i>=0;--i) {
			if(money >= cnt) {
				returnMoneyCount += money/cnt;
				money %= cnt;
			}
			if(money == 0)
				break;
			if(i % 2 == 0) {
				cnt /= 2;
			}else {
				cnt /= 5;
			}
		}
		return returnMoneyCount;
	}

}
