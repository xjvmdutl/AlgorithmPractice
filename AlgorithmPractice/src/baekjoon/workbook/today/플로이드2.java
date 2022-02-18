package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 플로이드2 {
	private static final int MAX_VAL = 10000001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		int[][] dis = new int[n][n];
		int[][] map = new int[n][n];
		init(map, dis, n);
		for(int i=0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken()) - 1;
			int b = Integer.parseInt(tokens.nextToken()) - 1;
			int c = Integer.parseInt(tokens.nextToken());
			map[a][b] = Math.min(map[a][b], c);
			dis[a][b] = a;
		}
		System.out.println(solution(map, dis, n, m));
	}

	private static void init(int[][] map, int[][] dis, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				dis[i][j] = MAX_VAL;
				if (i != j)
					map[i][j] = MAX_VAL;			
			}
		}
	}

	private static String solution(int[][] map,int[][] dis, int n, int m) {
		floydWalshal(map, dis, n);
		StringBuilder sb = new StringBuilder();
		printFloyd(map, sb, n);
		printDis(map, dis, sb, n);
		return sb.toString();
	}

	private static void printDis(int[][] map, int[][] dis, StringBuilder sb, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] == MAX_VAL || i == j) {
					sb.append(0 + "\n");
				}else {
					Stack<Integer> stack = new Stack<>();
					int pre = j;
					stack.push(j);
					while(i != dis[i][pre]) {
						pre = dis[i][pre];
						stack.push(pre);
					}
					sb.append((stack.size() + 1) + " ");
					sb.append((i+1) + " ");
					while(!stack.isEmpty()) {
						sb.append((stack.pop() + 1) + " ");
					}
					sb.append("\n");
				}
			}	
		}
	}

	private static void printFloyd(int[][] map, StringBuilder sb, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] == MAX_VAL || i == j) {
					sb.append(0 + " ");
				}else {
					sb.append(map[i][j] + " ");
				}
			}	
			sb.append("\n");
		}
	}

	private static void floydWalshal(int[][] map, int[][] dis, int n) {
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						dis[i][j] = dis[k][j];
						map[i][j] = map[i][k] + map[k][j];
					}
				}	
			}	
		}
	}
	

}
