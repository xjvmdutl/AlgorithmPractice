package progammers.level2.review;

public class Çà·ÄÀÇ°ö¼À {
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i=0;i<arr1.length;++i) {
        	for(int j=0;j<arr2[0].length;++j) {
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
		//arr1	arr2	return
		//[[1, 4], [3, 2], [4, 1]]	[[3, 3], [3, 3]]	[[15, 15], [15, 15], [15, 15]]
		//[[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		System.out.println(solution(arr1,arr2));
		int[][] arr3 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr4 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		System.out.println(solution(arr3,arr4));
		int[][] arr5 = {{1, 1}, {1, 1}, {1, 1}};
		int[][] arr6 = {{1, 1, 1}, {1, 1, 1}};
		System.out.println(solution(arr5,arr6));
	}

}
