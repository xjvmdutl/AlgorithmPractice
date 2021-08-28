package progammers.level1.review;

public class 수박수박수박수박수박수 {
	 public static String solution(int n) {
		 StringBuilder sb = new StringBuilder();
		 for(int i=0;i<n;++i) {
			 if(i%2==0)
				 sb.append("수");
			 else
				 sb.append("박");
		 }
		 return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n	return
		//3	"수박수"
		//4	"수박수박"
		System.out.println(solution(3));
		System.out.println(solution(4));
	}

}
