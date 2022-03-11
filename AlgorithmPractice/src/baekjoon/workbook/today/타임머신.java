package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class TimeMachine{
	int now;
	int weight;
	public TimeMachine(int now, int weigth) {
		this.now = now;
		this.weight = weigth;
	}
}
public class 타임머신 {
	private static final int INF = 2 * 500 * 100000;
	public static long[] dis;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		List<TimeMachine>[] map = new ArrayList[n];
		for(int i=0;i<n;++i)
			map[i] = new ArrayList<>();
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			int k = Integer.parseInt(tokens.nextToken());
			map[start].add(new TimeMachine(end, k));
		}
		System.out.println(solution(map, n, m));
		
	}

	private static String solution(List<TimeMachine>[] map, int n, int m) {
		dis = new long[n];
		Arrays.fill(dis, INF);
		dis[0] = 0;
		if(belmafold(map, n, m)) {
			return "-1";
		}else {
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<n;++i) {
				if(dis[i] == INF)
					sb.append("-1" + "\n");
				else
					sb.append(dis[i] + "\n");
			}
			return sb.toString();
		}
	}

	private static boolean belmafold(List<TimeMachine>[] map, int n, int m) {
		boolean update = false;
		for(int i=0;i<n;++i) {
			update = false;
			for(int j=0;j<n;++j) {
				for(TimeMachine next : map[j]) {
					if (dis[j] == INF) {
	                    break;
	                }
					if(dis[next.now] > dis[j] + next.weight) {
						dis[next.now] = dis[j] + next.weight;
						update = true;
					}
				}
			}
			if(!update)
				break;
		}
		if (update) {	
			for(int i=0;i<n;++i) {
				if(dis[i] == INF) {
					continue;
				}
				for(TimeMachine next : map[i]) {
					if(dis[next.now] > dis[i] + next.weight) {
						return true;
					}
				}
			}
        }
		return false;
	}

}
