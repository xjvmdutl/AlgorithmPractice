package progammers.level1;

public class 신규아이디추천 {
	
	public static String solution(String new_id) {
		/*
		String answer;
        String step1 = new_id.toLowerCase();
        
        char[] step1_arr = step1.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for(char c : step1_arr) {
        	if ((c >= 'a' && c <= 'z') 
        			|| (c >= '0' && c <= '9')
        			|| c == '-' 
        			|| c == '_' 
        			|| c == '.') {
                step2.append(c);
            }
        }
        //3단계
        String step3 = step2.toString().replace("..", ".");
        while(step3.contains("..")) {
        	step3 = step3.replace("..", "."); 
        }
        
        //4단계
        String step4 = step3;
        if(step4.indexOf(".") != -1
        	&&	step4.indexOf(".") == 0
        	) {
        	step4 = step4.substring(1);
        }
        if(step4.lastIndexOf(".") != -1
        	&&	step4.lastIndexOf(".") == step4.length()-1) {
        	step4 = step4.substring(0,step4.length()-1);
        }
        
        //5단계
        String step5 = step4;
        if("".equals(step5)) {
        	step5="a";
        }
        
        //6단계
        String step6 = step5;
        if(step6.length() >= 16) {
        	step6= step6.substring(0,15);
        	if(step6.charAt(step6.length() - 1) == '.') {
        		step6 = step6.substring(0,step6.length()-1);
            }
        }
        // 7단계
        StringBuilder step7 = new StringBuilder(step6);
        if(step7.length() <= 2) {
        	char last = step7.charAt(step7.length()-1);
        	while(step7.length() < 3) {
        		step7.append(last);
        	}
        }
        answer = String.valueOf(step7);
        return answer;
        */
		String answer;
        String step1 = new_id.toLowerCase();
        char[] step2_arr = step1.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for(char c : step2_arr){
            if(('a'<=c && c<='z')
              ||('-' == c)
              ||('_' == c)
              ||('.' == c)){
                step2.append(c);
            }
        }
        String step3 = step2.toString().replace("..",".");
        while(step3.contains("..")){
            step3 = step3.replace("..",".");
        }
        String step4 = step3;
        if(step4.indexOf(".") != -1 && step4.indexOf(".") == 0){
            step4=step4.substring(1);
        }
        if(step4.lastIndexOf(".") != -1 && step4.lastIndexOf(".") == step4.length()-1){
            step4= step4.substring(0,step4.length()-1);
        }
        String step5 = step4;
        if("".equals(step5)){
            step5 = "a";
        }
        String step6 = step5;
        if(step6.length()>=16){
            step6 = step6.substring(0,15);
            if(step6.lastIndexOf(".") != -1 
               && step6.lastIndexOf(".") == step6.length()-1){
            step6=step6.substring(0,step6.length()-1);
            }
        }
        StringBuilder step7 = new StringBuilder(step6);
        if(step7.length()<=2){
            char last = step7.charAt(step7.length()-1);
            while(step7.length()<3){
                step7.append(last);
            }
        }
        answer = String.valueOf(step7);
        return answer;
    }
	
	public static void main(String[] args) {
		String s1 = solution("...!@BaT#*..y.abcdefghijklm");
		String s2 = solution("z-+.^.");
		String s3 = solution("=.=");
		String s4 = solution("123_.def");
		String s5 = solution("abcdefghijklmn.p");

	}

}
