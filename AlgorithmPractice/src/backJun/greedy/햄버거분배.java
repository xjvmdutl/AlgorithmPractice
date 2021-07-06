package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ÇÜ¹ö°ÅºÐ¹è {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		String s = reader.readLine();
		System.out.println(solution(n,k,s));
	}

	private static int solution(int n, int k, String str) {
		int answer = 0;
		int idx = 0;
		
		boolean[] isEat = new boolean[str.length()];
		for(int i =0;i<str.length();++i) {
			char c = str.charAt(i);
			if(c == 'H') {
				continue;
			}else {
				int startIdx = i-k < 0 ? 0 : i-k;
				int endIdx = i+k < str.length() ? i+k : str.length()-1;
				for(int j=startIdx;j<=endIdx;++j) {
					if(!isEat[j] && str.charAt(j) == 'H') {
						isEat[j] = true;
						answer++;
						break;
					}
				}
			}
			
		}
		return answer;
	}

}
