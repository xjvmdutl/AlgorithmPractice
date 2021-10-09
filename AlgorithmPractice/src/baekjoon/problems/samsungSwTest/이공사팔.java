package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Block{
	int[][] map;
	int count;
	public Block(int[][] map,int count) {
		this.count = count;
		this.map = map;
	}
}
public class ÀÌ°ø»çÆÈ {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n));
	}

	private static int solution(int[][] map, int n) {
		int answer = 0;
		answer = bfs(map,n);
		return answer;
	}

	private static int bfs(int[][] map, int n) {
		Queue<Block> que = new LinkedList<>();
		int count = 0;
		que.offer(new Block(map, 0));
		while(!que.isEmpty()) {
			Block b = que.poll();
			if(b.count > 5) {
				break;
			}
			for(int i=0;i<4;++i) {
				int[][] now = new int[n][n];
				for(int j=0;j<n;++j) {
					for(int k=0;k<n;++k) {
						now[j][k] = b.map[j][k];
					}
				}
				move(now,n,i);
				que.offer(new Block(now, b.count+1));
			}
			
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					count = Math.max(b.map[i][j],count);
				}
			}
		}
		return count;
	}

	private static void move(int[][] map, int n, int dir) {
		switch(dir) {
		case 0://ÁÂÃø
			for(int i=0;i<n;++i) {
				int index = 0;
				int block = 0;
				for(int j = 0; j < n; ++j) {
					if(map[i][j] != 0) {
						if(block == map[i][j]) {
							map[i][index - 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						}else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index++;
						}
					}
				}
			}
			break;
		case 1://¿ìÃø
			for(int i=0;i<n;++i) {
				int index = n-1;
				int block = 0;
				for(int j = n-1; j >= 0; --j) {
					if(map[i][j] != 0) {
						if(block == map[i][j]) {
							map[i][index + 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						}else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index--;
						}
					}
				}
			}
			break;
		case 2://ÇÏ
			for(int i=0;i<n;++i) {
				int index = n - 1;
				int block = 0;
				for(int j = n-1; j >= 0; --j) {
					if(map[j][i] != 0) {
						if(block == map[j][i]) {
							map[index + 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						}else {
							block = map[j][i];
							map[j][i] = 0;
							map[index][i] = block;
							index--;
						}
					}
				}
			}
			break;
		case 3://»ó
			for(int i = 0; i < n; i++) {
                int index = 0;
                int block = 0;
                for(int j = 0; j < n; j++) {
                    if(map[j][i] != 0) {
                        if(block == map[j][i]) {
                            map[index - 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        }
                        else {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index++;
                        }
                    }
                }
            }
			break;
		}
	}
}
