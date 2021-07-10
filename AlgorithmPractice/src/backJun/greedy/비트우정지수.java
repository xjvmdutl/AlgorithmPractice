package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비트우정지수 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			String[] strs = reader.readLine().split(" ");
			System.out.println(solution(strs));
			
		}
	}

	private static int solution(String[] strs) {
		int answer = 0;
		String str1 = strs[0];
		String str2 = strs[1];
		int oneCount =0;
		int zeroCount =0;
		for(int i=0;i<str1.length();++i) {
			if(str1.charAt(i) != str2.charAt(i)) {
				if(str1.charAt(i) == '1') oneCount++;
				else zeroCount++;
			}
		}
		answer += Math.max(zeroCount,oneCount);
		
		return answer;
	}
}
