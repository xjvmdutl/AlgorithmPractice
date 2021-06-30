package progammers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int to, weight;
    
    Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

	@Override
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}
    
  
}
public class ¹è´Þ {
	static PriorityQueue<Edge> pq;
	static ArrayList<ArrayList<Edge>> adj;
    static int[] dist;
    
	public static int solution(int N, int[][] road, int K) {
        
		int answer = 0;
	        
        pq = new PriorityQueue<>();
        adj = new ArrayList<>();
        dist = new int[N + 1];
	        
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    
	    for(int i = 0 ; i <= N ; ++i) {
	    	adj.add(new ArrayList<>());
	    }
	    
        for(int i = 0 ; i < road.length ; ++i){
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
            
            adj.get(from).add(new Edge(to, weight));
            adj.get(to).add(new Edge(from, weight));
        }
	        
	    dist[1] = 0;
	    pq.offer(new Edge(1, 0));
	        
	    dijkstra();
	        
        for(int distance : dist){
            if(distance <= K) answer++;
        }
        
        return answer;


	}
	
	private static void dijkstra() {
		// TODO Auto-generated method stub
		 while(!pq.isEmpty()){
            Edge e = pq.poll();
            
            for(Edge ne : adj.get(e.to)){
                if(dist[ne.to] > dist[e.to] + ne.weight){
                    dist[ne.to] = dist[e.to] + ne.weight;
                    pq.offer(ne);
                }
            }
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//N	road	K	result
		//5	[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]	3	4
		//6	[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]	4	4
		int N1 = 5;
		int[][] road1 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int k1 = 3;
		System.out.println(solution(N1, road1, k1));
		int N2 = 6;
		int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int k2 = 4;
		System.out.println(solution(N2, road2, k2));
		
	}

}
