package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class ¸ÔÀ»°ÍÀÎ°¡¸ÔÈú°ÍÀÎ°¡ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int m = Integer.parseInt(tokens.nextToken());
			int[] a = new int[n];
			tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<n;++i) {
				a[i] = Integer.parseInt(tokens.nextToken());
			}
			int[] b = new int[m];
			tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<m;++i) {
				b[i] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println(solution(a,b,n,m));
		}
	}

	private static int solution(int[] a, int[] b, int n, int m) {
		Arrays.sort(a);
		Arrays.sort(b);
		int answer = 0;
		for(int i=0;i<a.length;++i) {
			for(int j=0;j<b.length;++j) {
				if(a[i] <= b[j]) {
					break;
				}else {
					answer++;
				}
			}
			
		}
		return answer;
	}

}
