package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Prime{
	int count;
	int number;
	public Prime(int count,int number) {
		this.count = count;
		this.number = number;
	}
	
	public int get1(){
        return number%10;
    }

    public int get2(){
        return (number%100)/10;
    }
    
    public int get3(){
        return (number%1000)/100;
    }
    
    public int get4(){
        return (number)/1000;
    }
    
}
public class 소수경로 {
	public static boolean[] visit;
	public static int answer;
	public static boolean[] dp = new boolean[10000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		dp[2] = true;
		dp[3] = true;
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		for (int i = 5; i <= 9999; i+=2) {
			if(IsPrimeNumber(i)) { 
				dp[i] = true;
			} 
		}

		for(int i=0;i<t;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end =  Integer.parseInt(tokens.nextToken());
			System.out.println(solution(start,end));
		}
	}

	private static boolean IsPrimeNumber(int num) {
		for(int i=2; i*i <= num;++i ) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int solution(int start, int end) {
		visit = new boolean[10000];
		answer = 0;
		bfs(start,end);
		return answer;
	}

	private static void bfs(int start, int end) {
		Queue<Prime> que = new LinkedList<>();
		que.offer(new Prime(0, start));
		visit[start] = true;
		while(!que.isEmpty()) {
			Prime p = que.poll();
			if(p.number == end) {
				answer = p.count;
				return;
			}
			for(int i=0;i<=9;i++){
	            if(i!=p.get4()){
	                int next = i*1000 + p.get3()*100 + p.get2()*10 + p.get1();
	                if(1000<=next && isPrime(next) && !visit[next]){
	                    visit[next] = true;
	                    que.offer(new Prime(p.count+1,next));
	                }
	            }
	            if(i!=p.get3()){
	                int next = p.get4()*1000 + i*100 + p.get2()*10 + p.get1();
	                if(1000<=next && isPrime(next) && !visit[next]){
	                	visit[next] = true;
	                	que.offer(new Prime(p.count+1,next));
	                }
	            }
	            if(i!=p.get2()){
	                int next = p.get4()*1000 + p.get3()*100 + i*10 + p.get1();
	                if(1000<=next && isPrime(next) && !visit[next]){
	                	visit[next] = true;
	                	que.offer(new Prime(p.count+1,next));
	                }
	            }
	            if(i!=p.get1()){
	                int next = p.get4()*1000 + p.get3()*100 + p.get2()*10 +i;
	                if(1000<=next && isPrime(next) && !visit[next]){
	                	visit[next] = true;
	                	que.offer(new Prime(p.count+1,next));
	                }
	            }
			}
        }
	}

	private static boolean isPrime(int x) {
		if(dp[x]) {
			return true;
		}else {
			return false;
		}
	}

}
