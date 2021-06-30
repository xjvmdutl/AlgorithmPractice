package progammers.level1;

import java.util.ArrayList;
import java.util.List;

public class 이상한문자만들기 {

	public static String solution(String s) {
		
		String answer = "";
        String[] arr = s.split("");
        int j=0;
        for(int i=0;i<arr.length;++i){
        	if(!arr[i].equals(" ")) {
                if(j%2==0){
                    answer += arr[i].toUpperCase();
                }else{
                    answer += arr[i].toLowerCase();
                }
                j++;
        	}else {
        		answer+=arr[i];
        		j=0;
        	}
        }
		return answer;
		
    
	}
	public static void main(String[] args) {
		String s = "TrY HeLlO WoRlD";
		String s1 = solution(s);
		
	}

}
