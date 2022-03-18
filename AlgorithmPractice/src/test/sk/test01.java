package test.sk;

import java.util.ArrayList;
import java.util.List;

class Money{
	int m;
	int c;
	public Money(int m, int c){
		this.m = m;
		this.c = c;
	}
}
public class test01 {
	public static boolean[] visit;
	public static int answer;
	public static int[] per;
	public static int solution(int money, int[] costs) {
	    answer = Integer.MAX_VALUE;
	    List<Money> list = new ArrayList<>();
	    int totalMoney = 1;
	    visit= new boolean[6];
	    per= new int[6];
	    for(int i=0;i<costs.length;++i) {
	    	list.add(new Money(totalMoney, costs[i]));
	    	totalMoney *= (i%2) == 0 ? 5 : 2;
	    }
	    permutation(list, 0, 6, money);
	    return answer;
	}
	private static void permutation(List<Money> list, int count, int length, int money) {
		if(length == count) {
			int cnt = 0;
			for(int i=0;i<6;++i) {
				Money mon = list.get(per[i]);
				cnt += mon.c*(money/mon.m);
				money %= mon.m;
				if(money == 0)
					break;
			}
			answer = Math.min(answer, cnt);
			return;
		}
		for(int i=0;i<6;++i) {
			if(!visit[i]) {
				visit[i] = true;
				per[count] = i;
				permutation(list, count+1, length, money);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		int[] costs = {1, 4, 99, 35, 50, 1000};
		System.out.println(solution(4578, costs));
	}
}
