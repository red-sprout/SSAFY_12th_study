from collections import deque

roads = [deque() for _ in range(4)]

N = int(input())
for i in range(N):
    t, w = input().split()
    w_int = ord(w) - ord('A')
    roads[w_int].append((int(t), i))

cur_t = 0
answer = [-1] * N
while roads[0] or roads[1] or roads[2] or roads[3]:
    min_t = int(1e9)
    move_soon = [0] * 4
    # 현재 이동 가능 차량 찾기
    for r_idx in range(4):
        if roads[r_idx]:
            tar_t, tar_i = roads[r_idx][0]
            min_t = min(min_t, tar_t)
            if tar_t <= cur_t:
                move_soon[r_idx] += 1
    # 현재 모든 교차로에 차량 이동 가능 => 이동 불가
    sum_road = sum(move_soon)
    if sum_road == 4:
        break
    # 현재 모든 교차로에 이동 가능 차량 없음 => 다음 시간대 확인
    elif sum_road == 0:
        cur_t = min_t
        continue
    # 교차로에 차 빼기 + 해당 차량 빠진 시간 체크 + 다음 시간대 확인
    for r_idx in range(4):
        if move_soon[r_idx] and not move_soon[(r_idx - 1) % 4]:
            tar_t, tar_i = roads[r_idx].popleft()
            answer[tar_i] = cur_t
    cur_t += 1

print(*answer, sep="\n")