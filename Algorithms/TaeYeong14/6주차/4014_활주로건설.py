def check(row):
    cnt = 1
    for i in range(1, N):
        if row[i] == row[i-1]: # 같은 높이라면
            cnt += 1
        elif row[i] - row[i-1] == 1 and cnt >= X: # 높이 1 높아지면
            cnt = 1
        elif row[i-1] - row[i] == 1 and cnt >= 0: # 높이 1 낮아지면
            cnt = -X + 1
        else: # 높이 2 이상 차이나면
            return False
 
    if cnt >= 0:
        return True
    return False
 
T = int(input())
 
for t in range(1, T+1):
    N, X = map(int, input().split())
    arr = []
    result = 0
 
    for i in range(N):
        arr.append(list(map(int, input().split())))
        result += check(arr[i])
 
    for i in range(N):
        temp = []
        for j in range(N):
            temp.append(arr[j][i])
        result += check(temp)
 
    print(f"#{t} {result}")
