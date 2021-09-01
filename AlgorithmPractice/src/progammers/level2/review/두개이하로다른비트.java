package progammers.level2.review;

public class 두개이하로다른비트 {
	public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;++i) {
        	long n = numbers[i];
        	if(n % 2 == 0) {
        		//짝수
        		answer[i] = n+1;
        	}else {
        		String bits= Long.toBinaryString(numbers[i]);
        		int lastIndex =  bits.lastIndexOf("0");
                int firstIndex = bits.indexOf("1",lastIndex);
                if(lastIndex == -1) {
                	numbers[i]+=1;
                	bits =  Long.toBinaryString(numbers[i]);
                	bits = bits.substring(0,2)+	//111 -> 1000 인데 10 을 제외한 나머지0-->1로 변경
                			bits.substring(2,bits.length()).replace("0","1");
                }else {
                	bits = bits.substring(0,lastIndex)+"1"+
                			bits.substring(lastIndex+1,firstIndex)+"0"+
                			bits.substring(firstIndex+1,bits.length());
                }
                answer[i] = Long.parseLong(bits,2);
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//numbers	result
		//[2,7]	[3,11]
		long[] numbers = {2,9};
		System.out.println(solution(numbers));
	}

}
