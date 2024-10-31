from collections import deque

board = [list(input()) for _ in range(5)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

result = 0

# 학생 선택하기 
def select_students(selected, dasom_count, cx, cy):
    global result

    # 재귀 종료 조건
    if len(selected) == 7:
        # 다솜이파 인원 수 파악 후 set 내부 요소의 연결 여부 (BFS) 파악
        if dasom_count >= 4 and is_connected(selected):
            result += 1
        return

    for i in range(cx, 5):
        # 현재 줄 제외 나머지는 0번 인덱스부터 탐색 
        for j in range(cy if i == cx else 0, 5):
            # 연결 여부는 나중에 판단하고 조합 가능 모든 케이스 DFS 확인
            if (i, j) not in selected:
                selected.add((i, j))
                if board[i][j] == 'S':
                    select_students(selected, dasom_count + 1, i, j)
                else:
                    select_students(selected, dasom_count, i, j)
                selected.remove((i, j))

def is_connected(selected):
    # selected 집합의 첫 번째 요소를 시작점으로 설정
    point = list(selected)[0]
    queue = deque([point])
    visited = set([point])
    count = 1

    # BFS 돌면서 selected 내부 값들이 모두 연결된 것들인지 확인
    while queue:
        cx, cy = queue.popleft()
        for k in range(4):
            nx, ny = cx + dx[k], cy + dy[k]
            if (nx, ny) in selected and (nx, ny) not in visited:
                visited.add((nx, ny))
                queue.append((nx, ny))
                count += 1
    return count == 7

for i in range(5):
    for j in range(5):
        select_students(set([(i, j)]), 1 if board[i][j] == 'S' else 0, i, j)

print(result)