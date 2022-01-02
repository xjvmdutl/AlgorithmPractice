package progammers.level1.review;

public class ������� {
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
