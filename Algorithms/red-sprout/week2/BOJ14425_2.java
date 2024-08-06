import java.io.*;

class Node {
    Node[] nodes = new Node[26];
    boolean isEnd = false;
}

class Trie {
    private Node root = new Node();
    
    public void insert(String str) {
        Node node = root;
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(node.nodes[idx] == null)
                node.nodes[idx] = new Node();
            node = node.nodes[idx];
        }
        node.isEnd = true;
    }
    
    public boolean search(String str) {
        Node node = root;
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(node.nodes[idx] == null)
                return false;
            node = node.nodes[idx];
        }
        return node.isEnd;
    }
}

public class BOJ14425_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        
        for(int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }
        
        int result = 0;
        for(int j = 0; j < m; j++) {
            if(trie.search(br.readLine())) result++;
        }
        
        System.out.println(result);
        br.close();
    }
}
