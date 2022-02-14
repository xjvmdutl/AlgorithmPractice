package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class HTMLÆÄ½Ì {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		StringBuilder sb = new StringBuilder();
		String main = str.substring(str.indexOf("<main>")+"<main>".length(), str.indexOf("</main>"));
		int index;
		while((index = main.indexOf("<div ")) != -1) {
			int lastMainIndex = main.indexOf("</div>");
			String div = main.substring(index + "<div ".length(), lastMainIndex);
			main = main.substring(lastMainIndex + "</div>".length());
			String title = div.substring(div.indexOf("title=")+"title=\"".length(),div.indexOf("\">"));
			sb.append("title : " + title + "\n");
			int pIndex;
			while((pIndex = div.indexOf("<p>")) != -1) {
				int lastDivIndex = div.indexOf("</p>");
				StringBuilder p = new StringBuilder(div.substring(pIndex + "<p>".length(), lastDivIndex));
				div = div.substring(lastDivIndex + "</p>".length());
				int startIdx = 0;
				for(int i=0;i<p.length();++i) {
					if(p.charAt(i) != ' ') {
						startIdx = i;
						break;
					}
				}
				Stack<Character> stack = new Stack<>();
				boolean flag = false;
				for(int i=startIdx;i<p.length();++i) {
					char c = p.charAt(i);
					if(c == '<') {
						flag = true;
					}else if(flag) {
						if(flag && c == '>') {
							flag = false;
						}
					}else if(!stack.isEmpty() && stack.peek() == ' ' && c == ' '){
						continue;
					}else {
						stack.push(c);
					}
				}
				StringBuilder nextP = new StringBuilder();
				boolean islast = false;
				while(!stack.isEmpty()) {
					char c = stack.pop();
					if(!islast && c == ' ') {
						continue;
					}
					islast = true;
					nextP.append(c);
				}
				sb.append(nextP.reverse() + "\n");
			}
			
		}
		return sb.toString();
	}

}
