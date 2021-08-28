package progammers.level1.review;

public class 다트게임 {
	public static int solution(String dartResult) {
        int answer = 0;
        int[] num = new int[3];
        int idx =0;
        String number = "";
        for(int i=0;i<dartResult.length();++i) {
        	char c = dartResult.charAt(i);
        	if(Character.isDigit(c)) {
        		number += c;
        		continue;
        	}
        	if(c == 'S' || c == 'D' || c == 'T') {
        		int nowCount = Integer.parseInt(number);
        		switch (c) {
				case 'S': {
					nowCount = (int)Math.pow(nowCount, 1);
					break;
				}
				case 'D': {
					nowCount = (int)Math.pow(nowCount, 2);
					break;
				}
				case 'T': {
					nowCount = (int)Math.pow(nowCount, 3);
					break;
				}
				default:
					
				}
        		num[idx] = nowCount;
        		if(i+1 < dartResult.length() && dartResult.charAt(i+1) == '*') {
        			i++;
        			if(idx > 0 ) {//idx 1이상
        				num[idx-1] *= 2;
        				num[idx] *= 2;
        			}else {//idx 0
        				num[idx] *= 2;
        			}
        		}else if(i+1 < dartResult.length() && dartResult.charAt(i+1) == '#') {
        			i++;
        			num[idx] *= -1;
        		}
        	}
        	number = "";
        	idx++;
        }
        for(int i=0;i<3;++i) {
        	answer += num[i];
        }
        return answer;
    }
	public static void main(String[] args) {
		//예제	dartResult	answer	설명
		//1	1S2D*3T	37	11 * 2 + 22 * 2 + 33
		//2	1D2S#10S	9	12 + 21 * (-1) + 101
		//3	1D2S0T	3	12 + 21 + 03
		//4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
		//5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
		//6	1T2D3D#	-4	13 + 22 + 32 * (-1)
		//7	1D2S3T*	59	12 + 21 * 2 + 33 * 2
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}

}
