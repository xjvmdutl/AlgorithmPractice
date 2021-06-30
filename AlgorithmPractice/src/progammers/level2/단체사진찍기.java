package progammers.level2;

import java.util.HashMap;

public class 단체사진찍기 {
	public static boolean[] visited;
	public static int[] position;
	public static int answer;
	public static HashMap<Character, Integer> kakao ;
	public static int solution(int n, String[] data) {
        answer = 0;
        visited = new boolean[8];
        position = new int[8];
        kakao = new HashMap<>();
        kakao.put('A',0);
        kakao.put('C',1);
        kakao.put('F',2);
        kakao.put('J',3);
        kakao.put('M',4);
        kakao.put('N',5);
        kakao.put('R',6);
        kakao.put('T',7);
        bfs(0,data);//index,data
        return answer;
    }
	private static void bfs(int index, String[] data) {
		if(index == 8) {
			if(isOkay(data)) {
				answer++;
			}
			return;
		}
		
		for(int i=0;i<8;++i) {
			if(!visited[i]) {
				visited[i] = true;
				position[index] = i;
				bfs(index+1,data);
				visited[i] = false;
			}
		}
	}
	private static boolean isOkay(String[] data) {
		for(int i =0;i<data.length;++i) {
			int x=kakao.get(data[i].charAt(0));
			int y=kakao.get(data[i].charAt(2));
			char type = data[i].charAt(3);
			int diff = data[i].charAt(4) - '0';
			int Xpos = position[x];
            int Ypos = position[y];
            if ( type == '='){    
                if ( Math.abs( Xpos - Ypos)-1 != diff){
                    
                    return false;
                }
                
            } else if ( type == '>'){
                if ( Math.abs(Xpos - Ypos )-1 <= diff){
                    
                    return false;
                }
                
                
            } else if ( type == '<') {
                if ( Math.abs(Xpos - Ypos )-1 >= diff){
                    
                    return false;
                }
            }
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n	data	answer
		//2	["N~F=0", "R~T>2"]	3648
		//2	["M~C<2", "C~M>1"]	0
		int n1 = 2;
		int n2 = 2;
		String[] data1 = {"N~F=0", "R~T>2"};
		String[] data2 = {"M~C<2", "C~M>1"};
		System.out.println(solution(n1, data1));
		System.out.println(solution(n2, data2));
	}

}
