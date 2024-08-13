# 입력 처리
N, M, H = map(int, input().split())

# 초기화: 사다리 정보를 저장할 2차원 리스트
ladder = [[0] * (N+1) for _ in range(H+1)]

# 가로선 정보 입력
for _ in range(M):
    a, b = map(int, input().split())
    ladder[a][b] = 1

def check():
    for i in range(1, N+1):
        pos = i
        for j in range(1, H+1):
            if ladder[j][pos] == 1:
                pos += 1
            elif pos > 1 and ladder[j][pos-1] == 1:
                pos -= 1
        if pos != i:
            return False
    return True

def dfs(count, x, y):
    global answer
    if check():
        answer = min(answer, count)
        return
    if count == 3 or count >= answer:
        return

    for i in range(x, H+1):
        for j in range(y if i == x else 1, N):
            if ladder[i][j] == 0 and ladder[i][j-1] == 0 and ladder[i][j+1] == 0:
                ladder[i][j] = 1
                dfs(count + 1, i, j + 2)
                ladder[i][j] = 0
        y = 1

answer = 4
dfs(0, 1, 1)
print(answer if answer < 4 else -1)
