package progammers.level2;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {
	static Long answer;
	static List<Character> operList;
	static Character[] oper = {'*','-','+'};
	static Character[] tmp = new Character[3];
	static boolean[] visited = new boolean[3];
	static List<Long> dataList;
	public static long solution(String expression) {
		answer = 0L;
		StringBuilder sb= new StringBuilder();
		operList = new ArrayList<>();
		dataList = new ArrayList<>();
		for(char c : expression.toCharArray()) {
			if(c == '+' || c == '*' || c == '-') {
				operList.add(c);
				dataList.add(Long.parseLong(sb.toString()));
				sb = new StringBuilder();
				continue;
			}
			sb.append(c);
		}
		dataList.add(Long.parseLong(sb.toString()));
		per(0,oper.length);
		return answer;
    }	
	private static void per(int index, int depth) {
		if(index==depth) {
			solve();//연산
			return;
		}
		for(int i=0;i<depth;++i) {
			if(!visited[i]) {
				visited[i]= true;
				tmp[index] = oper[i];
				per(index+1,depth);
				visited[i]=false;
			}
		}
	}
	
	private static void solve() {
		List<Character> oper = new ArrayList<>();
		oper.addAll(operList);
		List<Long> data = new ArrayList<>();
		data.addAll(dataList);
		for(int i=0;i<tmp.length;++i) {
			Character curOper = tmp[i];
			for(int j=0;j<oper.size();++j) {
				if(curOper == oper.get(j)) {
					Long n1 = data.get(j);
					Long n2 = data.get(j+1);
					Long result = calc(n1,n2,curOper);
					
					data.set(j, result);
					
					oper.remove(j);
					data.remove(j+1);
					j--;
				}
			}
		}
		answer = Math.max(answer, Math.abs(data.get(0)));
	}
	private static Long calc(Long n1, Long n2, Character curOper) {
		Long result = 0L;
		if(curOper == '+')
			result = n1+n2;
		else if(curOper == '-')
			result = n1-n2;
		else if(curOper == '*')
			result = n1*n2;
		return result;
	}
	public static void main(String[] args) {
		//expression	result
		//"100-200*300-500+20"	60420
		//"50*6-3*2"	300
		String expression1 = "100-200*300-500+20";
		String expression2 = "50*6-3*2";
		System.out.println(solution(expression1));
		System.out.println(solution(expression2));
	}

}

