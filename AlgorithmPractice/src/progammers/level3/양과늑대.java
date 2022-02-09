package progammers.level3;

import java.util.ArrayList;
import java.util.List;

public class ¾ç°ú´Á´ë {
	public static boolean[][][] visit;
	public static int answer;
	public static List<Integer>[] map;
	public static int solution(int[] info, int[][] edges) {
        int N = info.length;
        answer = -1;
        visit = new boolean[N][N+1][N+1];
        map = new ArrayList[N];
        for(int i=0;i<N;++i)
        	map[i] = new ArrayList<>();
        for(int i=0;i<edges.length;++i) {
        	int start = edges[i][0];
        	int end = edges[i][1];
        	map[start].add(end);
        	map[end].add(start);
        }
        visit[0][0][0] = true;
        dfs(info,0,0,0);
        return answer;
    }
	private static void dfs(int[] info, int idx, int sheep, int wolf) {
		int tmp = -1;
		if(info[idx] != -1) {
			if(info[idx] == 0) {
				//¾ç
				tmp = 0;
				sheep++;
			}else {
				//´Á´ë
				tmp =1;
				wolf++;
			}
		}
		if(sheep <= wolf)
			return;
		else
			answer = Math.max(sheep, answer);
		for(int i=0;i<map[idx].size();++i) {
			int next = map[idx].get(i);
			if(!visit[next][sheep][wolf]) {
				info[idx] = -1;
				visit[idx][sheep][wolf] = true;
				dfs(info, next, sheep, wolf);
				info[idx] = tmp;
				visit[idx][sheep][wolf] = false;
			}
		}
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//info	edges	result
		//[0,0,1,1,1,0,1,0,1,0,1,1]	[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]	5
		int[] info1 = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges1 = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		System.out.println(solution(info1,edges1));
		int[] info2 = {0,1,0,1,1,0,1,0,0,1,0};
		int[][] edges2 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
		System.out.println(solution(info2,edges2));
		int[] info3 = {0,1,0};
		int[][] edges3 = {{0,1},{0,2}};
		System.out.println(solution(info3,edges3));
	}

}
