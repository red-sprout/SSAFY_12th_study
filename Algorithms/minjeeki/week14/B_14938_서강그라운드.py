from collections import deque

# 지역 개수, 예은이 수색 범위, 길의 개수
n, m, r = map(int, input().split())
node_lst = [[] for _ in range(n + 1)]
node_lst[0] = None
# 각 구역에 있는 아이템 수
items = [0] + list(map(int, input().split()))
for i in range(r):
    # 길 양 끝에 존재하는 지역 번호 a,b 그리고 길의 길이
    a, b, l = map(int, input().split())
    node_lst[a].append((b, l))
    node_lst[b].append((a, l))

max_get_item = 0
# 전체 노드 순회하며 해당 위치 시작점으로 얻을 수 있는 아이템 개수 파악
for user_point in range(1, n + 1):
		# 방문처리 set
    added = set()
    added.add(user_point)
    # BFS 탐색 queue 생성 및 초기 값 설정
    deq = deque()
    deq.append([user_point, m])
    cur_get_item = items[user_point]
    # BFS 탐색하면서 탐색 가능한 범위 파악
    while deq:
        target = deq.popleft()
        # 현 탐색 지점 인접 노드 파악
        for t_nod in node_lst[target[0]]:
		        # 해당 위치 도닥 가능할 경우 - 한번 방문한 곳도 재방문 가능
            if t_nod[1] <= target[1]:
                deq.append([t_nod[0], target[1] - t_nod[1]])
                # 해당 지점 선물 갖지 못했을 경우 선물 줍줍
                if t_nod[0] not in added:
                    cur_get_item += items[t_nod[0]]
                    added.add(t_nod[0])
    # print('---', user_point, cur_get_item)
    # 현 시작지점에서의 선물 줍줍 더 많이 할 경우 업데이트
    max_get_item = max(max_get_item, cur_get_item)
print(max_get_item)