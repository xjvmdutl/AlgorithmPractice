package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기적의매매법 {
	private static final int MAX_LENGTH = 14;
	private static final int ZERO = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<MAX_LENGTH;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static String solution(int[] arr, int n) {
		int junhunMoney = BNP(arr, n);
		int sungminMoney = TIMING(arr, n);
		
		return isSame(junhunMoney, sungminMoney);
	}

	private static int TIMING(int[] arr, int n) {
		int count = 0;
		int upCount = 0;
		int downCount = 0;
		for(int i=1;i< MAX_LENGTH - 1;++i) { // 마지막 날 사면 안되
			if(arr[i] - arr[i-1] > 0) {
				//증가
				upCount++;
				downCount = 0;
			}else if(arr[i] - arr[i-1] < 0){
				//증가
				upCount = 0;
				downCount++;
			}
			if(isThreeDays(upCount)) {
				//무조건 하락
				//전량 매도
				n += count * arr[i];
				count = 0;
			}else if(isThreeDays(downCount)){
				//전량 매수
				count += n / arr[i];
				n %= arr[i];
			}
		}
		int money = calcMoney(arr[MAX_LENGTH-1], n, count);
		return money;
	}

	private static boolean isThreeDays(int count) {
		if(count >= 3) {
			return true;
		}
		return false;	}

	private static String isSame(int junhunMoney, int sungminMoney) {
		if(junhunMoney > sungminMoney) {
			return "BNP";
		}else if(junhunMoney < sungminMoney) {
			return "TIMING";	
		}else {
			return "SAMESAME";	
		}
	}

	private static int BNP(int[] arr, int n) {
		int count = 0;
		for(int i=0;i< MAX_LENGTH - 1;++i) { // 마지막 날 사면 안되
			if(n == ZERO) {
				break;
			}
			count += n / arr[i];
			n %= arr[i];
		}
		int money = calcMoney(arr[MAX_LENGTH-1], n, count);
		return money;
	}

	private static int calcMoney(int lastMoney, int n, int count) {
		return (lastMoney * count) + n;
	}

	

}
