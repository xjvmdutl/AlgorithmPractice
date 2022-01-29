package progammers.level3.review;

public class 단어변환 {
	public static int answer;
	public static boolean[] visit;
	public static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visit = new boolean[words.length];
        dfs(words, begin, target, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
	private static void dfs(String[] words, String now, String target, int count) {
		if(now.equals(target)) {
			answer = Math.min(answer, count);
			return;
		}
		OUTER:for(int i=0;i<words.length;++i) {
			if(!visit[i]) {
				char[] strs1 = words[i].toCharArray();
				char[] strs2 = now.toCharArray();
				int cnt = 0;
				for(int j=0; j<strs1.length; ++j) {
					if(strs1[j] != strs2[j])
						cnt++;
					if(cnt >= 2) {
						continue OUTER;
					}
				}
				visit[i] = true;
				dfs(words, words[i], target, count+1);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		//begin	target	words	return
		//"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
		//"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
		String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution("hit", "cog", words1));
		String[] words2 = {"hot", "dot", "dog", "lot", "log"};
		System.out.println(solution("hit", "cog", words2));
	}

}
