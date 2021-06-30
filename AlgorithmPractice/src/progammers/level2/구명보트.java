package progammers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 구명보트 {
	public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        for(int max=people.length-1;min<=max;max--) {
        	if(people[min] + people[max] <= limit) min++;
        	answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		//people	limit	return
		//[70, 50, 80, 50]	100	3
		//[70, 80, 50]	100	3
		int[] people1 = {70, 50, 80, 50};
		int limit1 = 100;
		System.out.println(solution(people1, limit1));
		int[] people2 = {70, 80, 50};		
		int limit2 = 100;
		System.out.println(solution(people2, limit2));
		int[] people3 = {10,10,10,10,10,10,10,10,10,10,100};		
		int limit3 = 100;
		System.out.println(solution(people3, limit3));
	}

}
