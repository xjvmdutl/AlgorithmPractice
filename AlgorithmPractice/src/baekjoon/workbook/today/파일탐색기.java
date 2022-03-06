package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ÆÄÀÏÅ½»ö±â {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] strs = new String[n];
		for(int i=0;i<n;++i) {
			strs[i] = reader.readLine();
		}
		System.out.println(solution(strs,n ));
	}

	private static String solution(String[] strs, int n) {
		List<String>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i]= new ArrayList<String>();
			if(strs[i].length() <= 0)
				continue;
			boolean isLetter = Character.isAlphabetic(strs[i].charAt(0));
			StringBuilder sb = new StringBuilder();
			for(char c : strs[i].toCharArray()) {
				if(isLetter && Character.isDigit(c)) {
					isLetter = false;
					list[i].add(sb.toString());
					sb = new StringBuilder();
					sb.append(c);
				}else if(Character.isDigit(c)) {
					sb.append(c);
				}else if(!isLetter && Character.isAlphabetic(c)) {
					isLetter = true;
					list[i].add(sb.toString());
					sb = new StringBuilder();
					sb.append(c);
				}else {
					sb.append(c);
				}
			}
			if(sb.length() > 0) {
				list[i].add(sb.toString());
			}
		}
		Arrays.sort(list, (o1, o2)->{
			int length = Math.min(o1.size(), o2.size());
			for(int i=0;i<length;++i) {
				String str1 = o1.get(i);
				String str2 = o2.get(i);
				if(isNumber(str1) && isLatter(str2)) {
					return 1;
				}else if(isNumber(str1) && isLatter(str2)) {
					return -1;
				}else if(isNumber(str1) && isNumber(str2)) {
					int zeroCount1 = 0;
					String realStr1 = "";
					int zeroCount2 = 0;
					String realStr2 = "";
					for(int j=0;j<str1.length();++j) {
						if(str1.charAt(j) == '0') {
							zeroCount1++;
						}else {
							realStr1 = str1.substring(j);
							break;
						}
					}
					for(int j=0;j<str2.length();++j) {
						if(str2.charAt(j) == '0') {
							zeroCount2++;
						}else {
							realStr2 = str2.substring(j);
							break;
						}
					}
					if(realStr1.equals(realStr2)) {
						if (zeroCount1 < zeroCount2)
							return 1;
						else if (zeroCount1 > zeroCount2)
							return -1;
					}else {
						if(realStr1.length() < realStr2.length()) {
							return 1;
						}else if(realStr1.length() > realStr2.length()) {
							return -1;
						}else {
							for (int j = 0; j < realStr1.length(); j++){
								if (realStr1.charAt(j) < realStr2.charAt(j))
									return 1;
								else if (realStr1.charAt(j) > realStr2.charAt(j))
									return -1;
							}
						}
					}
				}else if(isLatter(str1)&& isLatter(str2)) {
					int minLength = Math.min(str1.length(), str2.length());
					for(int j=0;j<minLength;++j) {
						char c1 = str1.charAt(j);
						char c2 = str2.charAt(j);
						if(Character.toLowerCase(c1) < Character.toLowerCase(c2)) {
							return 1;
						}else if(Character.toLowerCase(c1) > Character.toLowerCase(c2)) {
							return -1;
						}else {
							if(Character.isLowerCase(c1) && Character.isUpperCase(c2)) {
								return 1;
							}else if(Character.isUpperCase(c1) && Character.isLowerCase(c2)) {
								return -1;
							}
						}
					}
					if(str1.length() < str2.length()) {
						return 1;
					}else if(str1.length() > str2.length()) {
						return -1;
					}
				}
			}
			if (o1.size() < o2.size())
				return 1;
			else
				return -1;
		});
		StringBuilder answer = new StringBuilder();
		for(List<String> str : list) {
			StringBuilder sb = new StringBuilder();
			for(String s: str) {
				sb.append(s);
			}
			answer.append(sb.toString() + "\n");
		}
		return answer.toString();
	}
	private static boolean isLatter(String str) {
		return Character.isAlphabetic(str.charAt(0));
	}
	private static boolean isNumber(String str) {
		return Character.isDigit(str.charAt(0));
	}


}
