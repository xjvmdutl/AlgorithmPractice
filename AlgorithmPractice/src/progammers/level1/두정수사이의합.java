package progammers.level1;

public class 두정수사이의합 {
	public long solution(int a, int b) {
        long answer = 0;
        for(int i=(a<b?a:b);i<=(a<b?b:a);++i){
            answer += i;
        }
        return answer;
    }
	/*
	public long solution(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }
    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
    */
}
