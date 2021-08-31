package progammers.level2.review;

public class 행렬테두리회전하기 {
	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = init(rows,columns);
        for(int i=0;i<queries.length;++i) {
        	int startRow = queries[i][0]-1;
        	int startCol = queries[i][1]-1;
        	int endRow = queries[i][2]-1;
        	int endCol = queries[i][3]-1;
        	int shortNumber = Integer.MAX_VALUE;
        	int lastCol = arr[startRow][endCol];
        	
        	for(int idx = endCol; idx > startCol ;--idx) {
        		arr[startRow][idx] = arr[startRow][idx-1];
        		shortNumber = Math.min(shortNumber, arr[startRow][idx]);
        	}
        	int lastRow;
        	for(int jdx = startRow+1; jdx <= endRow ;++jdx) {
        		lastRow = arr[jdx][endCol];
        		arr[jdx][endCol] = lastCol;
        		lastCol = lastRow;
        		shortNumber = Math.min(shortNumber, arr[jdx][endCol]);
        	}
        	for(int idx = endCol-1; idx >= startCol ;--idx) {
        		lastRow = arr[endRow][idx];
        		arr[endRow][idx] = lastCol;
        		lastCol = lastRow;
        		shortNumber = Math.min(shortNumber, arr[endRow][idx]);
        	}
        	
        	for(int jdx = endRow-1; jdx >= startRow ;--jdx) {
        		lastRow = arr[jdx][startCol];
        		arr[jdx][startCol] = lastCol;
        		lastCol = lastRow;
        		shortNumber = Math.min(shortNumber, arr[jdx][startCol]);
        	}
        	answer[i] = shortNumber;
        }
        return answer;
    }
	private static int[][] init(int rows, int columns) {
		int s = 1;
		int[][] arr = new int[rows][columns];
		for(int i=0;i<rows;++i) {
			for(int j=0;j<columns;++j) {
				arr[i][j] = s++; 
			}	
		}
		return arr;
	}
	public static void main(String[] args) {
		//rows	columns	queries	result
		//6		6		[[2,2,5,4],[3,3,6,6],[5,1,6,3]]	[8, 10, 25]
		//3		3		[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
		//100	97		[[1,1,100,97]]	[1]
		int rows1 = 6;
		int columns1 = 6;
		int[][] queries1 = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(solution(rows1,columns1,queries1));
		int rows2 = 3;
		int columns2 = 3;
		int[][] queries2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		System.out.println(solution(rows2,columns2,queries2));
		int rows3 = 100;
		int columns3 = 97;
		int[][] queries3 = {{1,1,100,97}};
		System.out.println(solution(rows3,columns3,queries3));
	}

}
