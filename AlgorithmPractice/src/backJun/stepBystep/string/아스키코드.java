package backJun.stepBystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 아스키코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char c = (char) reader.read();
		System.out.println((int)c);
	}

}
