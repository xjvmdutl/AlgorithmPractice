package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Jewelry {
    int mass; // 무게
    int value; // 가격
 
    Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}
public class 보석도둑 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int k = Integer.parseInt(strs[1]); 
		Jewelry[] jewelrys = new Jewelry[n];
		for(int i=0;i<n;++i) {
			strs = reader.readLine().split(" ");
			Jewelry jewelry = new Jewelry(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
			jewelrys[i] = jewelry;
		}
		int[] bags = new int[k];
		for(int i=0;i<k;++i) {
			bags[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(jewelrys,bags,n,k));
	}

	private static long solution(Jewelry[] jewelrys, int[] bags, int n, int k) {
		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});
		Arrays.sort(jewelrys,(o1,o2)->{
			if(o1.mass == o2.mass) {
				return o2.value - o1.value;
			}
			return o1.mass - o2.mass;
		});
		Arrays.sort(bags);
		for(int i=0;i<bags.length;++i) {
			int idx = 0;
			while(idx < jewelrys.length 
					&& jewelrys[idx].mass < bags[i]) {
				pq.offer(jewelrys[idx++].value);
			}
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		return answer;
	}

}
