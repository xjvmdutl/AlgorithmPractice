package progammers.level1;

public class 비밀지도 {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] firstResult = new String[n];
        String[] secondResult = new String[n];
        for(int i=0;i<arr1.length;++i){
            String tmp = Integer.toBinaryString(arr1[i]);
            StringBuilder rs = new StringBuilder();
            for(int j=tmp.length();j<n;++j){
                rs.append("0");
            }
            rs.append(tmp);
            firstResult[i]=rs.toString();
        }
        for(int i=0;i<arr2.length;++i){
            String tmp = Integer.toBinaryString(arr2[i]);
            StringBuilder rs = new StringBuilder();
            for(int j=tmp.length();j<n;++j){
                rs.append("0");
            }
            rs.append(tmp);
            secondResult[i]=rs.toString();
        }
        
        String[] answer = {};
        return answer;
    }
	public static void main(String[] args) {
		int n=6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		String[] s = solution(n,arr1,arr2);
	}

}
