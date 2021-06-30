package progammers.level2;

public class 행렬테두리회전하기 {
	/*
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] arrays = new int[rows][columns];
		int num =1;
		for(int i=0;i<arrays.length;++i) {
			for(int j=0;j<arrays[i].length;++j) {
				arrays[i][j] = num++; 
			}
		}
		for(int k=0;k<queries.length;++k) {
			int startRows = queries[k][0]-1;
			int startCols = queries[k][1]-1;
			int endRows = queries[k][2]-1;
			int endCols = queries[k][3]-1;
			int tmp = arrays[startRows][startCols];
			int i = startRows;
			int j = startCols+1;
			int min = arrays[startRows][startCols];
			while(i!=startRows || j != startCols) {
				if(min > tmp) {
					min = tmp;
				}
				if(i == startRows) {//우	
					tmp = swap(i,j,tmp,arrays);
					if(j == endCols) {
						i++;
						continue;
					}
					j++;
				}else if(j == endCols) {//하
					tmp = swap(i,j,tmp,arrays);
					if(i == endRows) {
						j--;
						continue;
					}
					i++;
				}else if(i == endRows) {//좌
					tmp = swap(i,j,tmp,arrays);
					if(j == startCols) {
						i--;
						continue;
					}
					j--;
				}else if(j == startCols) {//상
					tmp = swap(i,j,tmp,arrays);
					i--;
				}
				
				
			}
			swap(i,j,tmp,arrays);
			answer[k]=min;
		}
		
        return answer;
	}
	public static int swap(int i,int j,int tmp, int[][] arrays) {
		int data = arrays[i][j];
		arrays[i][j] = tmp;
		return data;
	}
	*/
	 public static int[] solution(int rows, int columns, int[][] queries) {
	        int[] ans = new int[queries.length];
	        int[][] map = createMap(rows, columns);
	        int qLen = queries.length;
	        for (int i = 0; i < qLen; i++) {
	            ans[i] = rotate(map, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
	        }
	        
	        return ans;
	    }
	    
    private static int rotate(int[][] map, int x1, int y1, int x2, int y2) {

        int temp = map[x1][y1];
        int min = temp;

        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }

        for (int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i + 1];
            min = Math.min(min, map[x2][i]);
        }

        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }

        for (int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(min, map[x1][i]);
        }
        map[x1][y1 + 1] = temp;

        return min;
    }
	    
    private static int[][] createMap(int r, int c) {
        int[][] map = new int[r+1][c+1];
        int cnt = 1;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                map[i][j] = cnt++;
            }
        }
        return map;
    }
	public static void main(String[] args) {
		
//		rows	columns	queries	result
//		6	6	[[2,2,5,4],[3,3,6,6],[5,1,6,3]]	[8, 10, 25]
//		3	3	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
//		100	97	[[1,1,100,97]]	[1]
		int rows1 = 6;
		int rows2 = 3;
		int rows3 = 100;
		int colums1 = 6;
		int colums2 = 3;
		int colums3 = 100;
		int[][] queries1 = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[][] queries2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		int[][] queries3 = {{1,1,100,97}};
		int[] result1 = solution(rows1, colums1, queries1);
		for(int i : result1)
			System.out.print(i+" ");
		System.out.println();
		int[] result2 = solution(rows2, colums2, queries2);
		for(int i : result2)
			System.out.print(i+" ");
		System.out.println();
		int[] result3 = solution(rows3, colums3, queries3);
		for(int i : result3)
			System.out.print(i+" ");
		System.out.println();
		
	}

}
