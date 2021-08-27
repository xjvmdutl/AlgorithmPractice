package progammers.weekly;

import java.util.HashMap;
import java.util.Map;

public class 직업군추천하기 {
	public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<preference.length;++i) {
        	for(String str : table) {
        		String[] languege = str.split(" ");
        		int count = 0;
        		for(int j=1;j<languege.length;++j) {
        			if(languege[j].equals(languages[i])) {
        				count = (6-j) * preference[i];
        				break;
        			}
        		}
        		map.put(languege[0], map.getOrDefault(languege[0], 0)+count);
            }
        }
        int max = 0;
        for(String data : map.keySet()) {
        	if(max <= map.get(data)) {
        		if(max == map.get(data)) {
        			if(answer.compareTo(data) > 0) {
        				max = map.get(data);
                		answer = data;
                		continue;
        			}
        		}else {
	        		max = map.get(data);
	        		answer = data;
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		String[] table1 = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages1 = {"PYTHON", "C++", "SQL"};
		int[] preference1 = {7,5,5};
		System.out.println(solution(table1, languages1, preference1));
		String[] table2 = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages2 = {"JAVA", "JAVASCRIPT"};
		int[] preference2 = {7,5};
		System.out.println(solution(table2, languages2, preference2));
	}
}
