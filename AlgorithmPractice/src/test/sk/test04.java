package test.sk;

public class test04 {
	private static final int INF = 300001;
	public static long solution(int n, int[][] edges) {
        long answer = 0;
        int[][] map = new int[n][n];
        for(int i=0;i<edges.length;++i) {
        	int start = edges[i][0] ;
        	int end = edges[i][1];
        	map[start][end] = 1;
        	map[end][start] = 1;
        }
      
        for(int k=0;k<n;++k) {
	        for(int i=0;i<n;++i) {
	        	for(int j=0;j<n;++j) {
	        		if(i != j && j != k && k != i && map[i][j] == 0) {
	        			map[i][j] = map[i][k] + map[k][j];
	        		}
	            }	
	        }
        }
        for(int i=0;i<n;++i) {
        	for(int j=0;j<n;++j) {
        		if(map[i][j] > 0 && map[i][j] != INF)
        			answer++;
            }	
        }
        return answer;
    }
	public static void main(String[] args) {
		/*
		 * n edges result
		 * 5 [[0,1],[0,2],[1,3],[1,4]] 16 
		 * 4 [[2,3],[0,1],[1,2]] 8
		 */
		int[][] edges1 = {{0,1},{0,2},{1,3},{1,4}};
		System.out.println(solution(5,edges1));
		
		int[][] edges2 = {{2,3},{0,1},{1,2}};
		System.out.println(solution(4,edges2));
	}

}
