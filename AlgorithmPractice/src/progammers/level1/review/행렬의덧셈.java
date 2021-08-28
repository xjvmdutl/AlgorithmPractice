package progammers.level1.review;

public class Çà·ÄÀÇµ¡¼À {
	 public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i=0;i<arr1.length;++i) {
        	for(int j=0;j<arr1[i].length;++j) {
        		answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		//arr1	arr2	return
		//[[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
		//[[1],[2]]	[[3],[4]]	[[4],[6]]
		int[][] arr1 = {{1,2},{2,3}};
		int[][] arr2 = {{3,4},{5,6}};
		System.out.println(solution(arr1,arr2));
		int[][] arr3 = {{1},{2}};
		int[][] arr4 = {{3},{4}};
		System.out.println(solution(arr3,arr4));
	}

}
