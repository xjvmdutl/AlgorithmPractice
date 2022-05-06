package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 폴더정리small {
	private static Set<String> compareFiles;
	private static int fileCount;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n  = Integer.parseInt(tokens.nextToken());
		int m  = Integer.parseInt(tokens.nextToken());
		Map<String, HashSet<String>> folders = new HashMap<>();
		Map<String, HashSet<String>> files = new HashMap<>();
		for(int i=0;i<n+m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			String p = tokens.nextToken();
			String f = tokens.nextToken();
			int c = Integer.parseInt(tokens.nextToken());
			if(isFile(c)) {
				putFile(files, p, f);
			}else if(isFolder(c)){
				putFolder(folders, p, f);
			}
		}
		int q = Integer.parseInt(reader.readLine());
		for(int i=0;i<q;++i) {
			String query = reader.readLine();
			System.out.println(solution(folders, files, query));
		}
	}

	private static boolean isFile(int c) {
		return c == 0;
	}
	
	private static void putFile(Map<String, HashSet<String>> files, String p, String f) {
		if(!files.containsKey(p)) {
			files.put(p, new HashSet<>());
		}
		files.get(p).add(f);
	}
	
	private static boolean isFolder(int c) {
		return c == 1;
	}
	
	private static void putFolder(Map<String, HashSet<String>> folders, String p, String f) {
		if(!folders.containsKey(p)) {
			folders.put(p, new HashSet<>());
		}
		folders.get(p).add(f);
	}
	
	private static String solution(Map<String, HashSet<String>> folders, Map<String, HashSet<String>> files,
			String query) {
		StringBuilder answer = new StringBuilder();
		compareFiles = new HashSet<>();
		fileCount = 0;
		String[] split = query.split("/");
		String last = split[split.length-1];
		find(folders, files, last);
		answer.append(compareFiles.size() + " " + fileCount);
		return answer.toString();
	}

	private static void find(Map<String, HashSet<String>> folders, Map<String, HashSet<String>> files, String folderName) {
		Set<String> childFolders = folders.get(folderName);
		Set<String> childFiles = files.get(folderName);
		if(!isNullChild(childFiles)) {
			fileCount += childFiles.size();
			for(String childFile : childFiles) {
				compareFiles.add(childFile);
			}
		}
		if(!isNullChild(childFolders)) {
			for(String childFolder : childFolders) {
				find(folders, files, childFolder);
			}
		}
	}

	private static boolean isNullChild(Set<String> child) {
		return child == null;
	}
}
