from collections import deque
 
T = int(input())

dxy = [[1, 0], [0, 1], [0, -1], [-1, 0]]
for test_case in range(1, T + 1):
    N, M, K = list(map(int, input().split()))
    grid = [list(map(int, input().split())) for _ in range(N)]
 
    queue = deque()
    # 살아있는 세포들을 큐에 넣어서, bfs 탐색을 진행
    for n in range(N):
        for m in range(M):
            if grid[n][m] == 0: continue
 
            # 생명력, 위치 좌표 i, 좌표 j,살아있는 시간
            queue.append([grid[n][m], n, m, 0])
 
    # 셀이 존재하는 좌표를 저장
    cell_set = set()
    # k 시간동안 세포 분열 진행
    for k in range(K):
        tmp_queue = []
        spread_cell_dict = {}
        # 이번 k time 때 증식해야 하는 세포
        while queue:
            life, cx, cy, t = queue.pop()
            # 현재 좌표를 추가
            cell_set.add((cx, cy))
 
            # 비활성화 -> 활성화
            if t < life:
                tmp_queue.append([life, cx, cy, t + 1])
                continue
 
            # 분열해야 하는 경우
            if t == life:
                for dx, dy in dxy:
                    nx, ny = cx + dx, cy + dy
 
                    # 분열할 위치가 이미 기존의 세포가 차지하고 있던 경우
                    if (nx, ny) in cell_set: continue
 
                    # 생명력 수치가 가장 높은 세포를 얻기 위해서 동일하게 분열하는 세포들을 모으기 
                    spread_cell_dict.setdefault((nx, ny), []).append(life)
 
            # 죽은 세포가 세포라면 목록에 추가
            if t + 1 < 2 * life:
                tmp_queue.append([life, cx, cy, t + 1])
 
        # tmp_queue에서 중복 셀 제거 작업 진행 후 다시 queue에 집어넣기
        queue = tmp_queue[:]
        for cell_pos, cell_life in spread_cell_dict.items():
            queue.append([max(cell_life), cell_pos[0], cell_pos[1], 0])
 
    print(f"#{test_case} {len(queue)}")
