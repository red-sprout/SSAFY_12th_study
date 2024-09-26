def ft_backtracking(cx):
    global cnt
    if cx == N:
        cnt += 1
        return
    for y in range(N):
        if not column[y] and not main_diagonal[cx - y] and not anti_diagonal[cx + y]:
            column[y] = main_diagonal[cx - y] = anti_diagonal[cx + y] = True
            ft_backtracking(cx + 1)
            column[y] = main_diagonal[cx - y] = anti_diagonal[cx + y] = False

N = int(input())
cnt = 0
column = [False] * N
main_diagonal = [False] * (2 * N - 1)
anti_diagonal = [False] * (2 * N - 1)
ft_backtracking(0)
print(cnt)