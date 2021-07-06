package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 오셀로재배치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			String str1 = reader.readLine();
			String str2 = reader.readLine();
			System.out.println(solution(n,str1,str2));
		}
	}

	private static int solution(int n, String str1, String str2) {
		
		int wcount = 0;
		int bcount = 0;
		
		for(int i=0;i<str1.length();++i) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if(c1 != c2) {
				if(c2 == 'W')
					wcount++;
				else
					bcount++;
			}
		}
		int answer = Math.min(wcount, bcount);
		int l = Math.max(wcount, bcount) - answer;
		
		return answer+l;
	}

}
