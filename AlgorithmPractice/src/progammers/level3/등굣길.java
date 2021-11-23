package progammers.level3;


public class µî±·±æ {
	public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for(int[] xy: puddles) {
        	int x = xy[0] - 1;
        	int y = xy[1] - 1;
        	map[y][x] = -1;
        }
        map[0][0] = 1;
        for(int i=0;i<n;++i) {
        	for(int j=0;j<m;++j) {
            	if(map[i][j] == -1) {
            		map[i][j] = 0;
            		continue;
            	}
            	if(i != 0 ) {
                    map[i][j] += map[i - 1][j] % 1000000007;
            	} 
            	if(j != 0) {
            		map[i][j] += map[i][j-1] % 1000000007;
            	}
            }	
        }
        return map[n-1][m-1] % 1000000007;
    }
	
	public static void main(String[] args) {
		int[][] map = {{2,2}};
		System.out.println(solution(4,3,map));
	}

}
