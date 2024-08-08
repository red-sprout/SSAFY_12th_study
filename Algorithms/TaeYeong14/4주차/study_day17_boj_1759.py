L, C = map(int, input().split())
words = sorted(list(map(str, input().split())))
consonant = ['a', 'e', 'i', 'o', 'u']
answer = []

def back_tracking(cnt, idx):
    if cnt == L:
        vo, co = 0, 0

        for i in range(L):
            if answer[i] in consonant:
                vo += 1
            else:
                co += 1

        if vo >= 1 and co >= 2:
            print("".join(answer))

        return

    for i in range(idx, C):
        answer.append(words[i])
        back_tracking(cnt + 1, i + 1)
        answer.pop()

back_tracking(0, 0)
