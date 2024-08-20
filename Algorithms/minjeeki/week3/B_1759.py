# def 재귀
def make_word(start, lst, word, L):
    if len(word) == L:
        return word
    for idx in range(start,C):
        word.append(lst[idx])
        return make_word(idx+1, lst, word, L)

# 입력값 받기
L, C = map(int, input().split())
c_lst = sorted(input().split())
print('sorted lst: ', c_lst)
for idx in range(C):
    word = []
    print(make_word(idx, c_lst, word, L))

