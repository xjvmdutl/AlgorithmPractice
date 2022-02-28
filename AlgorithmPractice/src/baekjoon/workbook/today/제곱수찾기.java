package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

public class Á¦°ö¼öÃ£±â {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<m;++j) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}	
		}
		System.out.println(solution(map, n, m));
	}

	private static int solution(int[][] map, int n, int m) {
		int answer = -1;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				for(int x=-n;x<=n;++x) {
					for(int y=-m;y<=m;++y) {
						if(x == 0 && y == 0) {
							continue;
						}
						int a = i;
						int b = j;
						int now = 0;
						while(a >= 0 && a < n 
								&& b >= 0 && b < m) {
							now *= 10;
							now += map[a][b];
	                        if (isSqureNumber(now))
	                        	answer = Math.max(answer, now);
							a += x;
							b += y;
						}
					    if (isSqureNumber(now))
                        	answer = Math.max(answer, now);
					}	
				}
			}	
		}
		return answer;
	}

	private static boolean isSqureNumber(int now) {
		int variable= (int)Math.sqrt(now);
		return variable * variable == now;
	}

}
