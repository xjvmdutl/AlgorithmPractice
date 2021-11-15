package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ¿ùµåÄÅ {
	public static boolean isOkay;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = new String[4]; 
		for(int i=0;i<4;++i) {
			str[i] =reader.readLine();
		}
				
				
		System.out.println(solution(str));
	}

	private static String solution(String[] strs) {
		StringBuilder sb = new StringBuilder();
		int size = 0;
		for(int i = 1; i < 6; i++) {
			size += i;
		}
		int[][] matches = new int[size][2];
		int index = 0;
		for(int i = 0; i < 6 - 1; i++) {
			for(int j = i + 1; j < 6; j++) {
				matches[index][0] = i;
				matches[index][1] = j;
				index++;
			}
		}
		OUTER:for(String str : strs) {
			isOkay = false;
			StringTokenizer tokens = new StringTokenizer(str);
			int[][] worldCup = new int[6][3]; 
			for(int i=0;i<6;++i) {
				int win = Integer.parseInt(tokens.nextToken());
				int draw = Integer.parseInt(tokens.nextToken());
				int lose = Integer.parseInt(tokens.nextToken());
				worldCup[i][0] = win;
				worldCup[i][1] = draw;
				worldCup[i][2] = lose;
				if(win + draw + lose != 5) {
					sb.append(0 + " ");
					continue OUTER;
				}
			}
			BackTracking(worldCup,matches,0,size);
			if(isOkay) {
				sb.append(1 + " ");
			}else {
				sb.append(0 + " ");
			}
		}
		return sb.toString();
	}

	private static void BackTracking(int[][] worldCup, int[][] matches, int count, int size) {
		if(isOkay) {
			return;
		}
		if(count == size) {
			isOkay = true;
			return;
		}
		int myTeam = matches[count][0];
		int enemyTeam = matches[count][1];
		if(worldCup[myTeam][0] > 0 && worldCup[enemyTeam][2] > 0) {
			worldCup[myTeam][0]--;
			worldCup[enemyTeam][2]--;
			BackTracking(worldCup,matches,count+1,size);
			worldCup[myTeam][0]++;
			worldCup[enemyTeam][2]++;		
		}
		if(worldCup[myTeam][1] > 0 && worldCup[enemyTeam][1] > 0) {
			worldCup[myTeam][1]--;
			worldCup[enemyTeam][1]--;
			BackTracking(worldCup,matches,count+1,size);
			worldCup[myTeam][1]++;
			worldCup[enemyTeam][1]++;	
		}
		if(worldCup[myTeam][2] > 0 && worldCup[enemyTeam][0] > 0) {
			worldCup[myTeam][2]--;
			worldCup[enemyTeam][0]--;
			BackTracking(worldCup,matches,count+1,size);
			worldCup[myTeam][2]++;
			worldCup[enemyTeam][0]++;	
		}
	}

}
