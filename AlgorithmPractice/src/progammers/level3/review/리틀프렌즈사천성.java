package progammers.level3.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class ¸®Æ²ÇÁ·»Áî»çÃµ¼º {
	static class Puzzle implements Comparable<Puzzle>{
		int x;
		int y;
		int dir;
		int count;//²ªÀº È½¼ö
		public Puzzle(int x,int y, int dir, int count) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}
		@Override
		public int compareTo(Puzzle o) {
			return this.count - o.count;
		}
	}
	static class Friends{
		int x;
		int y;
		char c;
		public Friends(int x,int y,char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	public static List<Friends> list;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static String solution(int m, int n, String[] board) {
        StringBuilder answer = new StringBuilder();
        char[][] map = new char[m][n];
        list = new ArrayList<>();
        for(int i=0;i<board.length;++i) {
        	map[i] = board[i].toCharArray();
        }
        initList(map,m,n);
        for(int i=0;i<list.size();i += 2) {
        	Friends f1 = list.get(i);
        	Friends f2 = list.get(i+1);
        	if(canRemove(map,f1,f2,m,n)) {
        		answer.append(list.get(i).c);
        		list.remove(i);
        		list.remove(i);
        		map[f1.y][f1.x] = '.';
        		map[f2.y][f2.x] = '.';
        		i = -2;
        	}
        }
        return list.size() == 0 ? answer.toString() : "IMPOSSIBLE";
    }
	private static boolean canRemove(char[][] map, Friends f1, Friends f2, int m, int n) {
		Queue<Puzzle> que = new PriorityQueue<>();
		que.offer(new Puzzle(f1.x, f1.y, 0, 0));
		que.offer(new Puzzle(f1.x, f1.y, 1, 0));
		que.offer(new Puzzle(f1.x, f1.y, 2, 0));
		que.offer(new Puzzle(f1.x, f1.y, 3, 0));
		while(!que.isEmpty()) {
			Puzzle p = que.poll();
			if(p.count >= 2)
				return false;
			
			for(int i=0;i<4;++i) {
				int nx = dx[i] + p.x;
				int ny = dy[i] + p.y;
				if(isRange(nx,ny,m,n) && p.count < 2) {
					int count = p.dir == i ? p.count : p.count+1;
					if(ny == f2.y && nx == f2.x && count < 2) {
						return true;
					}
					if(map[ny][nx] == '.') {
						que.offer(new Puzzle(nx, ny, i, count));
					} 
				}
				
			}
		}
		return false;
	}
	private static boolean isRange(int nx, int ny, int m, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < m;
	}
	private static void initList(char[][] map, int m, int n) {
		for(int i=0; i<m; ++i) {
			for(int j=0; j<n; ++j) {
				if(Character.isUpperCase(map[i][j])) {
					list.add(new Friends(j, i, map[i][j]));
				}
			}
		}
		Collections.sort(list,(o1,o2)->{
			return o1.c - o2.c;
		});
	}
	public static void main(String[] args) {
		/**
			m	n	board	answer
			3	3	["DBA", "C*A", "CDB"]	"ABCD"
			2	4	["NRYN", "ARYA"]	"RYAN"
			4	4	[".ZI.", "M.**", "MZU.", ".IU."]	"MUZI"
			2	2	["AB", "BA"]	"IMPOSSIBLE"
		
		int m1 = 3;
		int n1 = 3;
		String[] board1 = {"DBA", "C*A", "CDB"};
		System.out.println(solution(m1,n1,board1));
		int m2 = 2;
		int n2 = 4;
		String[] board2 = {"NRYN", "ARYA"};
		System.out.println(solution(m2,n2,board2));
		int m3 = 4;
		int n3 = 4;
		String[] board3 = {".ZI.", "M.**", "MZU.", ".IU."};
		System.out.println(solution(m3,n3,board3));
		int m4 = 2;
		int n4 = 2;
		String[] board4 = {"AB", "BA"};
		System.out.println(solution(m4,n4,board4));
		*/
		/**
		2 2 ["ZA", "ZA"] "AZ"
		1 2 ["AA"] "A"
		3 3 ["A.B", "B.A", "C.C"] "IMPOSSIBLE"
		3 3 ["AZA", "BZB", "**"] "ZAB"
		1 8 ["ABC.CBA"] "CBA"
		6 1 ["A", "B", "E", "E", "B", "A"] "EBA"
		4 4 ["A..C", "..CB", "B...", "...A"] "BAC"
		3 3 ["CCB", "A.B", "AEE"] "ABCE"
		10 10 ["M...M...DU", "....AR...R", "...E..OH.H", ".....O...", ".E..A..Q..", "Q...LL.*.", ".D.N.....U", "GT.T...F..", "....FKS...", "GN....K..S"] "AEFGHKLMDOQRSTNU"
		 */
		int m1 = 2;
		int n1 = 2;
		String[] board1 = {"ZA", "ZA"};
		System.out.println(solution(m1,n1,board1));
		int m2 = 1;
		int n2 = 2;
		String[] board2 = {"AA"};
		System.out.println(solution(m2,n2,board2));
		int m3 = 3;
		int n3 = 3;
		String[] board3 = {"A.B", "B.A", "C.C"};
		System.out.println(solution(m3,n3,board3));
	}
}
