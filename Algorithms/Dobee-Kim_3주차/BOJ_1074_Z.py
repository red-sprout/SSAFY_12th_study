N, r, c = map(int,input().split())

# 순서도 리스트 제작
# x_order = [0, 0, 1, 1]
# y_order = [0, 1, 0, 1]
xy_order = [[0, 0], [0, 1], [1, 0], [1, 1]]

# r과 c의 이진수변환, 자릿수만큼 0채우기
bin_r = format(r, 'b').zfill(N)
bin_c = format(c, 'b').zfill(N)
# print(bin_r,bin_c)
# r과 c의 위치 맵
rc_order = [0]*N

for i in range(0,4):
    for j in range(N):
        rc = [int(bin_r[j]), int(bin_c[j])]
        # print(rc)
        if xy_order[i] == rc:
            # print(rc)
            rc_order[j] = i
# print(rc_order)
rc_order = rc_order[::-1]
# print(rc_order)
res = 0
for i in range(N):
    res += rc_order[i] * (2**i)** 2
print(res)