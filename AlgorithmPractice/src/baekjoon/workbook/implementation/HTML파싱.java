package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class HTMLÆÄ½Ì {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String html = reader.readLine();
		System.out.println(solution(html));
	}

	private static String solution(String html) {
		StringBuilder answer = new StringBuilder();
		String tags = getMain(html);
		while(isHaveDiv(tags)) {
			int startDiv = tags.indexOf("<div ");
			int endDiv = tags.indexOf("</div>") + "</div>".length();
			String div = getDiv(tags, startDiv, endDiv);
			tags = getRemainDiv(tags, endDiv);
			appendTitle(div, answer);
			appendParagraphs(div, answer);
		}
		return answer.toString();
	}
	
	private static String getMain(String html) {
		int startMain = html.indexOf("<main>") + "<main>".length();
		int endMain = html.indexOf("</main>");
		return html.substring(startMain, endMain);
	}
	
	private static boolean isHaveDiv(String html) {
		int startDiv = html.indexOf("<div ");
		return startDiv >= 0;
	}
	
	private static String getDiv(String html, int startDiv, int endDiv) {
		return html.substring(startDiv, endDiv);
	}
	
	private static String getRemainDiv(String html, int endDiv) {
		return html.substring(endDiv);
	}
	
	private static void appendTitle(String div, StringBuilder answer) {
		String title = getTitle(div);
		answer.append("title : " + title+ "\n");
	}
	
	private static String getTitle(String div) {
		int startTitle = div.indexOf("title=\"") + "title=\"".length();
		int endTitle = div.indexOf("\">");
		return div.substring(startTitle, endTitle);
	}

	private static void appendParagraphs(String div, StringBuilder answer) {
		while(isHaveP(div)) {
			int startPTag = div.indexOf("<p>") + "<p>".length();
			int endPTag = div.indexOf("</p>");
			String p = getPTag(div, startPTag, endPTag);
			div = getRemainP(div, endPTag);
			p = removeTags(p);
			p = removeStartSpaceP(p);
			p = removeEndSpaceP(p);
			p = removeDoubleSpace(p);
			appendParagraph(p, answer);
		}
	}

	private static boolean isHaveP(String div) {
		int startP = div.indexOf("<p>");
		return startP >= 0;
	}
	
	private static String getPTag(String div, int startPTag, int endPTag) {
		return div.substring(startPTag, endPTag);
	}
	
	private static String getRemainP(String div, int endP) {
		return div.substring(endP + "</p>".length());
	}
	
	
	private static String removeTags(String p) {
		StringBuilder answer = new StringBuilder(p);
		while(findTags(answer)) {
			int startTag = answer.indexOf("<");
			int endTag = answer.indexOf(">");
			answer.delete(startTag, endTag + 1);
		}
		return answer.toString();
	}

	private static boolean findTags(StringBuilder answer) {
		return answer.indexOf("<") >= 0;
	}
	
	private static String removeStartSpaceP(String p) {
		StringBuilder answer = new StringBuilder(p);
		for(int i=0;i<p.length();++i) {
			char c = p.charAt(i);
			if(c != ' ') {
				break;
			}
			answer.deleteCharAt(0);
		}
		return answer.toString();
	}
	
	private static String removeEndSpaceP(String p) {
		StringBuilder answer = new StringBuilder(p);
		for(int i=p.length()-1;i>=0;--i) {
			char c = p.charAt(i);
			if(c != ' ') {
				break;
			}
			answer.deleteCharAt(answer.length()-1);
		}
		return answer.toString();
	}
	
	private static String removeDoubleSpace(String p) {
		StringBuilder answer = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		for(char c : p.toCharArray()) {
			if(c == ' ' && stack.peek() == ' ') {
				continue;
			}
			stack.push(c);
			answer.append(c);
		}
		
		return answer.toString();
	}

	private static void appendParagraph(String p, StringBuilder answer) {
		answer.append(p + "\n");
	}
}
