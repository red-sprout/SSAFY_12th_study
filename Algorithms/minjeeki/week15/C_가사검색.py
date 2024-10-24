def solution(words, queries):
    answer = [0] * len(queries)
    for qi in range(len(queries)):
        answer[qi] = 0
        std_word = queries[qi]
        len_s = len(std_word)
        for word in words:
            if len_s != len(word):
                continue
            else:
                si = 0
                while si < len_s:
                    if std_word[si] == '?' or std_word[si] == word[si]:
                        si += 1
                    else:
                       break
                if si == len_s:
                    answer[qi] += 1
    return answer

words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]
print(solution(words, queries))