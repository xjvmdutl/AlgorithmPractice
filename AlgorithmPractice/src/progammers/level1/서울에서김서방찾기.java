package progammers.level1;

public class ���￡���輭��ã�� {
	public String solution(String[] seoul) {
        String answer = "";
        for(int i=0;i<seoul.length;++i){
            if("Kim".equals(seoul[i])){
                answer = "�輭���� "+i+"�� �ִ�";
                break;
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
