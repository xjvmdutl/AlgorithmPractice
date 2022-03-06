package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 폴더정리large {
	public static HashMap<String, HashSet<String>> files = new HashMap<>();
	public static HashMap<String, HashSet<String>> folders;
	public static HashSet<String> result;
	public static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		folders = new HashMap<>();
		files = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n+m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			String p = tokens.nextToken();
			String f = tokens.nextToken();
			String c = tokens.nextToken();
			init(p,f,Integer.parseInt(c) == 0);
		}
		int k = Integer.parseInt(reader.readLine());
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			String start = tokens.nextToken();
			String end = tokens.nextToken();
			move(start.split("/"), end.split("/"));
		}
		
		int q = Integer.parseInt(reader.readLine());
		for(int i=0;i<q;++i) {
			String query = reader.readLine();
			sb.append(Query(query.split("/")) + "\n");
		}
		System.out.println(sb.toString());
	}


	private static String Query(String[] querys) {
		String target = querys[querys.length-1];
		count = 0;
		result = new HashSet<>();
		dfs(target);
		return result.size() + " " + count;
	}


	private static void dfs(String target) {
		if(files.get(target) != null) {
			for(String file : files.get(target)) {
				count++;
				result.add(file);
			}
		}
		if(folders.get(target) != null) {
			for(String folder : folders.get(target)) {
				dfs(folder);
			}
		}
	}


	private static void move(String[] starts, String[] ends) {
		String target = starts[starts.length-1];
		String dest = ends[ends.length-1];
		if(files.get(target) != null) { //타겟에 파일 존재
			if (files.get(dest) == null) //목적지에 파일 생성 
				files.put(dest, new HashSet<>());
			for(String file : files.get(target)) {
				files.get(dest).add(file);
			}
		}
		if(folders.get(target) != null) { //타겟에 폴더가 있다면
			if(folders.get(dest) ==null) {
				folders.put(dest, new HashSet<>());
			}
			for(String folder : folders.get(target)) {
				folders.get(dest).add(folder);
			}
		}
		String parent = starts[starts.length-2]; // 부모
		folders.get(parent).remove(target);//부모에서 제거
	}


	private static void init(String p, String f, boolean isfile) {
		if(isfile) {
			if(!files.containsKey(p)) {
				files.put(p, new HashSet<String>());
			}
			files.get(p).add(f);
		}else {
			if(!folders.containsKey(p)) { //부모 폴더 없다면
				folders.put(p, new HashSet<>());
			}
			folders.get(p).add(f);
		}
	}

}
