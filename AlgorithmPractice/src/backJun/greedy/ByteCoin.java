package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteCoin {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		long w = Long.parseLong(strs[1]);
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(n,w,arr));
	}

	private static long solution(int n, long w, int[] arr) {
		long answer = 0;
		for(int i=0;i<n-1;++i) {
			if(arr[i] < arr[i+1]) {//´ÙÀ½³¯ ¿Ã¶ú¾î
				if(w>=arr[i]) {
					answer += w/arr[i];
					w %= arr[i];
				}
			}else if(arr[i]> arr[i+1]) {//¶³¾îÁü
				w += answer * arr[i];
				answer = 0;
			}
		}
		w += answer * arr[n-1];
		return w;
	}
	
}
