package progammers.weekly;

import java.util.PriorityQueue;
import java.util.Queue;

class Boxer implements Comparable<Boxer>{
	double win;
	int count;
	int weight;
	int number;
	public Boxer(double win,int count,int weight,int number) {
		this.win = win;
		this.count = count;
		this.weight = weight;
		this.number = number;
	}
	
	
	@Override
	public int compareTo(Boxer o) {
		if(o.win == this.win) {
			if(o.count == this.count) {
				if(o.weight == this.weight) {
					return this.number - o.number;
				}
				return o.weight - this.weight;
			}
			return o.count - this.count;
		}
		return Double.compare(o.win, this.win);
	}
}
public class 복서정렬하기 {
	public static int[] solution(int[] weights, String[] head2head) {
        
        Queue<Boxer> que = new PriorityQueue<>();
        for(int i=0;i<weights.length;++i) {
        	int weight = weights[i];
        	String head = head2head[i];
        	int winCount = 0;
        	int totalCount = 0;
        	int weightCount = 0;
        	for(int j=0;j<head.length();++j) {
        		if(head.charAt(j) == 'W') {
        			totalCount++;
        			winCount++;
        			if(weight < weights[j]) {
        				weightCount++;
        			}
        		}else if(head.charAt(j) == 'L') {
        			totalCount++;
        		}
        	}
        	double win = (double)winCount / totalCount;
        	if(Double.isNaN(win)){
        		win = 0;
        	}
        	Boxer box = new Boxer(win, weightCount, weight,i+1);
        	que.offer(box);
        }
        int[] answer = new int[que.size()];
        int idx = 0;
        while(!que.isEmpty()) {
        	answer[idx++] = que.poll().number;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		//weights	head2head	result
		//[50,82,75,120]	["NLWL","WNLL","LWNW","WWLN"]	[3,4,1,2]
		//[145,92,86]	["NLW","WNL","LWN"]	[2,3,1]
		//[60,70,60]	["NNN","NNN","NNN"]	[2,1,3]
		int[] weights1 = {50,82,75,120};
		String[] head2head1 = {"NLWL","WNLL","LWNW","WWLN"};
		System.out.println(solution(weights1,head2head1));
		int[] weights2 = {145,92,86};
		String[] head2head2 = {"NLW","WNL","LWN"};
		System.out.println(solution(weights2,head2head2));
		int[] weights3 = {60,70,60};
		String[] head2head3 = {"NNN","NNN","NNN"};
		System.out.println(solution(weights3,head2head3));
	}

}
