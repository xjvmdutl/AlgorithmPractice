package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳 {
	public static String[] kroatiaLanguege = new String[8];
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		kroatiaLanguege[0] = "c=";
		kroatiaLanguege[1] = "c-";
		kroatiaLanguege[2] = "dz=";
		kroatiaLanguege[3] = "d-";
		kroatiaLanguege[4] = "lj";
		kroatiaLanguege[5] = "nj";
		kroatiaLanguege[6] = "s=";
		kroatiaLanguege[7] = "z=";
		System.out.println(solution(str));
	}

	private static int solution(String str) {
		int answer = 0;
		for(int i=0;i<kroatiaLanguege.length;++i) {
			if(str.contains(kroatiaLanguege[i])) {
				for(int j=0;j<=str.length()-kroatiaLanguege[i].length();++j) {
					String s = str.substring(j,kroatiaLanguege[i].length()+j);
					if(s.equals(kroatiaLanguege[i]))
						answer++;
				}
				str = str.replace(kroatiaLanguege[i],"*");
			}
		}
		answer += str.replace("*", "").length();
		return answer;
	}

}
