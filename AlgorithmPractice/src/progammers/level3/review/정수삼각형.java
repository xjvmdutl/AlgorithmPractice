package progammers.level3.review;

import java.util.Arrays;

public class Á¤¼ö»ï°¢Çü {
	public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;++i) {
        	int[] arr = new int[triangle[i].length];
        	arr[0] = dp[i-1][0] + triangle[i][0];
        	for(int j=1;j<arr.length-1;++j) {
        		arr[j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
        	}
        	arr[arr.length-1] = dp[i-1][dp[i-1].length-1] + triangle[i][triangle[i].length-1];
        	dp[i] = arr;
        }
        return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
    }
	public static void main(String[] args) {
		//triangle	result
		//[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}
}
