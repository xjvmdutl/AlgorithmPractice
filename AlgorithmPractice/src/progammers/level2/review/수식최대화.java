package progammers.level2.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class 수식최대화 {
	public static boolean[] visit;
	public static List<Long> value;
	public static List<Character> oper;
	public static long answer;
	public static void main(String[] args) {
		//expression	result
		//"100-200*300-500+20"	60420
		//"50*6-3*2"	300
		System.out.println(solution("100-200*300-500+20"));
		System.out.println(solution("50*6-3*2"));
	}

	public static long solution(String expression) {
        answer = 0;
        List<Character> list = new ArrayList<>();
        
        for(int i=0;i<expression.length();++i) {
        	if(!Character.isDigit(expression.charAt(i)) && !list.contains(expression.charAt(i))) {
        		list.add(expression.charAt(i));
        	}
        }
        int start = 0;
        value = new ArrayList<>();
        oper = new ArrayList<>();
        for(int i=0;i<expression.length();++i) {
			if(Character.isDigit(expression.charAt(i))) {
				continue;
			}else {
				value.add( Long.parseLong(expression.substring(start,i)));
				oper.add(expression.charAt(i));
				if(i+1 < expression.length())
					start = i+1;
			}
		}
        value.add( Long.parseLong(expression.substring(start)));
        int[] data = new int[list.size()];
        visit = new boolean[list.size()];
        
        combine(0,list.size(),list,data,expression);
        
        return answer;
    }

	private static void combine(int cnt, int length, List<Character> list, int[] data, String expression) {
		if(cnt == length) {
			long n = Math.abs(solve(data,list,expression));
			answer = Math.max(n, answer);
			return;
		}
		for(int i=0;i<list.size();++i) {
			if(!visit[i]) {
				visit[i] = true;
				data[cnt] = i;
				combine(cnt+1,length, list,data,expression);
				visit[i] = false;
			}
		}
	}

	private static long solve(int[] data, List<Character> list, String expression) {
		List<Character> operList = new ArrayList<>();
		operList.addAll(oper);
		List<Long> dataList = new ArrayList<>();
		dataList.addAll(value);
		for(int i=0;i<data.length;++i) {
			char curOper = list.get(data[i]);
			for(int j=0;j<operList.size();++j) {
				if(operList.get(j) == curOper) {
					long n1 = dataList.get(j);
					long n2 = dataList.get(j+1);
					long r = calc(n1,n2,curOper);
					operList.remove(j);
					dataList.set(j,r);
					dataList.remove(j+1);
					j--;
				}
			}
		}
		return dataList.get(0);
	}

	private static long calc(long n1, long n2, char curOper) {
		if(curOper == '+') {
			return n1+n2;
		}else if(curOper == '-') {
			return n1-n2;
		}else {
			return n1*n2;
		}
	}

}
