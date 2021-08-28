package progammers.level1.review;

public class 서울에서김서방찾기 {
	public static String solution(String[] seoul) {
		StringBuilder sb= new StringBuilder("김서방은 ");
		for(int i=0;i<seoul.length;++i) {
			if(seoul[i].equals("Kim")) {
				sb.append(i+"에 있다");
				break;
			}
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		//seoul	return
		//["Jane", "Kim"]	"김서방은 1에 있다"
		String[] seoul = {"Jane", "Kim"};
		System.out.println(solution(seoul));
	}

}
