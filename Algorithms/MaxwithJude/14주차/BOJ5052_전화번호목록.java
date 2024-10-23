import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	static class TrieNode{
		Map<Character, TrieNode> childNode = new HashMap<>();
		boolean terminal;
		
		TrieNode(){
		}
		//문자열 입력 시 
		public void insert(String word) {
			TrieNode trieNode = this;
			for(int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				
				// tmp childNode에 c없으면 추가 
				trieNode.childNode.putIfAbsent(c, new TrieNode());
				trieNode = trieNode.childNode.get(c);
				
				// 마지막 문자 terminal 
				if(i== word.length()-1) {
					trieNode.terminal = true;
					return;
				}
			}
		}
		
		public boolean contains(String word) { 
			TrieNode trieNode = this;
			for(int i=0; i<word.length(); i++) {
				char c= word.charAt(i);
				TrieNode node = trieNode.childNode.get(c);
				
				if(node == null) {
					return false;
				}
				trieNode = node;
			}
			
			// 해당 단어로 종료하는 문자가 있는 경우 false 
			if(trieNode.terminal) {
				if(trieNode.childNode.isEmpty()) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n= Integer.parseInt(br.readLine());
			TrieNode trie = new TrieNode();
			boolean isConsistent = true;
			
			List<String> keyList = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				String str = br.readLine();
				trie.insert(str);
				keyList.add(str);
			}
			
			for(String key : keyList) {
				if(trie.contains(key)) {
					isConsistent = false;
					break;
				}
			}
			System.out.println(isConsistent?"YES":"NO");
		}
	}
}
