package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한조서열정리하고옴ㅋㅋ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] str = reader.readLine().split(" ");
		int[] arr=new int[str.length];
		for(int i=0;i<str.length;++i)
			arr[i]= Integer.parseInt(str[i]);
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int count = 0;
		int currentData = arr[0];
		int maxCount =0;
		for(int i =1;i<arr.length;++i) {
			if(currentData < arr[i]) {
				count = 0;
				currentData = arr[i];
				continue;
			}
			count++;
			maxCount = Math.max(maxCount, count);
			
		}
		return maxCount;
	}

}
