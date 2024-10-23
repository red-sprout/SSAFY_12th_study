from collections import deque

n = int(input())
m = int(input())

# 인접 리스트 구현
friends_node = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    friends_node[a].append(b)
    friends_node[b].append(a)
# BFS 탐색을 위한 deque 사용 & 방문 여부 확인을 위한 set 자료구조 활용
deq = deque()
friends_rel = set()
friends_rel.add(1)
cnt_invited = 0
# 1촌 친구 deque에 넣기
for item in friends_node[1]:
    if item not in friends_rel:
        deq.append(item)
        friends_rel.add(item)
        cnt_invited += 1
# 2촌 친구 파악
while deq:
    friend = deq.popleft()
    for item in friends_node[friend]:
        if item not in friends_rel:
            friends_rel.add(item)
            cnt_invited += 1
print(cnt_invited)