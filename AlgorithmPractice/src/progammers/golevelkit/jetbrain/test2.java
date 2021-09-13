package progammers.golevelkit.jetbrain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Point{
	int x;
	int y;
	int g;
	public Point(int x,int y,int g) {
		this.x = x;
		this.y = y;
		this.g = g;
	}
	
}
public class test2 {
	public static boolean[][][] visit;
	public static HashSet<List<Point>> set;
	public static List<Integer> result;
	public static int[] solution(String[] grid) {
        int[] answer = {};
        result = new ArrayList<>();
        set = new HashSet<>();
        char[][] arr = new char[grid.length][grid[0].length()];
        for(int i=0;i<grid.length;++i) {
        	arr[i] = grid[i].toCharArray();
        }
        visit = new boolean[grid.length][grid[0].length()][4];
        for(int i=0;i<4;++i) {
        	List<Point> list = new ArrayList<>();
        	dfs(0,0,i,arr,0,list,i);	
        }
        answer  = new int[result.size()];
        for(int i=0;i<result.size();++i) {
        	answer[i] =result.get(i);
        }
        return answer;
    }
	private static void dfs(int x, int y, int v, char[][] arr, int count ,List<Point> list,int startv) {
		if(visit[0][0][startv] && x == 0 && y == 0 && v == startv) {
			Collections.sort(list,(o1,o2)->{
				if(o1.x == o2.x) {
					if(o1.y == o2.y) {
						return o1.g - o2.g;
					}
					return o1.y -o2.y;
				}
				return o1.x - o2.x;
			});
			if(list.size() <1)
				return;
			for(List<Point> l : set) {
				Collections.sort(l,(o1,o2)->{
					if(o1.x == o2.x) {
						if(o1.y == o2.y) {
							return o1.g - o2.g;
						}
						return o1.y -o2.y;
					}
					return o1.x - o2.x;
				});
				if(list.size() == l.size()) {
					int cnt = 0;
					for(int i=0;i<l.size();++i) {
						Point p1 = l.get(i);
						Point p2 = list.get(i);
						if(p1.x == p2.x && p1.y == p2.y && p1.g == p2.g)
							cnt++;
					}
					if(cnt == list.size()) {
						return;
					}
				}
			}
			set.add(list);
			result.add(count);
			return;
		}
		
		if(!visit[y][x][v]) {
			visit[y][x][v] = true;
			list.add(new Point(x, y, v));
			if(arr[y][x] == 'S') {
				if(v == 0) {
					dfs((x+1)%arr[0].length, y, v, arr, count+1, list,startv);
				}else if(v == 1) {
					x--;
					if(x < 0) {
						x = arr[0].length-1;
					}
					dfs(x, y, v, arr, count+1, list,startv);
				}else if(v == 2) {
					dfs(x, (y+1)%arr.length, v, arr, count+1, list,startv);
				}else if(v == 3) {
					y--;
					if(y < 0) {
						y = arr.length-1;
					}
					dfs(x, y, v, arr, count+1, list,startv);
				}
			}else if(arr[y][x] == 'L') {
				if(v == 0) {
					y--;
					if(y < 0) {
						y = arr.length-1;
					}
					dfs(x, y, 3, arr, count+1, list,startv);
				}else if(v == 1) {
					dfs(x, (y+1)%arr.length, 2, arr, count+1, list,startv);
				}else if(v == 2) {
					dfs((x+1)%arr[0].length, y, 0, arr, count+1, list,startv);
				}else if(v == 3) {
					x--;
					if(x < 0) {
						x = arr[0].length-1;
					}
					dfs(x, y, 1, arr, count+1, list,startv);
				}
			}else if(arr[y][x] == 'R') {
				if(v == 0) {
					dfs(x, (y+1)%arr.length, 2, arr, count+1, list,startv);
				}else if(v == 1) {
					y--;
					if(y < 0) {
						y = arr.length-1;
					}
					dfs(x, y, 3, arr, count+1, list,startv);
				}else if(v == 2) {
					x--;
					if(x < 0) {
						x = arr[0].length-1;
					}
					dfs(x, y, 1, arr, count+1, list,startv);
				}else if(v == 3) {
					dfs((x+1)%arr[0].length, y, 0, arr, count+1, list,startv);
					
				}
			}
			visit[y][x][v] = false;
		}
	}
	public static void main(String[] args) {
		//grid	result
		//["SL","LR"]	[16]
		//["S"]	[1,1,1,1]
		//["R","R"]	[4,4]
		String[] grid1 = {"SL","LR"};
		System.out.println(solution(grid1));
		String[] grid2 = {"S"};
		System.out.println(solution(grid2));
		String[] grid3 = {"R","R"};
		System.out.println(solution(grid3));
	}

}
