package progammers.level1;

public class 다트던지기 {
	public static int solution(String dartResult) {
		int[] answer = new int[3];
        int cnt = 0;
        int optionIndex = 0;
        for(int i=0;i<dartResult.length();++i){
            //step1
            char dartChar = dartResult.charAt(i);
		    int dartInt = Character.getNumericValue(dartChar); 
            
            if(0<=dartInt && dartInt<=10){
                if(dartInt == 1){
                    if(Character.getNumericValue(dartResult.charAt(i+1)) == 0) {
                        dartInt = 10;
                        i++;
				    }
                }
                answer[cnt++] = dartInt;
            }else{//optioncheck
                switch(dartChar){
                    case 'S':
                        answer[cnt-1] = (int)Math.pow(answer[cnt-1],1);
                        break;
                    case 'D':
                        answer[cnt-1] = (int)Math.pow(answer[cnt-1],2);
                        break;
                    case 'T':
                        answer[cnt-1] = (int)Math.pow(answer[cnt-1],3);
                        break;
                    case '*':
                        optionIndex =cnt-1;
                        if(optionIndex != 0){
                            for(int j=optionIndex-1;j<=optionIndex;++j){
                                answer[j]=answer[j]*2;
                            }
                        }else{
                            answer[optionIndex]=answer[optionIndex]*2;
                        }
                        break;
                    case '#':
                        optionIndex =cnt-1;
                        answer[optionIndex] = answer[optionIndex]*-1;
                        break;
                }
            }
            
        }
        return answer[0]+answer[1]+answer[2];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "1S2D*3T";
		String s2 = "1D2S#10S";
		String s3 = "1D2S0T";
		String s4 = "1S*2T*3S";
		String s5 = "1D#2S*3S";
		String s6 = "1T2D3D#";
		String s7 = "1D2S3T*";
		int i1 = solution(s1);
		int i2 = solution(s2);
		int i3 = solution(s3);
		int i4 = solution(s4);
		int i5 = solution(s5);
		int i6 = solution(s6);
		int i7 = solution(s7);
	}

}
