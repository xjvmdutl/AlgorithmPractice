package kakaoPay;

public class Test2 {
	public static int[] solution(int rows,int columns,int[][] swipes) {
		int[] answer = new int[swipes.length];
		int[][] data = new int[rows][columns];
		init(data);
		int idx = 0;
		for(int[] arr : swipes) {
			int mode = arr[0];
			int startRow = arr[1]-1;
			int endRow = arr[3]-1;
			int startCol = arr[2]-1;
			int endCol = arr[4]-1;
			if(mode == 1) {
				int sum = 0;
				for(int i=startCol;i<=endCol;++i) {
					int tmp = data[endRow][i];
					for(int j=endRow;j>startRow;--j) {
						data[j][i] = data[j-1][i];
					}
					data[startRow][i] = tmp;
					sum += tmp;
				}
				answer[idx++] = sum;
			}else if(mode == 2) {
				int sum = 0;
				for(int i=startCol;i<=endCol;++i) {
					int tmp = data[startRow][i];
					for(int j=startRow;j<endRow;++j) {
						data[j][i] = data[j+1][i];
					}
					data[endRow][i] = tmp;
					sum += tmp;
				}
				answer[idx++] = sum;
			}else if(mode == 3) {
				int sum = 0;
				for(int i=startRow;i<=endRow;++i) {
					int tmp = data[i][endCol];
					for(int j=endCol;j>startCol;--j) {
						data[i][j] = data[i][j-1];
					}
					data[i][startCol] = tmp;
					sum += tmp;
				}
				answer[idx++] = sum;
			}else if(mode == 4) {
				int sum = 0;
				for(int i=startRow;i<=endRow;++i) {
					int tmp = data[i][startCol];
					for(int j=startCol;j<endCol;++j) {
						data[i][j] = data[i][j+1];
					}
					data[i][endCol] = tmp;
					sum += tmp;
				}
				answer[idx++] = sum;
			}
		}
		return answer;
	}
	private static void init(int[][] data) {
		int cnt = 1;
		for(int i =0;i<data.length;++i) 
			for(int j=0;j<data[0].length;++j)
				data[i][j] = cnt++;
	}
	public static void main(String[] args) {
		int[][] swipes = {{1,1,2,4,3},{3,2,1,2,3},{4,1,1,4,3},{2,2,1,3,3}};
		int[] reasult = solution(4,3,swipes);
		
		
	}

}
