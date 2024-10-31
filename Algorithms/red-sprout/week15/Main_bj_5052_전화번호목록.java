import java.io.*;

public class Main_bj_5052_전화번호목록 {
	static class Node {
		Node[] next = new Node[10];
		boolean isEnd = false;
	}
	
	static class Trie {
		Node root = new Node();
		void add(String str) {
			Node node = root;
			for(int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - '0';
				if(node.next[idx] == null) node.next[idx] = new Node();
				node = node.next[idx];
			}
			node.isEnd = true;
		}
		boolean search(String str) {
			Node node = root;
			for(int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - '0';
				if(node.isEnd) break;
				if(node.next[idx] == null) return false;
				node = node.next[idx];
			}
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			Trie trie = new Trie();
			for(int j = 0; j < n; j++) {
				arr[j] = br.readLine();
			}
			boolean flag = true;
			for(String s : arr) {
				if(trie.search(s)) {
					flag = false;
				}
				trie.add(s);
			}
			sb.append(flag ? "YES" : "NO").append('\n');
		}
		System.out.print(sb.toString());
		br.close();
	}
}
