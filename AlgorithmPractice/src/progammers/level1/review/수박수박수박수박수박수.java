package progammers.level1.review;

public class ���ڼ��ڼ��ڼ��ڼ��ڼ� {
	 public static String solution(int n) {
		 StringBuilder sb = new StringBuilder();
		 for(int i=0;i<n;++i) {
			 if(i%2==0)
				 sb.append("��");
			 else
				 sb.append("��");
		 }
		 return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n	return
		//3	"���ڼ�"
		//4	"���ڼ���"
		System.out.println(solution(3));
		System.out.println(solution(4));
	}

}
