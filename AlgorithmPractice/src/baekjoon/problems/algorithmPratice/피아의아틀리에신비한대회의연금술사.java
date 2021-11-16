package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class State{
	int eff;
	char ele;
	public State(int eff,char ele) {
		this.ele = ele;
		this.eff = eff;
	}
	public State() {
	}
}
public class 피아의아틀리에신비한대회의연금술사 {
	public static boolean[] visit;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		State[][][][] map = new State[n][4][4][4];
		for(int i=0;i<n;++i) {
			for(int j=0;j<4;++j) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				for(int k=0;k<4;++k) {
					map[i][0][j][k] = new State();
					map[i][0][j][k].eff = Integer.parseInt(tokens.nextToken());
				}
			}
			for(int j=0;j<4;++j) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				for(int k=0;k<4;++k) {
					map[i][0][j][k].ele = tokens.nextToken().charAt(0);
				}
			}
		}
		System.out.println(solution(map,n));
	}

	private static int solution(State[][][][] map, int n) {
		answer =Integer.MIN_VALUE;
		for(int i=0;i<n;++i) {
			for(int d=1;d<=3;++d) {
				rotation(map,i,d);
			}
		}
		visit = new boolean[n];
		State[][] result = init();
		permulate(map,n,0,result);
		return answer;
	}

	private static void permulate(State[][][][] map, int n, int cnt, State[][] result) {
		if(cnt == 3) {
			answer = Math.max(answer, calc(result));
			return;
		}
		for(int i=0;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				for(int j=0;j<=1;++j) {
					for(int k=0;k<=1;++k) {
						for(int d=0;d<4;++d) {
							State[][] tmpState = mix(map,result,i,d,j,k);
							permulate(map, n, cnt+1, tmpState);
						}
					}
				}
				visit[i] = false;
			}
		}
	}

	private static State[][] mix(State[][][][] map, State[][] tmp,int t,int d ,int row, int col) {
		State[][] result = new State[5][5];
		for(int i=0;i<5;++i) {
			for(int j=0;j<5;++j) {
				result[i][j] = new State(tmp[i][j].eff,tmp[i][j].ele);
			}	
		}
		for(int i=0;i<4;++i) {
			for(int j=0;j<4;++j) {
				result[i+row][j+col].eff += map[t][d][i][j].eff;
	            if(result[i+row][j+col].eff > 9) {
	            	result[i+row][j+col].eff = 9;
	            }else if(result[i+row][j+col].eff < 0) {
	            	result[i+row][j+col].eff = 0;
	            }
				
				if(map[t][d][i][j].ele != 'W') {
					result[i+row][j+col].ele = map[t][d][i][j].ele;
				}
			}	
		}
		
		return result;
	}

	private static int calc(State[][] result) {
		int r = 0;
		int b = 0;
		int g = 0;
		int y = 0;
		for(int i=0;i<5;++i) {
			for(int j=0;j<5;++j) {
				switch (result[i][j].ele) {
				case 'R':
					r += result[i][j].eff;
					break;
				case 'B':
					b += result[i][j].eff;
					break;
				case 'G':
					g += result[i][j].eff;
					break;
				case 'Y':
					y += result[i][j].eff;
					break;
				default:
					break;
				}
			}	
		}
		return (7*r) + (5*b) + (3*g) + (2*y);
	}

	private static State[][] init() {
		State[][] result = new State[5][5];
		for(int i=0;i<5;++i) {
			for(int j=0;j<5;++j) {
				result[i][j] = new State(0,'W');
			}	
		}
		return result;
	}

	private static void rotation(State[][][][] map, int t, int d) {
		for(int i=0;i<4;++i) {
			for(int j=0;j<4;++j) {
				map[t][d][i][j] = new State(map[t][d-1][3-j][i].eff, map[t][d-1][3-j][i].ele);
			}	
		}
	}


	

}
