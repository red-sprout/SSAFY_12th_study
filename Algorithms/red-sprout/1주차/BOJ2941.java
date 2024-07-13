// 크로아티아 알파벳
import java.io.*;
import java.util.*;

public class BOJ2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.replaceAll("(c=|c-|dz=|d-|lj|nj|s=|z=|[a-z])", "*");
		System.out.println(str.length());
		br.close();
	}
}
