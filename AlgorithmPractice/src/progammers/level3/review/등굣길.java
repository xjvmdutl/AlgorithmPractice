package progammers.level3.review;

public class µî±·±æ {
	private static final int MAX = 1000000007;
	public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[m+1][n+1];
       
        for(int i=0;i<puddles.length;++i) {
        	map[puddles[i][0]][puddles[i][1]] = -1;
        }
        map[1][1] = 1;
        for(int i=1;i<=m;++i) {
        	for(int j=1;j<=n;++j) {
        		if(map[i][j] == -1) {
        			map[i][j] = 0;
        			continue;
        		}
            	map[i][j] += (map[i][j-1] + map[i-1][j]) % MAX;
            }	
        }
        return map[m][n];
    }
	public static void main(String[] args) {
		//m	n	puddles	return
		//4	3	[[2, 2]]	4
		int[][] puddles = {{2,2}};
		System.out.println(solution(4,3,puddles));
	}

}
