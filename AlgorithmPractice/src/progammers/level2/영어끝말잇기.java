package progammers.level2;

import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기 {
	public static int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        double count = 0;
        for(int i =0 ;i< words.length;++i) {
        	count++;
        	for(int j=0;j<list.size();++j) {
        		String temp = list.get(j);
        		if(j==list.size()-1) {
	        		if(temp.charAt(temp.length()-1) != words[i].charAt(0)) {
	        			return new int[] { (int) (count%n == 0 ? n :count%n),(int) Math.ceil(count/n)};
	        		}
        		}
        		if(temp.equals(words[i]) )
        			return new int[] { (int) (count%n == 0 ? n :count%n),(int) Math.ceil(count/n)};
        	}
        	list.add(words[i]);
        }

        return new int[] {0,0};
    }
	public static void main(String[] args) {
		//n	words	result
		//3	["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]	[3,3]
		//5	["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]	[0,0]
		//2	["hello", "one", "even", "never", "now", "world", "draw"]	[1,3]
		int n1 = 3;
		String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] result1 = solution(n1, words1);
//		for(int i : result1)
//			System.out.println(i);
		
		
		int n2 = 5;
		String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		int[] result2 = solution(n2, words2);
		//for(int i : result2)
			//System.out.println(i);
		
		int n3 = 2;
		String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
		int[] result3 = solution(n3, words3);
		for(int i : result3)
			System.out.println(i);

	}

}
