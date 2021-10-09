package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkiCourseDesign {

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
		int answer = 99999999;
		for(int i=0;i<=100-17;++i){
            int tmpAns = 0;
            for(int j=0;j<n;++j){
                if(arr[j] < i)
                    tmpAns += (i - arr[j]) * ( i - arr[j]);
                if(arr[j] > i + 17)
                    tmpAns += (arr[j]-i-17) * ( arr[j]-i-17);
            }
            answer = Math.min(answer,tmpAns);
        }
		return answer;
	}

}
