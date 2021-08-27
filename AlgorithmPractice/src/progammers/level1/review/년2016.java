package progammers.level1.review;

public class ³â2016 {
	public static String solution(int a, int b) {
        String answer = "";
        int day = b;
        for(int i=1;i<a;++i) {
        	switch (i) {
			case 1,3,5,7,8,10,12 : {
				day+=31;
				break;
			}
			case 4,6,9,11 : {
				day+=30;
				break;
			}
			case 2 : {
				day+=29;
				break;
			}
			default:
				day+=0;
				break;
			}
        }
        day%=7;
        switch (day) {
		case 0 : {
			answer="THU";
			break;
		}
		case 1 : {
			answer="FRI";
			break;
		}
		case 2 : {
			answer="SAT";
			break;
		}
		case 3 : {
			answer="SUN";
			break;
		}
		case 4 : {
			answer="MON";
			break;
		}
		case 5 : {
			answer="TUE";
			break;
		}
		case 6 : {
			answer="WED";
			break;
		}
		default:
			
		}
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(5,24));
	}

}
