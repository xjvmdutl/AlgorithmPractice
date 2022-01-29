package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

enum Move{
	LEFT, RIGHT
}
public class 소가길을건너간이유1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] arr = new int[N][2];
		for(int i=0;i<N;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, N));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		Map<Integer,Move> map = new HashMap<>();
		for(int i=0;i<arr.length;++i) {
			if(map.containsKey(arr[i][0])) {
				if(map.get(arr[i][0]) == Move.LEFT 
						&& arr[i][1] == 1) {
					map.put(arr[i][0], Move.RIGHT);
					answer++;
				}else if(map.get(arr[i][0]) == Move.RIGHT 
						&& arr[i][1] == 0){
					map.put(arr[i][0], Move.LEFT);
					answer++;
				}
			}else {
				map.put(arr[i][0], arr[i][1] == 0 ? Move.LEFT : Move.RIGHT);
			}
		}
		return answer;
	}

}
