package progammers.level3;

import java.util.ArrayList;
import java.util.List;

public class 줄서는방법 {
	public static int[] solution(int n, long k) {
		int[] answer = new int[n];
		List<Integer> list = new ArrayList<>();
		long factorial = 1;
		for(int i=1;i<=n;++i) {
			factorial *= i;
			list.add(i);
		}
		int index = 0;
		long remain = k - 1;

		while(index < n) {
			factorial = factorial / (n-index);
			long value = remain / factorial;
			answer[index++] = list.get((int) value);
			list.remove((int)value);
			remain = remain % factorial;
		}
		
        return answer;
    }
	public static void main(String[] args) {
		//n	k	result
		//3	5	[3,1,2]
		int n = 3;
		int k = 5;
		System.out.println(solution(n,k));
	}

}
