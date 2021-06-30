package progammers.level2;

public class 두개이하로다른비트 {
	public static long[] solution(long[] numbers) {
        
        /*
        for(int i=0;i <numbers.length;++i) {
        	long result = numbers[i];
        	while(true) {
        		int count = 0;
        		result++;
        		long tmp = result ^ numbers[i];
        		while(tmp>0) {
        			count+=tmp%2;
        			tmp/=2;
        		}
        		if(count <= 2) {
        			break;
        		}
        	}
        	answer[i] = result;
        }
        
        return answer;
        */
		/*
		long[] answer = new long[numbers.length];
		for(int i=0;i <numbers.length;++i) {
			String BinaryString =  Long.toBinaryString(numbers[i]);
	        if(numbers[i]%2==0){
	            //짝수 가장 낮은 0만 바꾸기
	            //사실상 맨 마지막 자리는 0이기에 +1만 해주면 된다.
	            answer[i] = numbers[i]+1;
	        }else{
	        	int lastIndex =  BinaryString.lastIndexOf("0");
                int firstIndex = BinaryString.indexOf("1",lastIndex);
                if(lastIndex == -1) {
                	//0이 없는경우 +1을 해주고
                    //앞의 10은 놔두고 나머지는 다 1로 해준다.
                    numbers[i]+=1;
                    BinaryString =  Long.toBinaryString(numbers[i]);
                    BinaryString = BinaryString.substring(0,2)+
                            BinaryString.substring(2,BinaryString.length()).replace("0","1");

                }else{
                    BinaryString = BinaryString.substring(0,lastIndex)+"1"+
                            BinaryString.substring(lastIndex+1,firstIndex)+"0"+
                            BinaryString.substring(firstIndex+1,BinaryString.length());
                }
                answer[i] = Long.parseLong(BinaryString,2);
	        }
	        
		}
		return answer;
		*/
		long[] answer = numbers.clone();
        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            System.out.println((answer[i]^numbers[i])>>>2);
            answer[i] += (answer[i]^numbers[i])>>>2;
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//numbers	result
		//[2,7]	[3,11]
		long[] numbers = {2,7,1045};
		long[] result = solution(numbers);
		for(long i : result)
			System.out.println(i);
	}

}
