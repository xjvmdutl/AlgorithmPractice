package AutoEverPratice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class test02 {
	public static Set<String> set;
	public static boolean[] solution(String[] a) {
        boolean[] answer = new boolean[a.length];
        set = new HashSet<>();
        int idx = 0;
        int max = 0;
        for(int i=0;i<a.length;++i) {
        	if(max < a[i].length()) {
        		max = a[i].length();
        		idx = i;
        	}
        }
    	bfs(a[idx]);
    	for(int i=0;i<a.length;++i) {
    		if(set.contains(a[i])) {
    			answer[i] = true;
    		}else {
    			answer[i] = false;
    		}
    	}
        return answer;
    }
	private static void bfs(String s) {
		Queue<String> que = new LinkedList<>();
		que.offer("a");
		set.add("a");
		while(!que.isEmpty()) {
			String str = que.poll();
			if(str.equals(s)) {
				set.add(str);
			}
			int count = 0;
			for(char c : str.toCharArray()) {
				if(c=='a')
					count++;
			}
			if(str.length() + count * 2 <= s.length()) {
				StringBuilder sb= new StringBuilder(str);
				for(int i=0;i<count;++i) {
					sb.insert(0, "b");
					sb.append("b");
				}
				if(!set.contains(sb.toString())) {
					que.offer(sb.toString());	
					set.add(sb.toString());
				}
			}
			if(str.length() + 1 <= s.length()) {
				if(!set.contains(str+"a")) {
					que.offer(str+"a");	
					set.add(str+"a");
				}
			}
			if(str.length() + 1 <= s.length()) {
				if(!set.contains("a"+str)) {
					que.offer("a"+str);	
					set.add("a"+str);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"abab","bbaa","bababa","bbbabababbbaa"};
		System.out.println(solution(s));
	}

}
