package progammers.level2.review;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
	public static Set<Integer> set;
	public static boolean[] visit;
	public static int[] data;
	public static int solution(String numbers) {
        set = new HashSet<Integer>();
        
        visit = new boolean[numbers.length()];
        for(int i=1;i<=numbers.length();++i) {
        	data = new int[i];
        	permulate(numbers,0,i);
        }
        
        return set.size();
    }
	private static boolean isSosu(int num) {
		if(num <= 1)
			return false;
		if(num == 2 || num == 3)
			return true;
		for(int i=2;i<=Math.sqrt(num);++i) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	private static void permulate(String numbers, int index, int length) {
		if(index == length) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<data.length;++i) {
				sb.append(data[i]);
			}
			if (isSosu(Integer.parseInt(sb.toString()))) {
				set.add(Integer.parseInt(sb.toString()));
			}
			return;
		}
		for(int i=0;i<numbers.length();++i) {
			if(!visit[i]) {
				visit[i] = true;
				data[index] = numbers.charAt(i) - '0';
				permulate(numbers, index+1, length);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		//numbers	return
		//"17"	3
		//"011"	2
		String numbers1 = "1234567";
		System.out.println(solution(numbers1));
		String numbers2 = "011";
		System.out.println(solution(numbers2));
	}

}
