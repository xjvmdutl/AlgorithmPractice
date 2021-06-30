package progammers.level1;

public class Çà·ÄÀÇµ¡¼À {
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = arr1;
        for(int i=0;i<arr2.length;++i){
            for(int j=0;j<arr2[i].length;++j){
                answer[i][j] += arr2[i][j];
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		int[][] arr1 = {{1},{2}};
		int[][] arr2 = {{3},{4}};
		int[][] arr3 = solution(arr1,arr2);
		
	}
}
