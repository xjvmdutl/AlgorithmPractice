package progammers.level1.review;

public class 핸드폰번호가리기 {
	public static String solution(String phone_number) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<phone_number.length()-4;++i) {
        	sb.append("*");
        }
		sb.append(phone_number.substring(phone_number.length()-4,phone_number.length()));
        return sb.toString();
    }
	public static void main(String[] args) {
		//phone_number	return
		//"01033334444"	"*******4444"
		//"027778888"	"*****8888"
		System.out.println(solution("01033334444"));
		System.out.println(solution("027778888"));
	}

}
