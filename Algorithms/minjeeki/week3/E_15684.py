def ft_backtracking(start, depth):
    global cur_lst
    # 가지치기 조건
    if depth == M:
        print(*cur_lst)
        return
    for i in range(1, N + 1):
        if visited[i] == False:
            visited[i] = True
            cur_lst.append(i)
            ft_backtracking(i, depth + 1)
            visited[i] = False
            cur_lst.pop()

N, M = map(int, input().split())
visited = [False] * (N + 1)
visited[0] = True
cur_lst = []
ft_backtracking(0, 0)