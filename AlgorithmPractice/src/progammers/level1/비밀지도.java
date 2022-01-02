package progammers.level1;

public class 비밀지도 {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
        for(int i=0;i<arr1.length;++i){
            int now = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(now));
            while(sb.length() < n)
                sb.insert(0,"0");
            answer[i] = sb.toString().replaceAll("0"," ").replaceAll("1","#");
            
        }
        return answer;
    }
	public static void main(String[] args) {
		int n=6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		String[] s = solution(n,arr1,arr2);
	}

}
