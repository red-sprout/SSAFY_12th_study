from collections import deque
import sys

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# BFS 함수 : 시작점에서 각 지점까지의 최단 거리 계산 -> 모든 지점까지의 최단 거리 반환
def bfs(start, room, h, w):
    dist = [[-1] * w for _ in range(h)]
    dist[start[0]][start[1]] = 0
    queue = deque([start])
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < h and 0 <= ny < w and dist[nx][ny] == -1 and room[nx][ny] != 'x':
                dist[nx][ny] = dist[x][y] + 1
                queue.append((nx, ny))
    
    return dist

# DP와 비트마스크를 사용해 최단 경로 찾음
def tsp(dp, dist_matrix, n):
		# 2^n 개의 상태 모두 탐색
    for mask in range(1 << n):
        for i in range(n):
            if not (mask & (1 << i)):  # i번 더러운 칸을 아직 방문하지 않은 경우
                continue
            for j in range(n):
                if i == j or not (mask & (1 << j)):  # j번 더러운 칸을 방문하지 않음
                    continue
                prev_mask = mask ^ (1 << i)
                # 이전 상태에서 i번 칸을 방문하는 최소 비용으로 업데이트
                dp[mask][i] = min(dp[mask][i], dp[prev_mask][j] + dist_matrix[j][i])

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    room = []
    dirty = []
    start = None              # 로봇의 시작점
    
    for i in range(h):
        line = list(input().strip())
        room.append(line)
        for j in range(w):
            if line[j] == 'o':  # 로봇의 시작 위치
                start = (i, j)
            elif line[j] == '*':  # 더러운 칸
                dirty.append((i, j))
    
    all_points = [start] + dirty
    l = len(all_points)

		# 각 지점 간 최단 거리 저장
    dist_matrix = [[0] * l for _ in range(l)]
    
    for i in range(l):
        dist = bfs(all_points[i], room, h, w)
        for j in range(l):
            dist_matrix[i][j] = dist[all_points[j][0]][all_points[j][1]]

		# 모든 지점 연결 가능 여부 확인
    is_possible = True
    for i in range(l):
        for j in range(l):
            # 도달 불가 지점 존재
            if dist_matrix[i][j] == -1:
                is_possible = False
                break
        if not is_possible:
            break
    # 도달 불가 처리
    if not is_possible:
        print(-1)
        continue
    
    # DP + 비트마스크를 위한 테이블 초기화
    n = len(dirty) + 1  # 시작점과 더러운 칸 수
    INF = sys.maxsize
    dp = [[INF] * n for _ in range(1 << n)]  # 2^n 개의 상태, DP 테이블 초기화
    dp[1][0] = 0  # 시작점에서 시작하는 상태 (000...01)

    tsp(dp, dist_matrix, n)
    
    # 최종 결과는 모든 칸을 방문한 상태에서 최소 비용
    ans = min(dp[(1 << n) - 1][i] for i in range(n))
    print(ans)
