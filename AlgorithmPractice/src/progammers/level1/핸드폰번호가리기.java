package progammers.level1;

public class 핸드폰번호가리기 {
	public static String solution(String phone_number) {
	   char[] ch = phone_number.toCharArray();
	     for(int i = 0; i < ch.length - 4; i ++){
	         ch[i] = '*';
	     }
	     return String.valueOf(ch);
    }
	public static void main(String[] args) {
		String s = solution("0123454545");
	}

}
