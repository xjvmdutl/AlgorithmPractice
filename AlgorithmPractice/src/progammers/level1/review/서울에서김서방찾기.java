package progammers.level1.review;

public class ���￡���輭��ã�� {
	public static String solution(String[] seoul) {
		StringBuilder sb= new StringBuilder("�輭���� ");
		for(int i=0;i<seoul.length;++i) {
			if(seoul[i].equals("Kim")) {
				sb.append(i+"�� �ִ�");
				break;
			}
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		//seoul	return
		//["Jane", "Kim"]	"�輭���� 1�� �ִ�"
		String[] seoul = {"Jane", "Kim"};
		System.out.println(solution(seoul));
	}

}
