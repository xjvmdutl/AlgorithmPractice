package progammers.weekly;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기 {
	public static boolean[] visit;
	public static int answer;
	
    public static int solution(int n, int[][] wires) {
        answer = n;
        int[][] map = new int[n][n];
        for(int i=0;i<wires.length;++i){
            int start = wires[i][0]-1;
            int end = wires[i][1]-1;
            map[start][end] = 1;
            map[end][start] = 1;
        }
        
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    map[j][i] = 0;
                    find(map,n);
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
        }
        return answer;
    }
    private static void find(int[][] map, int n){
    	visit = new boolean[n];
    	int n1 = bfs(map, n, 0);
    	int n2 = n - n1;
    	answer = Math.min(answer, Math.abs(n1 - n2));
    }
	
	private static int bfs(int[][] map, int n, int start) {
		Queue<Integer> que = new LinkedList<>();
		visit[start] = true;
		int count = 0;
		que.offer(start);
		while(!que.isEmpty()) {
			int now = que.poll();
			count++;
			for(int i=0;i<n;++i) {
				if(!visit[i] && map[now][i] == 1) {
					visit[i] = true;
					que.offer(i);
				}
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		//n	wires	result
		//9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
		//4	[[1,2],[2,3],[3,4]]	0
		//7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	1
		int[][] wires1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		System.out.println(solution(9,wires1));
		int[][] wires2 = {{1,2},{2,3},{3,4}};
		System.out.println(solution(4,wires2));
		int[][] wires3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
		System.out.println(solution(7,wires3));
	}

}
