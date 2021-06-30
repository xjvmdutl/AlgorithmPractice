package progammers.level1;

import java.util.ArrayList;
import java.util.List;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] arr = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		int count = solution(arr,moves);
		System.out.println(count);
	}
	
	
	public static int solution(int[][] board, int[] moves) {
        List<Integer> list = new ArrayList<>();//4311
        int count= 0;
        for(int i=0;i<moves.length;++i){
            for(int j=0;j<board.length;++j){
                int answer = board[j][moves[i]-1];
                
                if(answer > 0){
                    list.add(answer);
                    board[j][moves[i]-1] = 0;
                    if(list.size() >= 2 
                       && list.get(list.size()-1) == list.get(list.size()-2)){
                        list.remove(list.size()-1);
                        list.remove(list.size()-1);
                        count+=2;
                    }
                    break;
                }
            }
        }
        
        return count;
    }
	/*
    public static int solution(int[][] board, int[] moves) {
    	
        int answer = 0;
        List<Integer> basket = new ArrayList<Integer>();
	    for(int i=0;i<moves.length;++i){
	        for(int j=0;j<=board.length-1;++j){
	            if(board[j][moves[i]-1] != 0){
	                basket.add(board[j][moves[i]-1]);
	                board[j][moves[i]-1] = 0;
	                if(answer > 1 && basket.get(answer-1) == basket.get(answer) ){
	                	basket.remove(answer--);
	                	basket.remove(answer--);
	                }
	                answer++;
	                break;
	            }
	        }
	    }
        answer+=1;
	    return answer;
	
	}
	*/
	
}
