package progammers.level3;
public class 보행자천국 {
	static int MOD = 20170805;
	public static int[][][] visit;
	public static int solution(int m, int n, int[][] cityMap) {
        visit = new int[m+1][n+1][2];
        visit[1][1][0] = 1;
        visit[1][1][1] = 1;
        for(int i=1;i<=m;++i) {
        	for(int j=1;j<=n;++j) {
        		if(cityMap[i-1][j-1] == 0) {
        			visit[i][j][0] += (visit[i-1][j][0] + visit[i][j-1][1] ) % MOD;
        			visit[i][j][1] += (visit[i-1][j][0] + visit[i][j-1][1] ) % MOD;
        		}else if(cityMap[i-1][j-1] == 1) {
        			visit[i][j][0] = 0;
        			visit[i][j][1] = 0;
        		}else {
        			visit[i][j][0] += visit[i - 1][j][0];
        			visit[i][j][1] += visit[i][j - 1][1];
        		}
        	}
        }
        return visit[m][n][0];
    }
	public static void main(String[] args) {
		//m	n	city_map	answer
		//3	3	[[0, 0, 0], [0, 0, 0], [0, 0, 0]]	6
		//3	6	[[0, 2, 0, 0, 0, 2], [0, 0, 2, 0, 1, 0], [1, 0, 0, 2, 2, 0]]	2
		int m1 = 3;
		int n1 = 3;
		int[][] city_map1 = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(m1,n1,city_map1));
		int m2 = 3;
		int n2 = 6;
		int[][] city_map2 = {{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}};
		System.out.println(solution(m2,n2,city_map2));
	}

}
