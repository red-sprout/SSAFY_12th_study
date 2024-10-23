package aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	static class TrieNode{
		Map<Character, TrieNode> childNode = new HashMap<>();
		boolean isend;
		
		TrieNode(){
		}
		//word배열 입력
		public void insert(String word) {
			TrieNode trieNode = this;
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				//없으면 추가하기
				trieNode.childNode.putIfAbsent(c, new TrieNode());
				trieNode = trieNode.childNode.get(c);
				
				//마지막 문자인지
				if(i == word.length()-1) {
					trieNode.isend = true;
					return;
				}
			}
		}
		//queries가 어떻게 포함되고 있는지 
		public int iscontain(String word) {
			int ans = 0;//초기화
			
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				//queries의 한 char가 ?이면 
				if(c == '?') {

				}//특정 알파벳이면 각 깊이에 해당하는 char와 맞는지 확인
				else {
					ans++;
				}
				
			}
			
			return ans;
		}
	}
	static String words[];
	static String queries[];
	static int ans[];
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		words = new String[n];
		queries = new String[m]; //배열 선언
		//검사 원본 words 입력 
		TrieNode trie = new TrieNode();
		for(int i = 0; i < n; i++) {
			words[i] = br.readLine();
			
			trie.insert(words[i]); //트라이에 입력해 놓기
		}
		ans = new int[m];
		for(int i = 0; i < m; i++) {
			queries[i] = br.readLine();
//			TrieNode trie = new TrieNode();//입력한 트라이에 비교 queries랑 대조
			ans[i] = trie.iscontain(queries[i]);

		}
		System.out.println(ans.toString());
	}
	
}
-----------------------------------------------------------------------
//gpt 답변 
  
  
  package aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	static class TrieNode {
		Map<Character, TrieNode> childNode = new HashMap<>();
		boolean isEnd;

		TrieNode() {
		}

		// 단어 삽입 메서드
		public void insert(String word) {
			TrieNode trieNode = this;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				// 없으면 자식 노드에 추가
				trieNode.childNode.putIfAbsent(c, new TrieNode());
				trieNode = trieNode.childNode.get(c);

				// 마지막 문자인 경우
				if (i == word.length() - 1) {
					trieNode.isEnd = true;
				}
			}
		}

		// 와일드카드를 포함한 단어가 트라이에 포함되는지 확인하고 개수 세기
		public int countMatches(String word, int index) {
			// 더 이상 탐색할 문자가 없는 경우, 끝에 도달했으면 1을 반환
			if (index == word.length()) {
				return this.isEnd ? 1 : 0;
			}

			char c = word.charAt(index);
			int count = 0;

			// 와일드카드인 경우, 모든 자식 노드를 탐색하여 가능한 경로 모두 카운트
			if (c == '?') {
				for (TrieNode child : childNode.values()) {
					count += child.countMatches(word, index + 1);
				}
			}
			// 특정 문자인 경우
			else {
				TrieNode nextNode = childNode.get(c);
				if (nextNode != null) {
					count += nextNode.countMatches(word, index + 1);
				}
			}

			return count;
		}
	}

	static String words[];
	static String queries[];
	static int ans[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 단어 개수
		int m = Integer.parseInt(br.readLine()); // 쿼리 개수

		words = new String[n];
		queries = new String[m]; // 쿼리 배열 선언

		// 길이에 따른 Trie 배열 생성
		TrieNode[] tries = new TrieNode[10001]; // 단어 최대 길이를 10000으로 가정

		// 트라이 배열 초기화
		for (int i = 0; i < 10001; i++) {
			tries[i] = new TrieNode();
		}

		// 단어 입력 및 트라이에 삽입 (길이에 따른 트라이에 삽입)
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			int len = words[i].length();
			tries[len].insert(words[i]); // 각 길이에 맞는 트라이에 삽입
		}

		ans = new int[m]; // 결과 배열

		// 쿼리 처리
		for (int i = 0; i < m; i++) {
			queries[i] = br.readLine();
			int len = queries[i].length();
			// 해당 길이의 트라이에서만 탐색
			ans[i] = tries[len].countMatches(queries[i], 0);
		}

		// 결과 출력
		for (int i = 0; i < m; i++) {
			System.out.println(ans[i]); // 각 쿼리에 대해 일치하는 단어 개수 출력
		}
	}
}
