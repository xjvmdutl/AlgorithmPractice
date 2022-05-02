package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 기차가어둠을헤치고은하수를 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[m][3];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			if(tokens.hasMoreElements()) {
				arr[i][2] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr, n, m));
	}

	private static int solution(int[][] arr, int n, int m) {
		boolean[][] map = new boolean[n][20];
		for(int i=0;i<m;++i) {
			int index = arr[i][1] - 1;
			operation(map[index], arr[i]);
		}
		return counting(map, n);
	}

	

	private static void operation(boolean[] map, int[] arr) {
		int oper = arr[0];
		switch (oper) {
		case 1:
			int rideIndex = arr[2] - 1;
			operFirst(map, rideIndex);
			break;
		case 2:
			int takeOffIndex = arr[2] - 1;
			operSecond(map, takeOffIndex);
			break;
		case 3:
			operThird(map);
			break;
		case 4:
			operFourth(map);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	private static void operFirst(boolean[] map, int rideIndex) {
		map[rideIndex] = true;
	}
	
	private static void operSecond(boolean[] map, int takeOffIndex) {
		map[takeOffIndex] = false;
	}
	
	private static void operThird(boolean[] map) {
		for(int i=map.length-1;i>0;--i) {
			map[i] = map[i-1];
		}
		map[0] = false;
	}
	
	private static void operFourth(boolean[] map) {
		for(int i=0;i<map.length-1;++i) {
			map[i] = map[i+1];
		}
		map[map.length-1] = false;
	}
	
	private static int counting(boolean[][] map, int n) {
		Set<String> set = new HashSet<>();
		int count = 0;
		for(int i=0;i<n;++i) {
			String answer = getValue(map[i]);
			if(!set.contains(answer)) {
				set.add(answer);
				count++;
			}
		}
		return count;
	}

	private static String getValue(boolean[] data) {
		StringBuilder answer = new StringBuilder();
		for(int j=0;j<data.length;++j) {
			if(data[j]) {
				answer.append(j + " ");
			}
		}
		return answer.toString();
	}

	private static Set<Integer>[] getMap(int n) {
		Set<Integer>[] map =  new HashSet[n];
		for(int i=0;i<n;++i) {
			map[i] = new HashSet<>();
		}		
		return map;
	}

}
