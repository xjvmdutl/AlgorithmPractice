package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 뉴턴의사과 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int[] treeA = new int[27];
			int[] treeB = new int[27];
			List<Integer> listA = getStr(new StringTokenizer(reader.readLine()));
			int root1 = makeTree(treeA, listA);
			List<Integer> listB = getStr(new StringTokenizer(reader.readLine()));
			int root2 = makeTree(treeB, listB);
            boolean answer = root1 == root2;
            for(int i=1;i<27;++i) {
            	if(!(answer &= (treeA[i] == treeB[i]))) {
            		break;
            	}
            }
            System.out.println(answer ? "true" : "false");
		}
	}

	private static int makeTree(int[] tree, List<Integer> list) {
		Stack<Integer> stack = new Stack<>();
		for(int now : list) {
			if(now == 0) {
				stack.push(0);
			}else {
				if(stack.size() >= 2) {
					int right = stack.pop();
					int left = stack.pop();
					tree[right] = now;
					tree[left] = now;
				}
				stack.push(now);
			}
		}
		if(stack.size() == 0) {
			return 0;
		}else {
			return stack.peek();
		}
	}

	private static List<Integer> getStr(StringTokenizer tokens) {
		List<Integer> list = new ArrayList<>();
		while(tokens.hasMoreTokens()) {
			String str = tokens.nextToken();
			if(str.equals("end")) {
				break;
			}
			if(str.equals("nil")) {
				list.add(0);
			}else {
				list.add(str.charAt(0) - 64);
			}
		}
		return list;
	}

}
