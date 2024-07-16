import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2941 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();        
        String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		int index = 0;

		for (int i = 0; i < croatia.length; i++) {		
            index = a.indexOf(croatia[i]);            
			if (index >= 0) { 
				a = a.replaceAll(croatia[i], "A");
			}
		}
		System.out.println(a.length());
	}
}