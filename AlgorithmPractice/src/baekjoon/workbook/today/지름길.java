package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class Shortcut{
	int start;
	int end;
	int length;
	public Shortcut(int start, int end, int length) {
		this.end = end;
		this.start = start;
		this.length = length;
	}
}
public class Áö¸§±æ {
	private static final int INF = 10001;
	public static int[] dis;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int d = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][3];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			arr[i][2] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, d));
	}

	private static int solution(int[][] arr, int n, int d) {
		List<Shortcut> list = new ArrayList<>();
		Arrays.sort(arr, (o1, o2)->{
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		
		for(int i=0;i<n;++i) {
			if(arr[i][1] > d) {
				continue;
			} 
			if(arr[i][1] - arr[i][0] <= arr[i][2]) {
				continue;
			}
			list.add(new Shortcut(arr[i][0], arr[i][1], arr[i][2]));
		}
		
		dilk(list, n, d);
		
		return dis[d];
	}

	private static void dilk(List<Shortcut> list, int n, int d) {
		dis = new int[d+1];
		Arrays.fill(dis, INF);
		int move = 0;
		int idx = 0;
		dis[0] = 0;
		while(move < d) {
			if(idx < list.size()) {
				Shortcut s = list.get(idx);
				if(s.start == move) {
					dis[s.end] = Math.min(dis[move] + s.length, dis[s.end]);
					idx++;
				}else {
					dis[move+1] = Math.min(dis[move + 1], dis[move] + 1);
					move++;
				}
			}else {
				dis[move+1] = Math.min(dis[move + 1], dis[move] + 1);
				move++;
			}
		}
	}

}
