package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] list;
	static boolean ans;
	static boolean [] check;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 노드의 개수
        M = Integer.parseInt(st.nextToken());  // 간선의 개수
        
        list = new ArrayList[N];
        for(int i = 0; i< N; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	list[a].add(b);
        	list[b].add(a);
        }
        ans = false;
        for(int i = 0; i < N; i++) {
        	check = new boolean[N];
        	dfs(i, 1);
        }
        System.out.println(ans ? 1 : 0);
        
	}
	static void dfs(int idx, int level) {
		//인덱스와 레벨
		if(level == 5) {
			ans = true;
			return;
		}
		
		check[idx]=true;
		for(int idx2 : list[idx]) {
			if(!check[idx2]) {
				dfs(idx2, level+1);
			}
		}
		check[idx]=false;
		
	}
}
