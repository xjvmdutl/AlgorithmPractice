package progammers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class Puzzle implements Comparable<Puzzle>{
	int x;
	int y;
	char c;
	int count;
	int dir;
	public Puzzle(int x,int y,char c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
	public Puzzle(int x,int y,int dir,int count) {
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
public class 리틀프렌즈사천성 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static List<Puzzle> list;
	public static String solution(int m, int n, String[] board) {
        StringBuilder answer = new StringBuilder();
        char[][] map = new char[m][n];
        for(int i=0;i<m;++i) {
        	map[i] = board[i].toCharArray();
        }
        list = new ArrayList<>();
        initArrayList(map,m,n);
        for(int i = 0;i<list.size();i+=2) {
        	Puzzle p1 = list.get(i);
        	Puzzle p2 = list.get(i+1);
        	if(canRemove(map,m,n,p1,p2)) {
        		answer.append(p1.c);
        		list.remove(i);
        		list.remove(i);
        		map[p1.y][p1.x] = '.';
        		map[p2.y][p2.x] = '.';
        		i = -2;
        		continue;
        	}
        }
        return list.size() == 0 ? answer.toString() : "IMPOSSIBLE";
    }
	private static boolean canRemove(char[][] map, int m, int n, Puzzle p1, Puzzle p2) {
		if(p1.x == p2.x) {//직선상
			for(int i=p1.y+1;i<=p2.y-1;++i) {
				if(map[i][p1.x] != '.') {
					return false;
				}
			}
			return true;
		}else if(p1.y == p2.y) {
			for(int i=p1.x+1;i<=p2.x-1;++i) {
				if(map[p1.y][i] != '.') {
					return false;
				}
			}
			return true;
		}else {
			if(bfs(map,p1,p2,m,n)) {
				return true;
			}else {
				return false;
			}
		}
		
	}
	private static boolean bfs(char[][] map, Puzzle p1, Puzzle p2, int m, int n) {
		Queue<Puzzle> que = new PriorityQueue<>();
		que.offer(new Puzzle(p1.x, p1.y, 0, 0));
		que.offer(new Puzzle(p1.x, p1.y, 1, 0));
		que.offer(new Puzzle(p1.x, p1.y, 2, 0));
		que.offer(new Puzzle(p1.x, p1.y, 3, 0));
		while(!que.isEmpty()) {
			Puzzle p = que.poll();
			if(p.count >= 2) {
				continue;
			}
			for(int i=0;i<4;++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int count = p.count;
				if(p.dir != i) {
					count++;
				}
				if(isRange(nx,ny,m,n) && count < 2) {
					if(map[ny][nx] == '.') {
						que.offer(new Puzzle(nx, ny,i,count));
					}else if(nx == p2.x && ny == p2.y) {
						return true;
					}
				}
			}
		}
		return false;
	}
	private static boolean isRange(int nx, int ny, int m, int n) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}
	private static void initArrayList(char[][] map, int m, int n) {
		for(int i=0;i<m;++i) {
			for(int j=0;j<n;++j) {
				if(Character.isUpperCase(map[i][j])) {
					list.add(new Puzzle(j, i, map[i][j]));
				}
			}
		}
		Collections.sort(list,(o1,o2)->{
			if(o1.c == o2.c) {
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}
			return o1.c - o2.c;
		});;
	}
	
	public static void main(String[] args) {
		String[] board1 = {"DBA", "C*A", "CDB"};
		System.out.println(solution(3,3,board1));
		String[] board2 = {"NRYN", "ARYA"};
		System.out.println(solution(2,4,board2));
		String[] board3 = {".ZI.", "M.**", "MZU.", ".IU."};
		System.out.println(solution(4,4,board3));
		String[] board4 = {"AB", "BA"};
		System.out.println(solution(2,2,board4));
	}
	 
}
