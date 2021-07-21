package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//이해 안감....
public class 공항 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(reader.readLine());
		int p = Integer.parseInt(reader.readLine());
		int[] arr = new int[p];
		for(int i=0;i<p;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(g,p,arr));
	}

	private static int solution(int g, int p, int[] arr) {
		int answer = 0;
		
		return answer;
	}

}
