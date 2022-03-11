package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class OhMinSik{
	int start;
	int end;
	int weight;
	public OhMinSik(int start,int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
public class ¿À¹Î½ÄÀÇ°í¹Î {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int start = Integer.parseInt(tokens.nextToken()) ;
		int end=  Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		OhMinSik[] arr = new OhMinSik[m];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			arr[i] = new OhMinSik(s, e, w);
		}
		long[] profit = new long[n];
		tokens = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) 
			profit[i] = Long.parseLong(tokens.nextToken());
		System.out.println(solution(arr, profit, n, start, end, m));
		
	}

	private static String solution(OhMinSik[] arr, long[] profit, int n, int start, int end, int m) {
		long[] money = new long[n];
		Arrays.fill(money, Long.MIN_VALUE);
		money[start] = profit[start];
		for(int i=0; i < n + 100;++i) {
			for(OhMinSik ohMinSik : arr) {
				if(money[ohMinSik.start] == Long.MIN_VALUE)
					continue;
				else if(money[ohMinSik.start] == Long.MAX_VALUE)
					money[ohMinSik.end] = Long.MAX_VALUE;
				else if(money[ohMinSik.end] < money[ohMinSik.start] + profit[ohMinSik.end] - ohMinSik.weight){
                    money[ohMinSik.end] = money[ohMinSik.start] + profit[ohMinSik.end] - ohMinSik.weight;
                    if(i >= n-1)
                    	money[ohMinSik.end] = Long.MAX_VALUE;
                }
			}
		}
		
        if(money[end] == Long.MIN_VALUE) 
        	return "gg";
        else if(money[end] == Long.MAX_VALUE) 
        	return "Gee";
        else 
        	return String.valueOf(money[end]);
		
	}

}
