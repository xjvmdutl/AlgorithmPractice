package test.gabia;

public class test6 {
	public static int answer;
	public static int[][] map;
	public static int solution(int[][] grid, int K) {
        answer = 0;
        int n = grid.length;
        int[][] sum = new int[n+1][n+1];
        for(int i=0;i<n;++i) {
        	for(int j=0;j<n;++j) {
            	sum[i+1][j+1] = grid[i][j] + sum[i+1][j];
            }	
        }
        
    	for(int j=0;j<n;++j) {
    		for(int i=0;i<n;++i) {
            	sum[i+1][j+1] += sum[i][j+1];
    		}	
        }
    	map = new int[n-K + 1][n-K + 1];
        for(int i=0;i<n-K+1;++i) {
        	for(int j=0;j<n-K+1;++j) {
        		find(grid, sum, i, j, n, K);
            }	
        }
        for(int i=0;i<n-K+1;++i) {
        	for(int j=0;j<n-K+1;++j) {
        		selectOne(i, j, n, K);
            }	
        }
        return answer;
    }
	private static void selectOne(int y, int x, int n, int k) {
      //¿·¶óÀÎ
	  int max = y+k < map.length ? y+k : map.length;
      for(int i=y;i< max ;++i) {
         for(int j=x+k;j<=n-k;++j) {
            answer = Math.max(answer, map[y][x] + map[i][j]);
         }
      }
      //¹Ø¿¡¶óÀÎ
       for(int i=y+k;i<n-k +1;++i) {
           for(int j=0;j<n-k+1;++j) {
               answer = Math.max(answer, map[y][x] + map[i][j]);
            }   
        }
   }
	
	private static void find(int[][] grid, int[][] sum, int y, int x, int n, int k) {
		int sum1 = sum[y+k][x+k] - sum[y][x+k] - sum[y+k][x] + sum[y][x];
		map[y][x] = sum1;
	}
	public static void main(String[] args) {
		//[[3, 4, 5], [2, 3, 4], [1, 2, 3]]
		int[][] grid1 = {{3, 4, 5}, {2, 3, 4}, {1, 2, 3}};
		int k1 = 1;
		//System.out.println(solution(grid1, k1));
		
		//[[2, 1, 1, 0, 1], [1, 2, 0, 3, 0], [0, 1, 5, 1, 2], [0, 0, 1, 3, 1], [1, 2, 0, 1, 1]]
		int[][] grid2 = {{2, 1, 1, 0, 1}, {1, 2, 0, 3, 0}, {0, 1, 5, 1, 2}, {0, 0, 1, 3, 1}, {1, 2, 0, 1, 1}};
		int k2 = 2;
		System.out.println(solution(grid2, k2));
		
	}

}
