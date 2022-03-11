package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 피리부는사나이 {
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map, n, m));
	}

	private static int solution(char[][] map, int n, int m) {
		parents = new int[n * m];
		for(int i=0;i<parents.length;++i) {
			parents[i] = i;
		}
		
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				int currentIdx = (m * i) + j;
				int nextIdx = nextIndex(map, i, j, n, m);
				if(find(currentIdx) != find(nextIdx)) {
					union(currentIdx, nextIdx);
				}
			}	
		}
		int answer = findSaveZone();
		return answer;
	}

	private static int findSaveZone() {
		Set<Integer> set = new HashSet<>();
		for(int now : parents) {
			set.add(now);
		}
		return set.size();
	}

	private static void union(int currentIdx, int nextIdx) {
		currentIdx = find(currentIdx);
		nextIdx = find(nextIdx);
		if(currentIdx > nextIdx) {
			parents[currentIdx] = nextIdx;
		}else {
			parents[nextIdx] = currentIdx;
		}
	}

	private static int find(int node) {
		if(node == parents[node]) {
			return node;
		}
		return parents[node] = find(parents[node]);
	}

	private static int nextIndex(char[][] map, int y, int x, int n, int m) {
		int dir = getDir(map[y][x]);
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		return (ny * m) + nx;
	}

	private static int getDir(char c) {
		int dir = -1;
		if(c == 'U') {
			dir = 0;
		}else if(c == 'D') {
			dir = 1;
		}else if(c == 'L') {
			dir = 2;
		}else if(c == 'R') {
			dir = 3;
		}
		return dir;
	}

}
