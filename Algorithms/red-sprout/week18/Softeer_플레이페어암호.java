import java.io.*;
import java.util.*;

public class Main {
    static String msg, key;
    static char[][] map;
    static int[][] pos;
    static List<String> list;
    static void initKey() {
        char[] letter = msg.toCharArray();
        list = new ArrayList<>();
        int idx = 0;
        while(idx < letter.length) {
            if(idx == letter.length - 1) {
                list.add("" + letter[idx] + 'X');
                break;
            }
            if(letter[idx] == letter[idx + 1]) {
                list.add("" + letter[idx] + (letter[idx] == 'X' ? 'Q' : 'X'));
                idx += 1;
            } else {
                list.add("" + letter[idx] + letter[idx + 1]);
                idx += 2;
            }
        }
    }
    static void initMap() {
        int idx = 0;
        map = new char[5][5];
        pos = new int[26][2];
        boolean[] used = new boolean[26];
        for(int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if(used[c - 'A']) continue;
            used[c - 'A'] = true;
            int row = idx / 5;
            int col = idx % 5;
            map[idx / 5][idx % 5] = c;
            pos[c - 'A'][0] = row;
            pos[c - 'A'][1] = col;
            idx++;
        }
        for(int i = 0; i < 26; i++) {
            if(i == 'J' - 'A' || used[i]) continue;
            char c = (char) (i + 'A');
            int row = idx / 5;
            int col = idx % 5;
            map[idx / 5][idx % 5] = c;
            pos[i][0] = row;
            pos[i][1] = col;
            idx++;
        }
    }
    static String getStr() {
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(change(str));
        }
        return sb.toString();
    }
    static String change(String str) {
        char c0 = str.charAt(0);
        char c1 = str.charAt(1);
        int[] p0 = pos[c0 - 'A'];
        int[] p1 = pos[c1 - 'A'];
        if(p0[0] == p1[0]) {
            c0 = map[p0[0]][(p0[1] + 1) % 5];
            c1 = map[p1[0]][(p1[1] + 1) % 5];
        } else if(p0[1] == p1[1]) {
            c0 = map[(p0[0] + 1) % 5][p0[1]];
            c1 = map[(p1[0] + 1) % 5][p1[1]];
        } else {
            c0 = map[p0[0]][p1[1]];
            c1 = map[p1[0]][p0[1]];
        }
        return "" + c0 + c1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        msg = br.readLine();
        key = br.readLine();
        initKey();
        initMap();
        System.out.println(getStr());
        br.close();
    }
}
