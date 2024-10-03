import sys
sys.setrecursionlimit(10 ** 6)

def ft_dfs(cur_idx, idx_before_choice):
    if cur_idx == N:
        return 0

    if dp[cur_idx][idx_before_choice] != -1:
        return dp[cur_idx][idx_before_choice]

    min_cost = float('inf')

    for i in range(3):
        if i != idx_before_choice:
            cost = house_costs[cur_idx][i] + ft_dfs(cur_idx + 1, i)
            min_cost = min(min_cost, cost)

    dp[cur_idx][idx_before_choice] = min_cost
    return min_cost

N = int(input())
dp = [[-1 for _ in range(3)] for _ in range(1001)]
house_costs = [list(map(int, input().split())) for _ in range(N)]
min_cost = ft_dfs(0, -1)
print(min_cost)