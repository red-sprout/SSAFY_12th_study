import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int t = 1; t < 11; t++) {
            int house_num = Integer.parseInt(br.readLine());
            int[] data = new int[house_num];
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < house_num; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
             
            int result = 0;
            for (int i = 2; i < house_num-2; i++) {
                int left_max_house = Math.max(data[i-2], data[i-1]);
                int right_max_house = Math.max(data[i+1], data[i+2]);
                int max_house = Math.max(left_max_house, right_max_house);
                 
                if (data[i] > max_house) {
                    result += (data[i]-max_house);
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
