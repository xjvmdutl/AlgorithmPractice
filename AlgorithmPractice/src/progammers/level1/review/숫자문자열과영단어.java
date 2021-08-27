package progammers.level1.review;

public class 숫자문자열과영단어 {
	public static int solution(String s) {
        String str = s.replaceAll("zero", "0")
        		.replaceAll("one", "1")
        		.replaceAll("two", "2")
        		.replaceAll("three", "3")
        		.replaceAll("four", "4")
        		.replaceAll("five", "5")
        		.replaceAll("six", "6")
        		.replaceAll("seven", "7")
        		.replaceAll("eight", "8")
        		.replaceAll("nine", "9");
        
        return Integer.parseInt(str);
    }
	public static void main(String[] args) {
		//s	result
		//"one4seveneight"	1478
		//"23four5six7"	234567
		//"2three45sixseven"	234567
		//"123"	123
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("23four5six7"));
		System.out.println(solution("2three45sixseven"));
		System.out.println(solution("123"));
	}

}
