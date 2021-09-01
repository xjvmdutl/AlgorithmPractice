package progammers.level2.review;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparable<Node>{
	int next;
	int weight;
	
	public Node(int next,int weight) {
		this.next = next;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}
public class ¹è´Þ {
	public static int[] distance;
	public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        distance = new int[N];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int[][] arr = new int[N][N];
        for(int i=0;i<road.length;++i) {
        	int s = road[i][0]-1;
        	int e = road[i][1]-1;
        	int w = road[i][2];
        	if(arr[s][e] > 0 && arr[s][e] < w) {
        		continue;
        	}
        	arr[s][e] = w;
        	arr[e][s] = w;
        }
        dijkstra(arr,K);
        for(int i=0;i<distance.length;++i) {
        	if(distance[i] > K) {
        		continue;
        	}
        	answer++;
        }
        return answer;
    }
	private static void dijkstra(int[][] road, int k) {
		Queue<Node> que = new PriorityQueue<>();
		distance[0] = 0;
		que.offer(new Node(0,0));
		while(!que.isEmpty()) {
			Node n = que.poll();
			for(int i=0;i<road[n.next].length;++i) {
				if(road[n.next][i] > 0) {
					if(distance[i] > road[n.next][i] + n.weight) {
						distance[i] = road[n.next][i] + n.weight;
						que.offer(new Node(i, distance[i]));
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//N	road	K	result
		//5	[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]	3	4
		//6	[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]	4	4
		int n1 = 5;
		int k1 = 3;
		int[][] road1 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		System.out.println(solution(n1,road1,k1));
		int n2 = 6;
		int k2 = 4;
		int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		System.out.println(solution(n2,road2,k2));
	}

}
