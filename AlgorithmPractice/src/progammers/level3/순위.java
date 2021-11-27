package progammers.level3;

public class ���� {
    public static int solution(int n, int[][] results) {
    	int answer = 0;
    	boolean[][] map = new boolean[n][n];
    	for(int i=0;i<results.length;++i) {
    		int start = results[i][0] - 1;
    		int end = results[i][1] - 1;
    		map[start][end] = true;
    	}
    	
    	for(int k=0;k<n;++k) {
    		for(int i=0;i<n;++i) {
    			for(int j=0;j<n;++j) {
        			if(map[i][k] && map[k][j]) {
        				map[i][j] = true;
        			}
        		}	
    		}
    	}
    	OUTER:for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(i == j)
					continue;
				if(map[i][j] == false && map[j][i] == false)
					continue OUTER;
    		}
			answer++;
		}
    	return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(5,results));
	}

}
