package backJun.stepBystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 네번째점 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[3][2];
		for(int i=0;i<3;++i) {
			String[] str = reader.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		System.out.println(solution(arr));
	}

	private static String solution(int[][] arr) {
		StringBuilder sb= new StringBuilder();
		Map<Integer,Integer> mapX = new HashMap<>();
		Map<Integer,Integer> mapY = new HashMap<>();
		for(int i=0;i<3;++i) {
			int x = arr[i][0];
			int y = arr[i][1];
			mapX.put(x, mapX.getOrDefault(x, 0)+1);
			mapY.put(y, mapY.getOrDefault(y, 0)+1);
		}
		for(int n : mapX.keySet())
			if(mapX.get(n) == 1)
				sb.append(n + "\n");
		for(int n : mapY.keySet())
			if(mapY.get(n) == 1)
				sb.append(n);
		return sb.toString();
	}

}
