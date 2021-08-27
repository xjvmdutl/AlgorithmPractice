package progammers.level1.review;

public class 비밀지도 {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;++i) {
        	int tmp = arr1[i] | arr2[i];
        	String str = Integer.toBinaryString(tmp);
        	StringBuilder sb = new StringBuilder();
        	for(int j=n-str.length();j>0;--j) {
        		sb.append(" ");
        	}
        	for(int j=0;j<str.length();++j) {
        		if(str.charAt(j) == '1') {
        			sb.append("#");
        		}else {
        			sb.append(" ");
        		}
        	}
        	answer[i] = sb.toString();
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		int n1=5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {9, 1, 21, 17, 28};
		String[] s1 = solution(n1,arr1,arr2);
		int n2=6;
		int[] arr3 = {46, 33, 33 ,22, 31, 50};
		int[] arr4 = {27 ,56, 19, 14, 14, 10};
		String[] s2 = solution(n2,arr3,arr4);
	}

}
