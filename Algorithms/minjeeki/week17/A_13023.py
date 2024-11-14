from collections import deque

def dfs(cur_friend, connection):
    global is_in_line

    # 연결 관계가 5일 경우 처리 필요
    if connection == 5:
        is_in_line = 1
        return
    if is_in_line == 0:
        # 현재 친구의 친구 모두 deq에 넣기
        deq = deque(near_lst[cur_friend])
        # BFS로 빼면서 visited 처리 안되어있다면 가지치기 진행
        while deq:
            next_candi = deq.popleft()
            if next_candi not in visited:
                visited.add(next_candi)
                dfs(next_candi, connection + 1)
                visited.remove(next_candi)

# 입력값 처리 및 인접 리스트 설정
N, M = map(int, input().split())
near_lst = [[] for _ in range(N)]
for i in range(M):
    f1, f2 = map(int, input().split())
    near_lst[f1].append(f2)
    near_lst[f2].append(f1)

# 한줄 표현 가능한지 확인 (DFS)
is_in_line = 0
for start_f in range(N):
    visited = set([start_f])
    dfs(start_f, 1)

print(is_in_line)