package progammers.level2;

public class 나라의숫자124 {
	private static String solution(int i) {
	    StringBuilder answer = new StringBuilder();

	    while(i>0) {
	    	i-=1;
	    	int num = i%3;
	    	i = i/3;
	    	char result;
	    	switch (num) {
				case 0: {
					result = '1';
					answer.append(result);
					break;
				}
				case 1: {
					result = '2';
					answer.append(result);
					break;
				}
				case 2: {
					result = '4';
					answer.append(result);
					break;
				}
	    	}
	    }	
        return answer.reverse().toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		10진법	124 나라	10진법	124 나라
//		1	1	6	14
//		2	2	7	21
//		3	4	8	22
//		4	11	9	24
//		5	12	10	41
		for(int i=1;i<=100;++i)
			System.out.println(solution(i));
		
	}

	

}
