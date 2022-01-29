package progammers.level3.review;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {
	public static boolean[] visit;
	public static String[] selected;
	public static int answer;
	public static Set<String[]> set;
	public static int solution(String[] user_id, String[] banned_id) {
        answer = 0;
		visit = new boolean[user_id.length];
        selected = new String[banned_id.length];
        set = new HashSet<>();
        for(int i=0;i<banned_id.length;++i)
        	banned_id[i] = banned_id[i].replace('*', '.');
        permulate(user_id, banned_id, 0, banned_id.length);
        
        return answer;
    }
	private static void permulate(String[] user_id, String[] banned_id, int count, int length) {
		if(count == length) {
			String[] select = selected.clone();
			Arrays.sort(select);
			for(String[] arr : set) {
				if(Arrays.equals(arr, select)) {
					return;
				}
			}
			answer++;
			set.add(select);
			return;
		}
		for(int i=0;i<user_id.length;++i) {
			if(!visit[i] && user_id[i].matches(banned_id[count])) {
				visit[i] = true;
				selected[count] = user_id[i];
				permulate(user_id, banned_id, count+1, length);
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
		System.out.println(solution(user_id1,banned_id1));
		System.out.println(solution(user_id2,banned_id2));
		System.out.println(solution(user_id3,banned_id3));
	}

}
