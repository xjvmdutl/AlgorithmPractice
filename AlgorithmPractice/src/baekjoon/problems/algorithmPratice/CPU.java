package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CPU {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] arr = new String[n];
		for(int i=0;i<n;++i) {
			arr[i] = reader.readLine();
		}
		System.out.println(solution(arr));
	}

	private static String solution(String[] arr) {
		Map<String,String> opcode = new HashMap<>();
		init(opcode);
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<arr.length;++i) {
			StringTokenizer tokens = new StringTokenizer(arr[i]);
			String op = tokens.nextToken();
			sb.append(opcode.get(op) + "0");
			String rd = intToBinary(Integer.parseInt(tokens.nextToken()), 3);
			sb.append(rd);
			String ra = intToBinary(Integer.parseInt(tokens.nextToken()), 3);
			sb.append(ra);

			if(opcode.get(op).charAt(opcode.get(op).length()-1) == '0') {
				//rB
				String rb = intToBinary(Integer.parseInt(tokens.nextToken()), 3);
				sb.append(rb + "0");
			}else {
				//C#
				String c = intToBinary(Integer.parseInt(tokens.nextToken()), 4);
				sb.append(c);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	private static String intToBinary(int n,int length) {
		StringBuilder returns = new StringBuilder(Integer.toBinaryString(n));
		while(returns.length() < length) {
			returns.insert(0, '0');
		}
		return returns.toString();
	}
	private static void init(Map<String, String> opcode) {
		opcode.put("ADD", "00000");
		opcode.put("ADDC", "00001");
		opcode.put("SUB", "00010");
		opcode.put("SUBC", "00011");
		opcode.put("MOV", "00100");
		opcode.put("MOVC", "00101");
		opcode.put("AND", "00110");
		opcode.put("ANDC", "00111");
		opcode.put("OR", "01000");
		opcode.put("ORC", "01001");
		opcode.put("NOT", "01010");
		opcode.put("MULT", "01100");
		opcode.put("MULTC", "01101");
		opcode.put("LSFTL", "01110");
		opcode.put("LSFTLC", "01111");
		opcode.put("LSFTR", "10000");
		opcode.put("LSFTRC", "10001");
		opcode.put("ASFTR", "10010");
		opcode.put("ASFTRC", "10011");
		opcode.put("RL", "10100");
		opcode.put("RLC", "10101");
		opcode.put("RR", "10110");
		opcode.put("RRC", "10111");
	}

}
