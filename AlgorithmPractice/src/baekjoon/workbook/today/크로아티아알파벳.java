package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static int solution(String str) {
		String[] kro = {"c=" , "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		for(int i=0;i<kro.length;++i) {
			str = str.replaceAll(kro[i], String.valueOf(i));
		}
		return str.length();
	}

}
