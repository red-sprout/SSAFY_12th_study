import java.util.*;

class Solution {
    class Node {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Character, Node> children = new HashMap<>();
    }
    
    class Trie {
        Node root = new Node();
        void add(String str) {
            Node node = root;
            int length = str.length();
            for(int i = 0; i < length; i++) {
                char c = str.charAt(i);
                node.children.putIfAbsent(c, new Node());
                node.count.put(length - i, node.count.getOrDefault(length - i, 0) + 1);
                node = node.children.get(c);
            }
            node.count.put(0, node.count.getOrDefault(0, 0) + 1);
        }
        int count(String str) {
            Node node = root;
            int length = str.length();
            for(int i = 0; i < length; i++) {
                char c = str.charAt(i);
                if(c == '?') return node.count.getOrDefault(length - i, 0);
                if(!node.children.containsKey(c)) return 0;
                node = node.children.get(c);
            }
            return node.count.getOrDefault(0, 0);
        }
    }
    
    String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public int[] solution(String[] words, String[] queries) {
        Trie prefix = new Trie();
        Trie postfix = new Trie();
        int[] answer = new int[queries.length];
        for(String s : words) {
            prefix.add(s);
            postfix.add(reverse(s));
        }
        for(int i = 0; i < queries.length; i++) {
            answer[i] = queries[i].charAt(0) == '?' ? postfix.count(reverse(queries[i])) : prefix.count(queries[i]);
        }
        return answer;
    }
}
