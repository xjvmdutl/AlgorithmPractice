package progammers.golevelkit;

import java.util.Arrays;

public class º∂ø¨∞·«œ±‚ {
	public static int[] parents;
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        for(int i=0;i<n;++i) {
        	parents[i] = i;
        }
        Arrays.sort(costs,(o1,o2)->{
        	return o1[2] - o2[2];
        });
        for(int i=0;i<costs.length;++i) {
        	int parent = findNode(costs[i][0]);
        	int child = findNode(costs[i][1]);
        	if(parent == child)
        		continue;
        	answer+=costs[i][2];
        	parents[parent] = child;
        }
        return answer;
    }
	
	private static int findNode(int node) {
		if(parents[node] == node) return node;
		return parents[node] = findNode(parents[node]);
	}

	public static void main(String[] args) {
		//n	costs	return
		//4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(4,costs));
	}

}
