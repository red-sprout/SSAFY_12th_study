n = int(input())
wine = [int(input()) for _ in range(n)]

if n == 1:
    print(wine[0])
elif n == 2:
    print(wine[0] + wine[1])
else:
    dp = [0] * n
    dp[0] = wine[0]
    dp[1] = wine[0] + wine[1]
    dp[2] = max(wine[0] + wine[2], wine[1] + wine[2], dp[1])

    for i in range(3, n):
        # 현재 가질 수 있는 최댓값은
        # (1) 현 위치 선택 안하고 직전 최댓값 이어받기
        # (2) 현 위치 선택 후 2개 전꺼의 최댓값 이어받기
        # (3) 현 위치 + 직전 wine값 선택 + 3개 전꺼의 최댓값 이어받기
        dp[i] = max(dp[i - 1], dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i])

    print(dp[n - 1])