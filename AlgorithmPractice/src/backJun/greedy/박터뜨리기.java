package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¹ÚÅÍ¶ß¸®±â {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		for(int i=1;i<k+1;i++) {
            n-=i;
            if(n < 0) {
                break;
            }
        } 
		StringBuilder sb= new StringBuilder();
		if(n >=0) {
            if(n%k > 0) {
                sb.append(k);
            }else {
                sb.append(k-1);
            }
        }else {
            sb.append(-1);
        }
		return Integer.parseInt(sb.toString());
	}

}
