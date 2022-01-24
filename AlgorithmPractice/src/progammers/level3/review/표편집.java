package progammers.level3.review;

import java.util.Stack;

public class Ç¥ÆíÁý {
	public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        for(String command : cmd) {
        	String[] c= command.split(" ");
        	switch (c[0]) {
			case "U": 
				k -= Integer.parseInt(c[1]);
				if(k < 0)
					k = 0;
				break;
			case "D": 
				k += Integer.parseInt(c[1]);
				if(k >= n)
					k = n-1;
				break;
			case "C": 
				stack.push(k);
				n--;
				if(k == n)
					k -= 1;
				break;
			case "Z": 
				int now = stack.pop();
				if(now <= k) {
					k += 1;
				}
				n++;
				break;
        	}
        }
        StringBuilder sb =  new StringBuilder();
        for(int i=0;i<n;++i) {
        	sb.append("O");
        }
        while(!stack.isEmpty()) {
        	sb.insert(stack.pop(), "X");
        }
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		//n	k	cmd	result
		//8	2	["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]	"OOOOXOOO"
		//8	2	["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"]	"OOXOXOOO"
		String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		System.out.println(solution(8,2,cmd1));
		String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(solution(8,2,cmd2));
	}

}
