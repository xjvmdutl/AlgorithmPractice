package backJun;

import java.util.Scanner;

public class º≥≈¡πË¥ﬁ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(solution(num));
	}


	private static int solution(int num) {
		int cnt = -1;
		for(int i=0;i<=num/5;++i) {
			int tmp = permulate(num - 5*i, 0);
			if(tmp != -1)
				cnt = tmp+i;
		}
		

		return cnt;
	}
	private static int permulate(int num,int cnt) {
		if(num % 3 != 0)
			return -1;
		return num/3;
	}

}
