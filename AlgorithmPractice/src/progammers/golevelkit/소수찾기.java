package progammers.golevelkit;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
	public static Set<Integer> set;
	public static boolean[] visit;
	public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        for(int i=1;i<=numbers.length();++i) {
        	char[] nums = new char[i];
        	visit = new boolean[numbers.length()];
        	permulate(numbers,0,i,nums);
        }
        for(int num : set) {
    		if(isSosu(num)) {
    			if(num < 2) {
    				continue;
    			}
    			answer++;
    		}
    	}
        return answer;
    }
	private static boolean isSosu(int num) {
		for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
	}
	private static void permulate(String numbers, int index, int count, char[] nums) {
		if(index == count) {
			StringBuilder sb= new StringBuilder();
			for(int i=0;i<nums.length;++i) {
				sb.append(nums[i]);
			}
			int n = Integer.parseInt(sb.toString());
			set.add(n);
			return;
		}
		for(int i=0;i<numbers.length();++i) {
			if(!visit[i]) {
				visit[i] = true;
				nums[index] = numbers.charAt(i);
				permulate(numbers, index+1, count, nums);
				visit[i] = false;
			}
		}
		
	}
	public static void main(String[] args) {
		//numbers	return
		//"17"	3
		//"011"	2
		String numbers1 = "17";
		System.out.println(solution(numbers1));
		String numbers2 = "011";
		System.out.println(solution(numbers2));
	}

}
