package progammers.level1.review;

public class 키패드누르기 {
	public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for(int i=0;i<numbers.length;++i) {
        	if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 ) {
        		sb.append("L");
    			left = numbers[i];
        	}else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9 ) {
        		sb.append("R");
        		right = numbers[i];
        	}else {
        		int now = 0;
        		if(numbers[i] == 0) {
        			now = 11;
        		}else {
        			now = numbers[i];
        		}
        		int n = Math.abs(now/3 - left/3);
    			if(now%3 != left%3 ) {
    				n++;
    			}
    			int m = Math.abs((now-1)/3 - (right-1)/3);
    			if(now%3 != right%3 ) {
    				m++;
    			}
    			if(n < m) {
    				sb.append("L");
    				left = now;
    			}else if(n > m) {
    				sb.append("R");
    				right = now;
    			}else {
    				if(hand.equals("left")) {
    					sb.append("L");
        				left = now;
    				}else if(hand.equals("right")) {
    					sb.append("R");
        				right = now;
    				}
    			}
        	}
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		int[] n1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}; 
		System.out.println(solution(n1,"right"));
		int[] n2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}; 
		System.out.println(solution(n2,"left"));
		int[] n3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}; 
		System.out.println(solution(n3,"right"));
	}

}
