package progammers.level2;

public class Çà·ÄÀÇ°ö¼À {
	 public static int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int[][] answer = new int[row][col];
        for(int i=0;i<arr1.length;++i) {
        	for(int j = 0;j<col;++j) {
        		int sum = 0;
	        	for(int k=0;k<arr1[i].length;++k) {
	        		sum += arr1[i][k] * arr2[k][j]; 
	        	}
	        	answer[i][j] = sum;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		int[][] a={{1, 4}, {3, 2}, {4, 1}};
		int[][] b = {{3, 3}, {3, 3}};
		int[][] c = solution(a, b);
		for(int i=0;i<c.length;++i) {
			for(int j=0;j<c[i].length;++j)
				System.out.print(c[i][j]+ " ");
			System.out.println();
		}
	}

     
}
