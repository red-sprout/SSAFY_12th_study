from collections import deque

# 상하좌우랑 대각선도 봐야함 (대각선 볼거면 이게 왜 섬 한개야)
deltas = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]

def bfs(grid, start, alphabet):
    rows, cols = len(grid), len(grid[0])
    queue = deque([start])
    grid[start[0]][start[1]] = alphabet  # 방문한 곳을 alphabet로 바꾸기

    while queue:
        x, y = queue.popleft()

        # 동서남북 탐색
        for dx, dy in deltas:
            nx, ny = x + dx, y + dy

            if 0 <= nx < rows and 0 <= ny < cols and grid[nx][ny] == 1:
                queue.append((nx, ny))
                grid[nx][ny] = alphabet

def count_islands(grid):
    cnt_islands = 0
    cur_alphabet = 'A'

    for i in range(h):
        for j in range(w):
            if grid[i][j] == 1:
                bfs(grid, (i, j), cur_alphabet)
                cnt_islands += 1
                cur_alphabet = chr(ord(cur_alphabet) + 1)

    return cnt_islands

while True:
    # 입력값 처리
    w, h = map(int, input().split())
    # 종료 조건
    if w == 0 and h == 0:
        break
    # 테스트 케이스 처리
    grid = [list(map(int, input().split())) for _ in range(h)]
    # print(*grid, sep='\n')
    result = count_islands(grid)
    # print(*grid, sep='\n')
    print(result)