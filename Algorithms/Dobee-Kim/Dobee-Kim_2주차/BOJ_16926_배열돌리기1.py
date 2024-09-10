# 작은 수가 짝수

### 이거 아닌 것 같은데 포기...

N, M, R = map(int, input().split())

arr = [list(map(int, input().split())) for n in range(N)]

tmp_arr = [[] for _ in range(N)]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
lst = []
for n in range(N):
    for m in range(M) :
        if n==0:
            tmp_arr[0].append(arr[n][m])
        elif m==(M-1):
            tmp_arr[1].append(arr[n][m])
        elif n==(N-1):
            tmp_arr[2].append(arr[n][m])
        elif m==0:
            tmp_arr[3].append(arr[n][m])
        print(tmp_arr)

tmp_arr[2] = tmp_arr[2][::-1]
tmp_arr[3] = tmp_arr[3][::-1]

for t in tmp_arr :
    lst.extend(t)

print(lst)

corner = [0, M-1, N+M-2,2*N+M-3]
corner = list(map(lambda x : x + R,corner))
corner = list(map(lambda x : x % len(lst),corner))




print(corner)
# arr 길이
tmp_arr = [4]

