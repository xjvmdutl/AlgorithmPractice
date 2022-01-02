package progammers.level3;

public class 공이동시뮬레이션 {
	public static int[] reverseDir = {1,0,3,2};
	public static int[] dir = {-1,1,-1,1};
	public static long solution(int n, int m, int x, int y, int[][] queries) {
        int[] point = {y,y+1,x,x+1};
        int[] limit = {m,m,n,n};
        int[] boundary = {0,m,0,n};
        for(int i=queries.length-1;i>=0;--i) {
        	int command = queries[i][0];
        	int dx = queries[i][1];
        	int reverse = reverseDir[command];  
        	point[reverse] += dir[reverse] * dx;
        	point[reverse] = Math.max(Math.min(point[reverse], limit[reverse]), 0);
        	
        	//현재 위치가 벽에 부딫히지 않을때
        	if(point[command] != boundary[command]) {
        		point[command] += dir[reverse] * dx;
            	point[command] = Math.max(Math.min(point[command], limit[command]), 0);
        	}
        	//경계를 벗어났을때
        	if(point[0] == m || point[1] == 0 || point[2] == n || point[3] == 0) {
        		return 0L;
        	}
        }
        return (1L * point[1] - point[0]) * (1L * point[3] - point[2]);
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
