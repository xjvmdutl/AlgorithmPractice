package progammers.level2.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Æ©ÇÃ {
	public static int[] solution(String s) {
        
        int start=0;
        List<String> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        for(int i=1;i<s.length()-1;++i) {
        	char c = s.charAt(i);
        	if(c == '{') {
        		start = i;
        	}else if(c == '}') {
        		list.add(s.substring(start+1, i));
        	}
        }
        Collections.sort(list,(o1,o2)->o1.length()-o2.length());
        for(int i=0;i<list.size();++i) {
        	String[] str = list.get(i).split(",");
        	for(int j=0;j<str.length;++j) {
        		if(tmpList.contains(Integer.parseInt(str[j]))) {
        			continue;
        		}
        		tmpList.add(Integer.parseInt(str[j]));
        	}
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<tmpList.size();++i) {
        	answer[i] = tmpList.get(i);
        }
        
        return answer;
    }
	public static void main(String[] args) {
		//s	result
		//"{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
		//"{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
		//"{{20,111},{111}}"	[111, 20]
		//"{{123}}"	[123]
		//"{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		String s3 = "{{20,111},{111}}";
		String s4 = "{{123}}";
		String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
		System.out.println(solution(s5));
	}

}
