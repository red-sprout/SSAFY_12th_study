import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        // 단어 길이별로 분류
        Map<Integer, List<String>> wordsByLength = new HashMap<>();
        Map<Integer, List<String>> reversedWordsByLength = new HashMap<>();
        
        // 각 단어를 정방향 및 역방향으로 리스트에 저장
        for (String word : words) {
            int len = word.length();
            wordsByLength.putIfAbsent(len, new ArrayList<>());
            reversedWordsByLength.putIfAbsent(len, new ArrayList<>());
            
            wordsByLength.get(len).add(word);
            reversedWordsByLength.get(len).add(new StringBuilder(word).reverse().toString());
        }
        
        // 각 리스트를 정렬
        for (int len : wordsByLength.keySet()) {
            Collections.sort(wordsByLength.get(len));
            Collections.sort(reversedWordsByLength.get(len));
        }
        
        // 쿼리를 처리
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();
            
            if (!wordsByLength.containsKey(len)) {
                answer[i] = 0;
                continue;
            }
            
            if (query.charAt(0) == '?') {
                String reversedQuery = new StringBuilder(query).reverse().toString();
                answer[i] = countMatches(reversedQuery, reversedWordsByLength.get(len));
            } else {
                answer[i] = countMatches(query, wordsByLength.get(len));
            }
        }
        
        return answer;
    }
    
    // 이진 탐색으로 매칭되는 단어의 개수를 셈
    private int countMatches(String query, List<String> words) {
        String startPattern = query.replace('?', 'a');
        String endPattern = query.replace('?', 'z');
        
        int startIndex = lowerBound(words, startPattern);
        int endIndex = upperBound(words, endPattern);
        
        return endIndex - startIndex;
    }
    
    // 주어진 값보다 크거나 같은 첫 번째 인덱스 찾기
    private int lowerBound(List<String> words, String target) {
        int left = 0, right = words.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (words.get(mid).compareTo(target) >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    // 주어진 값보다 큰 첫 번째 인덱스 찾기
    private int upperBound(List<String> words, String target) {
        int left = 0, right = words.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (words.get(mid).compareTo(target) > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
