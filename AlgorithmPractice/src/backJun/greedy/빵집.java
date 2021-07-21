package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class »§Áý {
    public static char[][] map;
    public static int count = 0;
    public static boolean find = false;
    public static int[] dx = {1,1,1};
    public static int[] dy = {-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int r = Integer.parseInt(strs[0]);
		int c = Integer.parseInt(strs[1]);
		map = new char[r][c];
        for(int i=0;i<r;++i){
            map[i] = reader.readLine().toCharArray();
        }
		System.out.println(solution(r,c));
	}
    
	private static int solution(int r, int c) {
		count = 0;
		for(int i=0;i<r;++i){
            find = false;
            dfs(0,i,r,c);
        }
		
		return count;
	}
    
    private static void dfs(int x,int y,int r,int c){
        if(x == c - 1){
            count++;
            find = true;
            return;
        }
        for(int i=0;i<3;++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= ny && ny < r && 0 <= nx && nx < c) {
               if(map[ny][nx] == '.'){
                   map[y][x] = 'x';
                   dfs(nx,ny,r,c);
                   if(find){
                       return;
                       
                   }
               }
            }
        }
    }
	
}
/*
public class »§Áý {
	public static int[] dx = {1,1,1};
	public static int[] dy = {-1,0,1};
	public static char[][] map;
	public static int count;
	public static boolean goal = false;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int r = Integer.parseInt(strs[0]);
		int c = Integer.parseInt(strs[1]);
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(r,c));
	}

	private static int solution(int r, int c) {
		count = 0;
		for(int i=0;i<r;++i) {
			goal = false;
			dfs(i,0,r,c);
		}
		
		return count;
	}

	private static void dfs(int row, int col, int r, int c) {
		if(col == c - 1) {
			count++;
			goal = true;
			return;
		}
		for(int i=0;i<3;++i) {
			int nextRow = row + dy[i];
			int nextCol = col + dx[i];

			if(0 <= nextRow && nextRow < r && 0 <= nextCol && nextCol < c) {
				if(map[nextRow][nextCol] == '.') {
					map[row][col] = 'x';
					dfs(nextRow,nextCol,r,c);
					if(goal)
						return;
				}
			}
		}
	}

}
*/
