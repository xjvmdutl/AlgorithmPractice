package progammers.level1;

public class 키패드누르기 {
	public static String solution(int[] numbers, String hand) {
		
		///핵심 : position 구하기 x : /3, y : %3
        String answer = "";
        int[] Lpos = {3,0};
        int[] Rpos = {3,2};
        for(int i=0;i<numbers.length;++i){
            if(numbers[i] == 1
              || numbers[i] == 4
              || numbers[i] == 7){
                answer += "L";
                Lpos[0] = (numbers[i]-1)/3;
                Lpos[1] = (numbers[i]-1)%3;
            }else if(numbers[i] == 3
              || numbers[i] == 6
              || numbers[i] == 9){
                answer+="R";
                Rpos[0] = (numbers[i]-1)/3;
                Rpos[1] = (numbers[i]-1)%3;
            }else{
                int num = numbers[i];
                if(num==0){
                    num=11;
                }
                int[] pos = {(num-1)/3,(num-1)%3};
                int xlLength = Math.abs(Lpos[0]-pos[0]);
                int ylLength = Math.abs(Lpos[1]-pos[1]);
                int xrLength = Math.abs(Rpos[0]-pos[0]);
                int yrLength = Math.abs(Rpos[1]-pos[1]);
                int count1 = xlLength + ylLength;
                int count2 = xrLength + yrLength;
                if(count1 < count2){
                    answer += "L";
                    Lpos = pos;
                }else if(count1 > count2){
                    answer += "R";
                    Rpos = pos;
                }else{
                    if(hand.equals("right")){
                        answer += "R";
                        Rpos = pos;
                    }else{
                        answer += "L";
                        Lpos = pos;
                    }
                }
            }
            
        }
        return answer;
    }
	
	
	public static void main(String[] args) {
		int[] n = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}; 
		String s= solution(n,"left");
	}
}
