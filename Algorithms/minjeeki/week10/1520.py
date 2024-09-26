import sys

sys.setrecursionlimit(10 ** 6)

dx = (-1, 1, 0, 0)
dy = (0, 0, -1, 1)

def ft_backtracking(cx, cy):
    global cnt, visited
    # 기저 조건
    if cx == M - 1 and cy == N - 1:
        cnt += 1
        return
    # 재귀
    can_move = 0
    for i in range(4):
        nx = cx + dx[i]
        ny = cy + dy[i]
        if 0 <= nx < M and 0 <= ny < N and \
            (nx, ny) not in visited and matrix[cx][cy] > matrix[nx][ny]:
            visited.add((nx, ny))
            ft_backtracking(nx, ny)
            visited.remove((nx, ny))
        else:
            can_move += 1
    if can_move == 4:
        return




M, N = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(M)]
cnt = 0
visited = set()
visited.add((0, 0))
ft_backtracking(0, 0)
print(cnt)