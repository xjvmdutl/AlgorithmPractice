package progammers.level3;

import java.util.ArrayList;
import java.util.List;

public class GPS {
	public static int answer;
	public static int cnt;
	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        answer = 0;
        cnt = 0;
        List<Integer>[] map = new ArrayList[n];
        for(int i=0;i<n;++i) {
        	map[i] = new ArrayList<>();
        }
        for(int[] edge : edge_list) {
        	int start = edge[0]-1;
        	int end = edge[1]-1;
        	map[start].add(end);
        	map[end].add(start);
        }
        dfs(map,n,0,gps_log);
        return answer;
    }
	private static void dfs(List<Integer>[] map, int n, int count, int[] gps_log) {
		if(count + 1 == gps_log.length) {
			return;
		}
		if(count < gps_log.length-1) {
			int now = gps_log[count];
			int next = gps_log[count+1];
			if(now == next) {
				cnt++;
				dfs(map, n, count+1, gps_log);
				return;
			}
		}
		boolean isOkay = false;
		for(int data : map[gps_log[count]]) {
			if(data == gps_log[count+1]) {
				isOkay = true;
				dfs(map, n, count+1, gps_log);
			}
		}
		if(!isOkay) {
			
		}
	}
	public static void main(String[] args) {
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		int[] gps_log = {1, 2, 3, 3, 6, 7};
		System.out.println(solution(7,10,edge_list,6,gps_log));
	}
}
