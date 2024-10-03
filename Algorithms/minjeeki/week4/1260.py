def ft_dfs(point):
    if len(visited_dfs) == N:
        return
    for next_candi in near_lst[point]:
        if next_candi not in visited_dfs:
            visited_dfs.add(next_candi)
            route_dfs.append(next_candi)
            ft_dfs(next_candi)

# 입력값 처리
N, M, V = map(int, input().split())
near_lst = [set() for _ in range(N + 1)]
for _ in range(M):
    p1, p2 = map(int, input().split())
    near_lst[p1].add(p2)
    near_lst[p2].add(p1)
near_lst = [sorted(list(near_lst[idx])) for idx in range(N + 1)]
# print(*near_lst, sep='\n')

# DFS 처리
visited_dfs = set()
route_dfs = [V]
visited_dfs.add(V)
ft_dfs(V)
print(*route_dfs)

# BFS 처리
visited_bfs = set()
visited_bfs.add(V)
route_bfs = [V]
front = 0
while front < len(route_bfs):
    # print(front, route_bfs, len(route_bfs))
    front_item = route_bfs[front]
    for item in near_lst[front_item]:
        if item not in visited_bfs:
            visited_bfs.add(item)
            route_bfs.append(item)
    front += 1
print(*route_bfs)