package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 삼각형만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = -1;
		int[] reverseSort = Arrays.stream(arr).boxed().sorted((o1,o2)-> o2- o1).mapToInt(Integer::intValue).toArray();
		for(int i=2;i<reverseSort.length;++i) {
			int a = reverseSort[i-2];
			int b = reverseSort[i-1];
			int c = reverseSort[i];
			if(isTriangle(a, b, c))
				return a+b+c;
		}
		return answer;
	}
	 public static boolean isTriangle(int a, int b, int c) {
        if (a < b + c) {
            return true;
        }
        return false;
    }
}
