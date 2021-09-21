package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Jewelry {
    int mass; // 무게
    int value; // 가격
 
    Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}
public class 보석도둑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken()); 
		Jewelry[] jewelrys = new Jewelry[n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			jewelrys[i] = new Jewelry(
								Integer.parseInt(tokens.nextToken()),
								Integer.parseInt(tokens.nextToken())
							);
		}
		int[] bags = new int[k];
		for(int i=0;i<k;++i) {
			bags[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(jewelrys,bags,n,k));
	}

	private static long solution(Jewelry[] jewelrys, int[] bags, int n, int k) {
		long answer = 0;
		Queue<Integer> que = new PriorityQueue<>((o1,o2)->o2-o1);
		Arrays.sort(jewelrys,(o1,o2)->{
			if(o1.mass == o2.mass)
				return o2.value - o1.value;
			return o1.mass - o2.mass;
		});
		Arrays.sort(bags);
		int idx = 0;
		for(int i=0;i<bags.length;++i) {
			int bag = bags[i];
			while(idx < jewelrys.length
					&& bag >= jewelrys[idx].mass) {
				que.offer(jewelrys[idx++].value);
			}
			if(!que.isEmpty()) {
				answer += que.poll();
			}
		}
		
		return answer;
	}

}
