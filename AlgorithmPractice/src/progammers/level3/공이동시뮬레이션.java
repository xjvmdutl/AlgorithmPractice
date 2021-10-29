package progammers.level3;

public class 공이동시뮬레이션 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = 0;
        m(queries);
        for(int i=0;i<n;++i) {
        	for(int j=0;j<m;++j) {
        		
        		
        		
        		if(move(queries,x,y,n,m,i,j)) {
        			answer++;
        		}
        	}
        }
        return answer;
	}
	private static void m(int[][] queries) {
		int startX = 0;
		int startY = 0;
		for(int i=0;i<queries.length;++i) {
			int nx = startX + (dx[queries[i][0]] * queries[i][1]);
			int ny = startY + (dy[queries[i][0]] * queries[i][1]);		
			startX = nx;
			startY = ny;
		}
		System.out.println();
	}
	private static boolean move(int[][] queries, int x, int y, int n, int m, int i, int j) {
		
		return false;
	}
	/*
	private static boolean move(int[][] queries, int y, int x, int n, int m, int startY, int startX) {
		for(int i=0;i<queries.length;++i) {
			int nx = startX + (dx[queries[i][0]] * queries[i][1]);
			int ny = startY + (dy[queries[i][0]] * queries[i][1]);		
			if(!isRange(nx,ny,n,m)) {
				if(queries[i][0] == 0) {
					nx = 0;
				}else if(queries[i][0] == 1) {
					nx = m-1;
				}else if(queries[i][0] == 2) {
					ny = 0;
				}else if(queries[i][0] == 3) {
					ny = n-1;
				}
			}
			startX = nx;
			startY = ny;
		}
		if(startX == x && startY == y)
			return true;
		else
			return false;
	}
	*/
	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
		
	}
	public static void main(String[] args) {
		//n	m	x	y	queries	result
		//2	2	0	0	[[2,1],[0,1],[1,1],[0,1],[2,1]]	4
		//2	5	0	1	[[3,1],[2,2],[1,1],[2,3],[0,1],[2,1]]	2
		int n1 = 2;
		int m1 = 2;
		int x1 = 0;
		int y1 = 0;
		int[][] queries1 = {{2,1},{0,1},{1,1},{0,1},{2,1}};
		System.out.println(solution(n1,m1,x1,y1,queries1));
		int n2 = 2;
		int m2 = 5;
		int x2 = 0;
		int y2 = 1;
		int[][] queries2 = {{3,1},{2,2},{1,1},{2,3},{0,1},{2,1}};
		System.out.println(solution(n2,m2,x2,y2,queries2));
	}

}
