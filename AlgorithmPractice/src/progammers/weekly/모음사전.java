package progammers.weekly;

public class 모음사전 {
	public static int solution(String word) {
        int answer = 0;
        int result = 0;
        for(int i=0;i<word.length();++i) {
        	result*=10;
        	if(word.charAt(i) == 'A') {
        		result += 1;
        	}else if(word.charAt(i) == 'E') {
        		result += 2;
        	}else if(word.charAt(i) == 'I') {
        		result += 3;
        	}else if(word.charAt(i) == 'O') {
        		result += 4;
        	}else if(word.charAt(i) == 'U') {
        		result += 5;
        	}
        }
        while(String.valueOf(result).length() < 5) {
        	result*=10;
        }
        int num;
        for(int a=1;a<=5;++a) {
        	num = a * 10000;
        	answer++;
        	if(ischk(num,result)) 
        		return answer;
        	for(int b=1;b<=5;++b) {
        		num = a * 10000 + b * 1000;
        		answer++;
        		if(ischk(num,result)) 
        			return answer;
        		for(int c=1;c<=5;++c) {
        			num = a * 10000 + b * 1000 + c * 100;
            		answer++;
            		if(ischk(num,result)) 
            			return answer;
        			for(int d=1;d<=5;++d) {
        				num = a * 10000 + b * 1000 + c * 100 + d * 10;
                		answer++;
                		if(ischk(num,result)) 
                			return answer;
        				for(int e=1;e<=5;++e) {
        					num = a * 10000 + b * 1000 + c * 100 + d * 10 + e;
        	        		answer++;
        	        		if(ischk(num,result)) 
        	            		return answer;
        		        }	
        	        }	
                }
            }
        }
        return answer;
    }
	private static boolean ischk(int num,int result) {
		if(num == result)
			return true;
		return false;
	}
	public static void main(String[] args) {
		//word	result
		//"AAAAE"	6
		//"AAAE"	10
		//"I"	1563
		//"EIO"	1189
		String word1 = "AAAAE";
		String word2 = "AAAE";
		String word3 = "I";
		String word4 = "EIO";
		System.out.println(solution(word1));
		System.out.println(solution(word2));
		System.out.println(solution(word3));
		System.out.println(solution(word4));
	}

}
