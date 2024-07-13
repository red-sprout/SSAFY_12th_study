import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        int i = 0;
        int result = 0;

        while (i < word.length()) {
            if (word.charAt(i) == 'c' && i + 1 < word.length() && (word.charAt(i + 1) == '=' || word.charAt(i + 1) == '-')) {
                i += 2;
            } else if (word.charAt(i) == 'd') {
                if (i + 1 < word.length() && word.charAt(i + 1) == '-') {
                    i += 2;
                } else if (i + 2 < word.length() && word.charAt(i + 1) == 'z' && word.charAt(i + 2) == '=') {
                    i += 3;
                } else {
                    i += 1;
                }
            } else if ((word.charAt(i) == 'l' || word.charAt(i) == 'n') && i + 1 < word.length() && word.charAt(i + 1) == 'j') {
                i += 2;
            } else if ((word.charAt(i) == 's' || word.charAt(i) == 'z') && i + 1 < word.length() && word.charAt(i + 1) == '=') {
                i += 2;
            } else {
                i += 1;
            }
            result += 1;
        }

        System.out.println(result);
    }
}
