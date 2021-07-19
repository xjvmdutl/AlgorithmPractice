package backJun.stepBystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ´ÙÀÌ¾ó {
	public static String[] arr = new String[10];
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		arr[2] = "ABC";
		arr[3] = "DEF";
		arr[4] = "GHI";
		arr[5] = "JKL";
		arr[6] = "MNO";
		arr[7] = "PQRS";
		arr[8] = "TUV";
		arr[9] = "XWYZ";
		System.out.println(solution(str));
	}
	private static int solution(String str) {
		int answer = 0;
		for(int i=0;i<str.length();++i) {
			String s = str.substring(i,i+1);
			int callNum = 3;
			for(int j=2;j<arr.length;++j) {
				if(arr[j].contains(s)) {
					callNum+=j-2;
					break;
				}
			}
			answer += callNum;
		}
		
		return answer;
	}

}
