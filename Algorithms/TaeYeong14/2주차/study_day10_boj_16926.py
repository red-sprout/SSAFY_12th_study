from collections import deque

N, M, R = map(int,input().split())
matrix = []
deq = deque()
answer = [[0]*M for _ in range(N)]

for n in range(N):
    matrix.append(list(map(int, input().split())))

loops = min(N, M) // 2

for i in range(loops):
    deq.clear()
    deq.extend(matrix[i][i:M-i]) # top
    deq.extend([row[M-i-1] for row in matrix[i+1:N-i-1]]) # right
    deq.extend(matrix[N-i-1][i:M-i][::-1]) # bottom
    deq.extend([row[i] for row in matrix[i+1:N-i-1]][::-1]) # left

    deq.rotate(-R)

    for j in range(i, M - i):  # top
        answer[i][j] = deq.popleft()
    for j in range(i + 1, N - i - 1):  # right
        answer[j][M - i - 1] = deq.popleft()
    for j in range(M - i - 1, i - 1, -1):  # bottom
        answer[N - i - 1][j] = deq.popleft()
    for j in range(N - i - 2, i, -1):  # left
        answer[j][i] = deq.popleft()

for n in range(N):
    for m in range(M):
        print(answer[n][m], end = ' ')
    print()
