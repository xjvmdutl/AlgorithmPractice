package progammers.level1;

public class 소수찾기 {
	public int solution(int n) {
        int answer = 0;
        for(int i=2;i<=n;++i){
            boolean ischk = false;
            for(int j=2;j<i;++j){
                if(i%j == 0){
                    ischk =true;
                    break;
                }
            }
            if(!ischk){
                answer++;
            }
        }
        return answer;
    }
	/*
	int numberOfPrime(int n) {
    	int result = 0;
    	for(int i=2; i<=n; i++){
	        for(int j=2; j<=i; j++){
	        if(j == i){
	            ++result;
	        } else if(i%j == 0){
	            break;
	        }
      	}
    }
    */
}
