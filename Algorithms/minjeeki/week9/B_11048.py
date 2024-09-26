import sys

sys.setrecursionlimit(10 ** 6)

def ft_dfs(cr, cc):
    global visited

    dr = (1, 0, 1)
    dc = (0, 1, 1)
    # 종료 조건
    if cr == (N - 1) and cc == (M - 1):
        return candies[cr][cc]
    # dp 활용하기
    if dp[cr][cc] != -1:
        return dp[cr][cc]
    dp[cr][cc] = candies[cr][cc]
    for i in range(3):
        nr = cr + dr[i]
        nc = cc + dc[i]
        if 0 <= nr < N and 0 <= nc < M:
            dp[cr][cc] = max(dp[cr][cc], candies[cr][cc] + ft_dfs(nr, nc))
            # print('---', *dp, sep='\n')
    return dp[cr][cc]


N, M = map(int, input().split())
candies = [list(map(int, input().split())) for _ in range(N)]
dp = [[-1] * M for _ in range(N)]
max_candies = 0
ft_dfs(0, 0)
# print(*dp, sep='\n')
print(dp[0][0])