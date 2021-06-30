import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class test {
	 public static String solution(String[] table, String[] languages, int[] preference) {
         String answer = "";
        Map<String,Integer> result = new HashMap<>();
        
        for(String s : table){
            String[] arr = s.split(" ");
            for(int i=arr.length-1;i>0;--i){
                for(int j=0;j<languages.length;++j){
                    if(arr[i].equals(languages[j])){
                        result.put(arr[0],preference[j]*i);
                    }
                }
            }
        }
        int max = 0;
        Set set = result.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Entry<String,Integer> entry = (Entry)iterator.next();
            String key = (String)entry.getKey();
            int value = (Integer)entry.getValue();
            max = Math.max(max, value);
            if(max== value ) {
            	if(answer.compareTo(key) > 0) {
            		answer= key;
            	}else {
            		answer= key;
            	}
        	}
        }        
        return answer;
    }
	public static void main(String[] args) {
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] s1 = {"PYTHON", "C++", "SQL"};
		int[] s2 = {7,5,5};
		String s = solution(table,s1,s2);
	}

}
