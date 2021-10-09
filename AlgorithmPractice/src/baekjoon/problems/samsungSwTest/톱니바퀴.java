package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Åé´Ï¹ÙÄû {
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[4][8];
		for(int i=0;i<4;++i) {
			String str = reader.readLine();
			for(int j=0;j<8;++j) {
				arr[i][j] = str.charAt(j) - '0'; 
			}
		}
		int k = Integer.parseInt(reader.readLine());
		int[][] oper = new int[k][2];
		for(int i=0;i<k;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			oper[i][0] = Integer.parseInt(tokens.nextToken());
			oper[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,oper,k));
	}

	private static int solution(int[][] arr, int[][] oper, int k) {
		int answer = 0;
		for(int i=0;i<k;++i) {
			int number = oper[i][0] -1;
			int dir = oper[i][1];
			visit = new boolean[4];
			
			Rotation(arr,number,dir);
		}
		for(int j=0;j<4;++j) {
			if(arr[j][0] == 1) {
				answer += Math.pow(2, j);
			}
		}
		return answer;
	}

	private static void Rotation(int[][] arr, int number, int dir) {
		if(visit[number])
			return;
		
		
		visit[number] = true;
		
		
		int nx = number+1;
		if(0 <= nx && nx < 4) {
			int current = arr[number][2];
			int next = arr[nx][6];
			if(current != next) {
				Rotation(arr, nx, dir*-1);
			}
		}
		int bx = number-1;
		if(0 <= bx && bx < 4) {
			int current = arr[number][6];
			int back = arr[bx][2];
			if(current != back) {
				Rotation(arr, bx, dir*-1);
			}
		}
		
		
		
		if(dir == 1) {
			int t = arr[number][7];
			for(int i=6;i>=0;--i) {
				arr[number][i+1] = arr[number][i];
			}
			arr[number][0] = t;
		}else {
			int t = arr[number][0];
			for(int i=1;i<8;++i) {
				arr[number][i-1] = arr[number][i];
			}
			arr[number][7] = t;
		}
		
	}
}
