package progammers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Print01{
	int number;
	int priority;
	public Print01(int number,int priority) {
		this.number = number;
		this.priority = priority;
	}
}
public class 프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int m = Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(reader.readLine());
			
			int[] arr = new int[n];
			for(int i=0;i<n;++i) {
				arr[i] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println(solution(arr,n,m));
		}
	}

	private static int solution(int[] arr, int n, int m) {
		Queue<Print01> que = new LinkedList<>();
		for(int i=0;i<n;++i) {
			que.offer(new Print01(i, arr[i]));
		}
		int answer = 0;
		OUTER:while(true) {
			Print01 p = que.poll();
			for(Print01 print : que) {
				if(print.priority >  p.priority) {
					que.offer(p);
					continue OUTER;
				}
			}
			answer++;
			//여기 까지 진행된건 우선순위가 큰게 없다는뜻
			if(p.number == m) {
				return answer;
			}
		}
	}

}
