package progammers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 브라이언의고민 {
	public static String solution(String sentence) {
        String answer = "";
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0;i<sentence.length();++i) {
        	char c = sentence.charAt(i);
        	if(Character.isLowerCase(c)) {
        		if(!map.containsKey(c)) {
        			map.put(c, new ArrayList<>());
        		}
        		map.get(c).add(i);
        	}
        }
        StringBuilder sb = new StringBuilder();
        int lastEndChar = -1;
        int lastStartChar = -1;
        int lastStartWord= -1;
		int lastEndWord = -1;
		int stringIdx = 0;
        for(char c : map.keySet()) {
			List<Integer> list = map.get(c);
        	int n = list.size();
        	int startChar = list.get(0);
        	int endChar = list.get(n-1);
        	int rule = 0;
        	if(n == 1 || n >= 3) {
        		for(int i=1;i<n;++i) {
        			if(list.get(i) - list.get(i-1) != 2) {
        				return "invalid";
        			}
        		}
        		rule = 1;//첫번째 규칙
        	}else if(n == 2){
        		int d = endChar - startChar;
        	    if(d == 2 && (endChar < lastEndChar && startChar > lastStartChar)) {
        	    	//다른 규칙 2 겹친다.
        			rule = 1;
        		}else if(d >= 2){
        			rule = 2;
        		}else {
        			return "invalid";
        		}
        	}
        	int startWord = -1;
        	int endWord = -1;
    	    if(rule == 1){
    	    	startWord  = startChar - 1;
        		 endWord = endChar + 1;
        		 if(lastStartWord < startWord && lastEndWord > endWord) {
        			 if(startChar - lastStartChar == 2 && lastEndChar - endChar == 2){
        				 continue;
    				 }
    				 else return "invalid";
        		 }
        	 }else if(rule == 2) {
        		 startWord = startChar;
        		 endWord = endChar;
        		 if(lastStartWord < startWord && lastEndWord > endWord) {
        			 return "invalid";
        		 }
        	 }
        	 if(lastEndWord >= startWord) 
        		 return "invalid";
        	 if(stringIdx < startWord) {
        		 sb.append(makeWord(sentence,stringIdx,startWord-1));
        		 sb.append(" ");
        	 }
        	 sb.append(makeWord(sentence,startWord,endWord));
        	 sb.append(" ");
        	 lastStartWord = startWord;
        	 lastEndWord = endWord;
        	 lastStartChar = startChar;
        	 lastEndChar = endChar;
        	 stringIdx = endWord+1;
        }
        if(stringIdx < sentence.length()) {
        	sb.append(makeWord(sentence,stringIdx,sentence.length()-1));
        }
        return sb.toString().trim();
    }
	private static String makeWord(String sentence, int start, int end) {
		String word = sentence.substring(start, end+1);
		return word.replaceAll("[a-z]","");
	}
	public static void main(String[] args) {
		System.out.println(solution("HaEaLaLaObWORLDb"));
	}

}
