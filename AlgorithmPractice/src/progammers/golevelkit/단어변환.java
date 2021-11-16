package progammers.golevelkit;

import java.util.LinkedList;
import java.util.Queue;
class Word{
	String w;
	int c;
	public Word(String w,int c){
		this.c =c;
		this.w = w;
	}
}
public class 단어변환 {
	public static boolean[] visit;
	public static int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        for(int i=0;i<words.length;++i) {
        	if(words[i].equals(begin)) {
        		visit[i] = true;
        		break;
        	}
		}
        int answer = bfs(begin,target,words);
        return answer;
    }
	private static int bfs(String begin, String target, String[] words) {
		Queue<Word> que = new LinkedList<>();
		que.offer(new Word(begin, 0));
		while(!que.isEmpty()) {
			Word word = que.poll();
			if(word.w.equals(target)) {
				return word.c;
			}
			
			for(int i=0;i<words.length;++i) {
				String str = word.w;
				if(!visit[i] && str.length() == str.length()) {
					int count = 0;
					for(int j=0;j<str.length();++j) {
						char c1 = str.charAt(j);
						char c2 = words[i].charAt(j);
						if(c1 != c2)
							count++;
					}
					if(count == 1) {
						visit[i] = true;
						que.offer(new Word(words[i], word.c+1));
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		//begin	target	words	return
		//"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
		//"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
		String begin1 = "hit";
		String target1 = "cog";
		String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin1,target1,words1));
		String begin2 = "hit";
		String target2 = "cog";
		String[] words2 = {"hot", "dot", "dog", "lot", "log"};
		System.out.println(solution(begin2,target2,words2));
	}

}
