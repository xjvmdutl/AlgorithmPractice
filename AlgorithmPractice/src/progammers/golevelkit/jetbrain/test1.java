package progammers.golevelkit.jetbrain;

import java.util.HashSet;
import java.util.Set;

public class test1 {
	public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length;++i) {
        	set.add(numbers[i]);
        }
        for(int i=0;i<10;++i) {
        	if(!set.contains(i))
        		answer += i;
        }
        return answer;
    }
	public static void main(String[] args) {
		
		//numbers	result
		//[1,2,3,4,6,7,8,0]	14
		//[5,8,4,0,6,7,9]	6
		
	}

}
