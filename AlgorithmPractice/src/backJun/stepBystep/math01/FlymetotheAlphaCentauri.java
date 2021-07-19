package backJun.stepBystep.math01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlymetotheAlphaCentauri {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			String[] strs = reader.readLine().split(" ");
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			System.out.println(solution(x,y));
		}
	}

	private static int solution(int x, int y) {
		int answer = 1;//마지막은 반드시 1만 이동해야되서
		int distance = y-x;
		int max = (int)Math.sqrt(distance);
		if(max == Math.sqrt(distance))
			answer = 2*max -1;
		else if(distance <= max * max +max)
			answer = 2*max;
		else
			answer = 2*max+1;
		return answer;
	}

}
