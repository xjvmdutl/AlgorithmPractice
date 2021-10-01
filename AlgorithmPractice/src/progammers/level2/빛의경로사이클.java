package progammers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 빛의경로사이클 {
	public static boolean[][][] visit;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,-1,0,1};
	public static int[] solution(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        visit = new boolean[n][m][4];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;++i) {
        	for(int j=0;j<m;++j) {
        		for(int k=0;k<4;++k) {
        			if(!visit[i][j][k]) {
        				list.add(bfs(grid,i,j,k,n,m));
        			}
        		}
        	}
        }
        int[] answer= new int[list.size()];
        Collections.sort(list);
        for(int i=0;i<list.size();++i) {
        	answer[i] =list.get(i);
        }
        
        return answer;
    }
	private static int bfs(String[] grid, int i, int j, int k, int n, int m) {
		int result = 0;
		while(true) {
			if(visit[i][j][k]) {
				break;
			}
			result++;
			visit[i][j][k] = true;
			char c = grid[i].charAt(j);
			if(c == 'L') {
				k = k == 0 ? 3 : k - 1;
			}else if(c == 'R') {
				k = k == 3 ? 0 : k + 1;
			}
			
			i = (i + dx[k] + n) % n;
			j = (j + dy[k] + m) % m;
		}
		
		
		return result;
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
