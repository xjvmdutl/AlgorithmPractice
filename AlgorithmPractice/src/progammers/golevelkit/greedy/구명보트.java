package progammers.golevelkit.greedy;

import java.util.Arrays;

public class 구명보트 {
	public static int solution(int[] people, int limit) {
        int answer = 0;
        int[] reverse = Arrays.stream(people).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
        int l = reverse.length-1;
        for(int i=0;i<=l;++i) {
        	if(reverse[i] + reverse[l] <= limit) {
        		l--;
        	}
        	answer++;
        }
        return answer;
    }
	public static void main(String[] args) {
		//people	limit	return
		//[70, 50, 80, 50]	100	3
		//[70, 80, 50]	100	3
		//[40,50,150,160] 200 2
		//[40,50,150,160] 200 2
		int[] p1 = {70,50,80,50};
		System.out.println(solution(p1,100));
		int[] p2 = {70,80,50};
		System.out.println(solution(p2,100));
		int[] p3 = {40,50,150,160};
		System.out.println(solution(p3,200));
		int[] p4 = {50, 50, 30, 100, 123, 130};
		System.out.println(solution(p4,130));
	}

}
