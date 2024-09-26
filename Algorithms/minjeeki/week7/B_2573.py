from collections import deque

deltas = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(grid, start, visited):
    queue = deque([start])
    visited[start[0]][start[1]] = True

    while queue:
        x, y = queue.popleft()

        for dx, dy in deltas:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and grid[nx][ny] > 0 and not visited[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True

def count_islands(grid):
    visited = [[False] * M for _ in range(N)]
    cnt_island = 0

    for i in range(N):
        for j in range(M):
            if grid[i][j] > 0 and not visited[i][j]:
                bfs(grid, (i, j), visited)
                cnt_island += 1

    return cnt_island

# 초기세팅
N, M = map(int, input().split())
year = 0
cnt_ice_berg = 1
grid = [list(map(int, input().split())) for _ in range(N)]
# 동작
while cnt_ice_berg < 2:
    # 년수 증가
    year += 1
    # 빙산 0 이상 숫자에 일괄 -1 처리
    for i in range(N):
        for j in range(M):
            if grid[i][j] > 0:
                grid[i][j] -= 1
    # print(year)
    # print(*grid, sep='\n')
    # 빙산의 개수 세기
    cnt_ice_berg = count_islands(grid)
    # print(year, cnt_ice_berg)
    # print(*grid, sep='\n')
print(year)