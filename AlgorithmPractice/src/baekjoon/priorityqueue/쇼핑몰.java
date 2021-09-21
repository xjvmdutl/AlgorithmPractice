package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Person{
	int number;
	int weight;
	public Person(int number,int weight) {
		this.number = number;
		this.weight = weight;
	}
}
class Custom implements Comparable<Custom>{
	int idx;
	int number;
	int time;
	public Custom(int idx,int number,int time) {
		this.idx = idx;
		this.number = number;
		this.time = time;
	}
	
	@Override
	public int compareTo(Custom o) {
		if(this.time == o.time)
			return o.idx - this.idx;
		return this.time - o.time;
	}
	
}
public class ºÓ«Œ∏Ù {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,k));
	}

	private static long solution(int[][] arr, int n, int k) {
		long answer = 0;
		Queue<Person> personQue = new LinkedList<>();
		Queue<Custom> customQue = new PriorityQueue<>();
		List<Integer> result = new ArrayList<>();
		Queue<Integer> waitCountmerQueue = new PriorityQueue<>();
		for(int i=0;i<arr.length;++i) {
			personQue.offer(new Person(arr[i][0], arr[i][1]));
		}
		for(int i=0;i<k;++i) {
			if(personQue.isEmpty()) {
				break;
			}
			Person p = personQue.poll();
			customQue.offer(new Custom(i, p.number, p.weight));
		}
		int now = Integer.MIN_VALUE;
		while(!customQue.isEmpty()) {
			if(!personQue.isEmpty()) {
				Custom c = customQue.poll();
				now =  Math.max(c.time, now);
				waitCountmerQueue.offer(c.idx);
				result.add(c.number);
				while(!customQue.isEmpty()) {
					if(customQue.peek().time == now) {
						Custom tmp = customQue.poll();
						waitCountmerQueue.offer(tmp.idx);
						result.add(tmp.number);
						continue;
					}
					break;
				}
				while(!waitCountmerQueue.isEmpty()) {
					if(personQue.isEmpty())
						break;
					int idx = waitCountmerQueue.poll();
					Person p = personQue.poll();
					customQue.offer(new Custom(idx, p.number,p.weight+now));
				}
				continue;
			}
			if(customQue.isEmpty())
				break;
			Custom c = customQue.poll();
			result.add(c.number);
		}
		for(int i=0;i<result.size();++i) {
			answer += result.get(i) * (i+1);
		}
		return answer;
	}

}
