package progammers.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 불량사용자 {
	public static boolean[] visit;
	public static Set<List<String>> set;
	public static int solution(String[] user_id, String[] banned_id) {
        visit = new boolean[user_id.length];
        set = new HashSet<>();
        String[] regex = new String[banned_id.length];
        for(int i = 0; i < banned_id.length; i++) {
            regex[i] = banned_id[i].replace("*", ".");
        }
        String[] answer = new String[banned_id.length];
        Backtracking(regex,user_id,0,answer);
        return set.size();
    }
	private static void Backtracking(String[] regex, String[] user_id, int idx, String[] answer) {
		if(regex.length == idx) {
			List<String> tmpList = new ArrayList<>();
			for(String str : answer) {
				tmpList.add(str);
			}
			for(List<String> list : set) {
				if(tmpList.containsAll(list)) {
					return;
				}
			}
			set.add(tmpList);
			return;
		}
		for(int i=0;i<user_id.length;++i) {
			if(!visit[i] && user_id[i].matches(regex[idx])) {
				visit[i] = true;
				answer[idx] = user_id[i];
				Backtracking(regex,user_id, idx+1, answer);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		//user_id	banned_id	result
		//["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]	2
		//["frodo", "fradi", "crodo", "abc123", "frodoc"]	["*rodo", "*rodo", "******"]	2
		//["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "*rodo", "******", "******"]	3
		String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		
		
		String[] banned_id1 = {"fr*d*", "abc1**"};
		String[] banned_id2 = {"*rodo", "*rodo", "******"};
		String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};
		//System.out.println(solution(user_id1,banned_id1));
		//System.out.println(solution(user_id2,banned_id2));
		System.out.println(solution(user_id3,banned_id3));
	}

}
