package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 색종이붙이기 {
	public static int[] paper = {5,5,5,5,5};
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[10][10];
		for(int i=0;i<10;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<10;++j) {
				map[i][j]= Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map));
	}

	private static int solution(int[][] map) {
		answer = Integer.MAX_VALUE;
		backTracking(map, 0, 0, 0);
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	private static void backTracking(int[][] map, int x, int y, int count) {
        if (x >= 9 && y > 9) {
            answer = Math.min(count, answer);
            return;
        }
 
        if (answer <= count) {
            return;
        }
 
		
		if(y > 9) {
			backTracking(map, x+1, 0, count);
			return;
		}
		
		
		if(map[x][y] == 1) {
			for(int i=4;i>=0;--i) {
				if(paper[i] > 0 && isAttach(map, x, y, i)) {
					attach(map, x, y, i, 0);
					paper[i]--;
					backTracking(map, x, y+1, count+1);
					paper[i]++;
					attach(map, x, y, i, 1);
				}
			}
		}else {
			backTracking(map, x, y + 1, count);
		}
		
	}

	private static void attach(int[][] map, int x, int y, int size, int att) {
		for(int i=x;i<=x+size;++i) {
			for(int j=y;j<=y+size;++j) {
				map[i][j] = att;
			}	
		}
	}

	private static boolean isAttach(int[][] map, int x, int y, int size) {
		int nx = x + size;
		int ny = y + size;
		if(isRange(nx, ny)) {
			for(int i=x;i<=x+size;++i) {
				for(int j=y;j<=y+size;++j) {
					if(map[i][j] == 0)
						return false;
				}	
			}
			return true;
		}else {
			return false;	
		}
	}

	private static boolean isRange(int nx, int ny) {
		return 0 <= nx && nx < 10 && 0 <= ny && ny < 10;
	}

}
