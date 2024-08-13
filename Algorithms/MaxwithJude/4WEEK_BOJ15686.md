```import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Decart{
	int x;
	int y;
	
	Decart(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m;
	static int [][] arr;
	static ArrayList<Decart> house;
	static ArrayList<Decart> chicken;
	static int ans;
	static boolean[] open;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		//0, 0이 아닌 1, 1부터 시작함에 주의
		for(int i = 0; i<n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
				//순회 후 집일때와 치킨집일때 따로 저장 
				if(arr[i][j] == 1) {
					house.add(new Decart(i, j));
				}else if(arr[i][j] == 2) {
					chicken.add(new Decart(i, j));
				}
			}
		}
		
	ans = Integer.MAX_VALUE;
	open = new boolean[chicken.size()];
	
	DFS(0, 0);
	System.out.println(ans + "\n");
		//0 empty 1 집 2 치킨집
		
		
		
	}
	
	public static void DFS(int start, int cnt) {
		//m과 치킨집 개수가  같으면 삭제할 게 없다. 
		if(cnt == m) {
			int res = 0;
			
			for(int i = 0; i < house.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for(int j = 0; j < chicken.size(); j++) {
					if(open[j]) {
						int distance = Math.abs(house.get(i).x - chicken.get(j).x)
								+ Math.abs(house.get(i).y - chicken.get(j).y);
						
						temp = Math.min(temp, distance);
					}
				}
				res += temp;
			}
		
			ans = Math.min(ans, res);
			return;
	}	for(int i = start; i<chicken.size(); i++) {
		open[i] = true;
		DFS(i + 1, cnt +1);
		open[i] = false;
	}
	
}
}
```
