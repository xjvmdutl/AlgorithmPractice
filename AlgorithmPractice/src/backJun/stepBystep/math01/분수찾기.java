package backJun.stepBystep.math01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(reader.readLine());
		System.out.println(solution(x));
	}

	private static String solution(int x) {
		int n = 0;
		int sum =0;
		while(sum < x ) {
			n++;
			sum+=n;
		}
		sum -= n;
		StringBuilder sb= new StringBuilder();
		for(int i=1;i<=n;++i) {
			sum++;
			if(sum == x) {
				if(n % 2 == 1) {
					sb.append((n+1-i) + "/" + i);
					break;
				}else {
					sb.append(i + "/" + (n+1-i));
					break;
				}
			}
		}
		
		return sb.toString();
	}

}
