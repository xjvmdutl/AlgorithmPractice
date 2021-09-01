package progammers.level2.review;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        char c = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        for(int i=1;i<words.length;++i) {
        	if(set.contains(words[i]) || c != words[i].charAt(0)) {
        		answer[0] = (i%n)+1;
        		answer[1] = (i/n)+1;
        		return answer;
        	}
        	c = words[i].charAt(words[i].length()-1);
        	set.add(words[i]);
        }
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n	words	result
		//3	["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]	[3,3]
		//5	["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]	[0,0]
		//2	["hello", "one", "even", "never", "now", "world", "draw"]	[1,3]
		int n1 = 3;
		int n2 = 5;
		int n3 = 2;
		String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
		System.out.println(solution(n1,words1));
		System.out.println(solution(n2,words2));
		System.out.println(solution(n3,words3));
		
	}

}
