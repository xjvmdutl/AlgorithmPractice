package progammers.level2.review;

import java.util.Stack;
class Data{
	int day;
	int count;
	public Data(int day,int count) {
		this.count = count;
		this.day = day;
	}
}
public class 기능개발 {
	public static int[] solution(int[] progresses, int[] speeds) {
        
        Stack<Data> stack = new Stack<>();
        for(int i=0;i<progresses.length;++i) {
        	int progress = progresses[i];
        	int speed = speeds[i];
        	int day = 0;
        	for(;progress < 100;progress+=speed) {
        		day++;
        	}
        	if(!stack.isEmpty() && stack.peek().day >= day) {
        		stack.peek().count++;
        		continue;
        	}
        	stack.push(new Data(day, 1));
        }
        int[] answer = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;--i) {
        	answer[i] = stack.pop().count;
        }
        return answer;
    }
	public static void main(String[] args) {
		//progresses	speeds	return
		//[93, 30, 55]	[1, 30, 5]	[2, 1]
		//[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
		int[] progresses1 = {93, 30, 65};
		int[] speeds1 = {1, 30, 5};
		System.out.println(solution(progresses1,speeds1));
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		System.out.println(solution(progresses2,speeds2));
	}

}
