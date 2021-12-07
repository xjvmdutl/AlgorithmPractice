package progammers.level3;

import java.util.Stack;

public class 표편집 {
	 public static String solution(int n, int k, String[] cmd) {
		StringBuilder sb = new StringBuilder();
        Stack<Integer> cache = new Stack<>();//삭제한 Index
        int tableSize = n;
        int idx = k;
        for(String command : cmd) {
        	String[] c = command.split(" ");
        	if(c[0].equals("U")) {
        		idx -= Integer.parseInt(c[1]);
        	}else if(c[0].equals("D")) {
        		idx += Integer.parseInt(c[1]);
        	}else if(c[0].equals("C")) {
        		tableSize--;
        		cache.push(idx);
        		if(idx == tableSize) {
        			idx--;
        		}
        	}else if(c[0].equals("Z")) {
        		int chart = cache.pop();
        		if(chart <= idx) {
        			idx++;
        		}
        		tableSize++;
        	}
        }
        for(int i=0;i<tableSize;++i) {
        	sb.append("O");
        }
        while(!cache.isEmpty()) {
        	int point = cache.pop();
        	sb.insert(point, "X");
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		int n1 = 1000000;
		int k1 = 2;
		System.out.println(solution(n1,k1,cmd1));
		String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		int n2 = 8;
		int k2 = 2;
		System.out.println(solution(n2,k2,cmd2));
	}

}
