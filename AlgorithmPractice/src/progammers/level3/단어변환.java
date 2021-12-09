package progammers.level3;

import java.util.PriorityQueue;
import java.util.Queue;
class Word implements Comparable<Word>{
	String str;
	int count;
	public Word(String str,int count){
		this.count = count;
		this.str = str;
	}
	@Override
	public int compareTo(Word o) {
		return this.count - o.count;
	}
}
public class 단어변환 {
	public static boolean[] visit;
	public static int answer;
	public static int solution(String begin, String target, String[] words) {
		answer = 0;
		for(String word : words) {
			if(target.equals(word)) {
				bfs(words,begin,target,0);
				break;
			}
		}
		
		return answer;	
	}
	private static void bfs(String[] words, String begin, String target, int index) {
		Queue<Word> que = new PriorityQueue<>();
		visit = new boolean[words.length];
		que.offer(new Word(begin,0));
		while(!que.isEmpty()) {
			Word w = que.poll();
			if(w.str.equals(target)) {
				answer = w.count;
				return;
			}
			OUTER:for(int i=0;i<words.length;++i) {
				if(!visit[i] && w.str.length() == words[i].length()) {
					int replaceCount = 0;
					for(int j=0;j<w.str.length();++j) {
						if(w.str.charAt(j) != words[i].charAt(j))
							replaceCount++;
						if(replaceCount > 1)
							continue OUTER;
					}
					visit[i] = true;
					que.offer(new Word(words[i], w.count+1));
				}
			}
		}
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
