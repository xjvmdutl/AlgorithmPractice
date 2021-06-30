package progammers.level1;
import java.util.*;
public class 문자열다루기기본 {	
    public boolean solution(String s) {
        boolean answer = false;
	    if(s.length()==4 || s.length()==6){
            answer = true;
            for(int i=0;i<s.length();++i){
                if(!Character.isDigit(s.charAt(i))) {
                    answer = false;
                    break;
                }
            }    
	    }
	    return answer;
	    
    }
    /*
     public boolean solution(String s) {
     
        if(s.length() == 4 || s.length() == 6){
            try{
                int x = Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        else return false;
    }
    */
}
