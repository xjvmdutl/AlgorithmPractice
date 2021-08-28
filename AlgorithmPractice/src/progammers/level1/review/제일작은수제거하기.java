package progammers.level1.review;

import java.util.Arrays;

public class 제일작은수제거하기 {
	public static int[] solution(int[] arr) {
		
        if(arr.length-1 == 0) {
        	int[] answer = {-1};
        	return answer;
        }
        int n = Arrays.stream(arr).min().getAsInt();
        int[] answer = Arrays.stream(arr).filter((o1)->o1!=n).toArray();
        return answer;
    }
	public static void main(String[] args) {
		int[] arr1 = {4,3,2,1};
		System.out.println(solution(arr1));
		int[] arr2= {10};
		System.out.println(solution(arr2));
	}

}
