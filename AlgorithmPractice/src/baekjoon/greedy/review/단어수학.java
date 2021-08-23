package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어수학 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] str = new String[n];
		for(int i=0;i<n;++i)
			str[i] = reader.readLine();
		System.out.println(solution(str,n));
	}

	private static int solution(String[] str, int n) {
		int answer = 0;
		int[] dir = new int['Z' - 'A' +1];//몇번나오는 지 세기위한 배열
		for(int i=0;i<str.length;++i) {
			int l = 1;
			for(int j=str[i].length()-1;j>=0;--j) {
				char c = str[i].charAt(j);//현재 나온 단어
				dir[c - 'A'] += l;//해당 단어의 자리수 * 1 을 더한다.
				l*=10;
			}
		}
		int[] reverse = Arrays.stream(dir).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		//내림차순으로 정렬
		int idx = 9;
		for(int i=0;i<reverse.length;++i) {
			if(reverse[i] == 0)
				break;
			answer += reverse[i] * idx;
			//9부터 값을 세팅해서 더해준다.
			idx--;
		}
		return answer;
	}

}
