n = int(input())

dp = [0] * (n + 1)
dp[1] = 1
if n >= 2:
    dp[2] = 2
    for i in range(3, n + 1):
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
print(dp[n])

# 주의 사항
# n = 1일 경우 dp의 최대 인덱스가 1이기 때문에 조건문 처리를 따로 했다.
# n + 2라고 통 자체를 키울 경우에도 사실 문제는 없음