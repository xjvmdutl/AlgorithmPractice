package test.ahnlab;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
class Skill implements Comparable<Skill>{
	int count;
	int damage;
	public Skill(int damage, int count){
		this.count = count;
		this.damage = damage;
	}
	@Override
	public int compareTo(Skill o) {
		if(this.damage == o.damage) {
			return o.count - this.count;
		}
		return o.damage - this.damage;
	}
}
public class test03 {
	private static int EMPTY = 0;
	public static int[] solution(int[][] skills, int boss) {
		Queue<Skill> que = new PriorityQueue<>();
		Arrays.sort(skills, (o1, o2)->{
			return o1[0] - o2[0];
		});
		int kind = 0;
		int count = 0;
		for(int i=0;i<skills.length;++i) {
			//한번씩 사용이 가능한지 체크
			boss -= skills[i][0];
			skills[i][1]--;
			kind++;
			count++;
			if(boss <= EMPTY) {
				int[] answer = {kind, count};
		        return answer;
			}
			if(skills[i][1] > 0) {
				que.offer(new Skill(skills[i][0], skills[i][1]));
			}
		}
		while(!que.isEmpty()) {
			Skill s = que.poll();
			if(boss - (s.damage * s.count) <= EMPTY) {
				for(int i=1;i<=s.count;++i) {
					if(boss - (i * s.damage) <= EMPTY) {
						count += i;
						boss -= i * s.damage;
						int[] answer = {kind, count};
				        return answer;
					}
				}
			}
			boss -= s.damage * s.count;
			count += s.count;
		}
		int[] answer = {-1};
		return answer;
    }
	
	

	public static void main(String[] args) {
		int[][] skills1 = {{50,3},{100,4},{200,2},{600,1}};
		int boss1 = 50;
		System.out.println(solution(skills1, boss1));
		int[][] skills2 = {{100, 3}, {70, 2}, {200, 5}};
		int boss2 = 50;
		System.out.println(solution(skills2, boss2));
		int[][] skills3 = {{250,100}};
		int boss3 = 1001;
		System.out.println(solution(skills3, boss3));
	}

}
