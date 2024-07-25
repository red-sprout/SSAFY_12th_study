import java.io.*;
import java.util.*;

public class BOJ14425_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Set<String> set = new HashSet<>();
        
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
        	set.add(br.readLine());
        }
        
        String str = null;
        for(int i = 0; i < m; i++) {
        	str = br.readLine();
        	if(set.contains(str)) {
        		ans++;
        	}
        }
        System.out.println(ans);
        br.close();
    }
}
