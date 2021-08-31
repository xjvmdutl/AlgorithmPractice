package progammers.level2.review;

import java.util.HashMap;
import java.util.Map;

public class 단체사진찍기 {
	public static Map<Character,Integer> kakao; 
	public static boolean[] visit;
	public static int[] position;
	public static int answer;
	public static int solution(int n, String[] data) {
        answer = 0;
        visit = new boolean[8];
        position = new int[8];
        init();
        dfs(0,data);
        return answer;
    }
	private static void init() {
		kakao = new HashMap<>();
		kakao.put('A', 0);
		kakao.put('C', 1);
		kakao.put('F', 2);
		kakao.put('J', 3);
		kakao.put('M', 4);
		kakao.put('N', 5);
		kakao.put('R', 6);
		kakao.put('T', 7);
	}
	private static void dfs(int index, String[] data) {
		if(index == 8) {
			if(isOkay(data)) {
				answer++;
			}
			return;
		}
		for(int i=0;i<8;++i) {
			if(!visit[i]) {
				visit[i] = true;
				position[index] = i;
				dfs(index+1, data);
				position[index] = 0;
				visit[i] = false;
			}
		}
	}
	private static boolean isOkay(String[] data) {
		for(String str : data) {
			int x = position[kakao.get(str.charAt(0))];
			int y = position[kakao.get(str.charAt(2))];
			char c = str.charAt(3);
			int diff = str.charAt(4)-'0';
			if(c == '=' && Math.abs(x - y)-1 != diff) {
				return false;
			}else if(c == '<' && Math.abs(x - y)-1 >= diff) {
				return false;
			}else if(c == '>' && Math.abs(x - y)-1 <= diff) {
				return false;
			}
		}		
		
		return true;
	}
	public static void main(String[] args) {
		//n	data	answer
		//2	["N~F=0", "R~T>2"]	3648
		//2	["M~C<2", "C~M>1"]	0
		int n1 = 2;
		String[] data1 = {"N~F=0", "R~T>2"};
		System.out.println(solution(n1,data1));
		int n2 = 2;
		String[] data2 = {"M~C<2", "C~M>1"};
		System.out.println(solution(n2,data2));
	}

}
