package AutoEverPratice;

import java.util.HashSet;

public class t {
	public static boolean[] visit;
	public static HashSet<Integer> set;
	public static int solution(int[][] dice) {
        int answer = 0;
        set = new HashSet<>();
        for(int i=1;i<=dice.length;++i) {
        	visit = new boolean[dice.length];
        	StringBuilder sb= new StringBuilder();
        	dfs(dice,sb,i,0);
        }
        for(int i=1;;++i) {
        	if(set.contains(i))
        		continue;
        	answer = i;
        	break;
        }
        return answer;
    }
	private static void dfs(int[][] dice, StringBuilder sb, int count, int index) {
		if(index == count) {
			if(sb.charAt(0) == '0') {
				return;
			}
			set.add(Integer.parseInt(sb.toString()));
			return;
		}
		for(int i=0;i<dice.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				for(int j=0;j<dice[i].length;++j) {
					sb.append(dice[i][j]);
					dfs(dice, sb, count, index+1);
					sb.deleteCharAt(sb.length()-1);
				}
				visit[i] = false;
			}
		}
		
	}
	public static void main(String[] args) {
		int[][] d = {{1, 6, 2, 5, 3, 4}, {9, 9, 1, 0, 7, 8}};
		System.out.println(solution(d));
	}

}
