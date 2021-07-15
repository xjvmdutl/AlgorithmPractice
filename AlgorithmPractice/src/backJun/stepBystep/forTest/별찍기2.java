package backJun.stepBystep.forTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class º°Âï±â2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;++i) {
			for(int j=n;j>i;--j) {
				sb.append(" ");	
			}
			for(int j=1;j<=i;++j) {
				sb.append("*");	
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
