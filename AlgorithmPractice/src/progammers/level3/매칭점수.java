package progammers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class WebPage{
	int index;
	String url;
	double basicScore;
	List<String> links = new ArrayList<>();
	double totalScore;
	public WebPage(int index,String url,double basicScore) {
		this.basicScore = basicScore;
		this.index = index;
		this.url = url;
	}
}
public class ¸ÅÄªÁ¡¼ö {
	
	public static int solution(String word, String[] pages) {
		int answer = 0;
		word = word.toLowerCase();
		List<WebPage> list = new ArrayList<>();
		for(int i=0;i<pages.length;++i) {
			pages[i] = pages[i].toLowerCase();
			String url = getUrl(pages[i]);
			String body = "<body>";
			int startPoint = pages[i].indexOf(body) + body.length();
			int endPoint = pages[i].indexOf("</body>",startPoint);
			double basicScore = getNomalScore(pages[i].substring(startPoint,endPoint),word);
			WebPage web = new WebPage(i, url, basicScore);
			getLink(web,pages[i]);
			web.totalScore = basicScore;
			list.add(web);
		}
		for(int i = 0;i<list.size();++i) {
        	List<String> tempList = list.get(i).links;
        	for(int j = 0; j < list.size(); j++) {
        		if(i != j) {
        			if(tempList.contains(list.get(j).url)) {
        				list.get(j).totalScore += (double)(list.get(i).basicScore / (double)list.get(i).links.size());
        			}
        		}
        	}
        }
		Collections.sort(list,(o1,o2)->{
			if(o1.totalScore == o2.totalScore)
				return o1.index - o2.index;
			return Double.compare(o2.totalScore, o1.totalScore);
		});
		return list.get(0).index;
	}
	private static void getLink(WebPage web, String page) {
		String link = "<a href=\"";
		int start = 0;
		while(true) {
			int new_start = page.indexOf(link,start) + link.length();
			int new_end = page.indexOf("\"",new_start);
			if(new_start == link.length() - 1)
				break;
			start = new_start;
			web.links.add(page.substring(new_start,new_end));
		}
	}
	private static double getNomalScore(String content, String word) {
		int score = 0;
		for(char c : content.toCharArray()) {
    		if(c < 'a' || c > 'z') {
    			content = content.replace(c, ' ');
    		}
		}
		String[] temp = content.split(" ");
		for(int i=0;i<temp.length;++i)
			if(temp[i].equals(word))
				score++;
		return score;
	}
	private static String getUrl(String page) {
		String urlText = "<meta property=\"og:url\" content=\""; 
		int startPoint = page.indexOf(urlText) + urlText.length();
    	int endPoint = page.indexOf("\"", startPoint);
    	return page.substring(startPoint, endPoint);
	}
	public static void main(String[] args) {
		String[] pages1 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		System.out.println(solution("blind",pages1));
		String[] pages2 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		System.out.println(solution("Muzi",pages2));
	}

}
