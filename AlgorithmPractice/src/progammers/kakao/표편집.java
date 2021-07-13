package progammers.kakao;

import java.util.Stack;

public class Ç¥ÆíÁý {

    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for(String str : cmd){
            if(str.charAt(0) == 'U'){
                int num = Integer.parseInt(str.split(" ")[1]);
                for(int i=0;i<num;++i){
                    k--;
                    while(arr[k] == 1)
                        k--;
                    
                }
                
            }else if(str.charAt(0) == 'D'){
                int num = Integer.parseInt(str.split(" ")[1]);
                for(int i=0;i<num;++i){
                    k++;
                    while(arr[k] == 1)
                        k++;
                }
            }else if(str.charAt(0) == 'C'){
                stack.push(k);
                arr[k] = 1;
            }else if(str.charAt(0) == 'Z'){
                int deleteIdx = stack.pop();
                arr[deleteIdx] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            if(i == 0)
                sb.append("O");
            else
                sb.append("X");
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		int n1 = 8;
		int k1 = 2;
		String[] str1 = {"D 2","C","U 3","Z","C","D 4","C","U 2","Z"};
		System.out.println(solution(n1, k1, str1));
	}
	
}
