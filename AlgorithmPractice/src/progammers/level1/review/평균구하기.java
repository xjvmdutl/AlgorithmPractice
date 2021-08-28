package progammers.level1.review;

import java.util.Arrays;

public class Æò±Õ±¸ÇÏ±â {
	public static double solution(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        return (double)sum/arr.length;
    }
	public static void main(String[] args) {
		//arr	return
		//[1,2,3,4]	2.5
		//[5,5]	5
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {5,5};
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
	}

}
