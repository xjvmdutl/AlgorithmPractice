package progammers.level2;


import java.util.Arrays;
import java.util.Comparator;


public class 파일명정렬 {
	public static String[] solution(String[] files) {
		Arrays.sort(files,new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				String[] s1 = detach(o1);
			String[] s2 = detach(o2);
			
				int head = s1[0].compareTo(s2[0]);
				if(head == 0) {
					int num1 = Integer.parseInt(s1[1]);
					int num2 = Integer.parseInt(s2[1]);
					return num1 - num2;
				}else {
					return head;
				}
			}

			private String[] detach(String str) {
				String head = "";
				String number = "";
				String tail = "";
				boolean flag =false;
				int startNumIdx = -1;
				int endNumIdx = -1;
				for(int i=0;i<str.length();++i) {
					char c = str.charAt(i);
					if(!flag && Character.isDigit(c)) {
						startNumIdx =i;
						flag = true;
					}else if(flag && !Character.isDigit(c)) {
						endNumIdx = i;
						break;
					}
				}
				head = str.substring(0,startNumIdx).toUpperCase();
				if(endNumIdx != -1) {
					number = str.substring(startNumIdx,endNumIdx);
					tail = str.substring(endNumIdx);
				}else {
					number = str.substring(startNumIdx);
				}
				
				return new String[] {head,number,tail};
			}
		});
		return files;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//파일명	HEAD	NUMBER	TAIL
		//foo9.txt	foo	9	.txt
		//foo010bar020.zip	foo	010	bar020.zip
		//F-15	F-	15	(빈 문자열)
		String[] s1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] result1 = solution(s1);
		for(String s : result1)
			System.out.print(s + " ");
		String[] s2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] result2 = solution(s2);
		for(String s : result2)
			System.out.print(s + " ");
	}

}
