# dfs 함수 구현
def dfs(graph, start, visited=[]):
    visited.append(start)
    for node in graph[start]:
        if node not in visited:
            dfs(graph, node, visited)
    return visited

# 입력값 처리, 양방향 인접 리스트 생성
N, M, V = map(int, input().split())
near_list = [[] for _ in range(N + 1)]
for m in range(M):
    i, j = map(int, input().split())
    near_list[i].append(j)
    near_list[j].append(i)
# 인접 리스트의 내부 리스트 정렬 : 작은 것부터 순회해야 하기 때문
for lst in near_list:
    lst.sort()
# 방문한 node를 visited에 직접적으로 추가
visited_DFS = []
visited_BFS = [V]
# DFS 탐색 및 결과 출력
visited_DFS = dfs(near_list, V, visited_DFS)
print(*visited_DFS)
# BFS 탐색 및 결과 출력
front = 0
rear = 1
while front != rear:
    for node in near_list[visited_BFS[front]]:
        if node not in visited_BFS:
            visited_BFS.append(node)
            rear += 1
    front += 1
print(*visited_BFS)