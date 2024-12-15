from collections import deque, defaultdict


def get_result(N, cars):
    queues = defaultdict(deque)  # 차선을 기준 차량 대기열
    for idx, (t, w) in enumerate(cars):
        queues[w].append((t, idx))  # 차량 도착 시각과 번호(idx)를 저장

    right_lanes = {'A': 'D', 'B': 'A', 'C': 'B', 'D': 'C'}
    current_time = 0  # 현재 시각
    results = [-1] * N

    while any(queues.values()):  # 모든 대기열이 비어있지 않은 동안 반복
        min_time = float('inf')  # 가장 빠른 도착 시각
        is_waiting = {lane: False for lane in "ABCD"}  # 각 차선 대기 상태
        can_cross = {lane: False for lane in "ABCD"}  # 각 차선 통과 가능 여부
        deadlock_count = 0  # 교착 상태 감지 카운터

        # 각 도로의 맨 앞 차량 상태 확인
        for lane in "ABCD":
            if queues[lane]:  # 해당 차선에 차량이 있다면
                arrival_time, _ = queues[lane][0]  # 첫 번째 차량의 도착 시각 확인
                min_time = min(min_time, arrival_time)  # 가장 빠른 차량 시간 갱신
                if arrival_time <= current_time:
                    is_waiting[lane] = True
                    deadlock_count += 1

        # 네 도로 모두 대기 중인 차량이 있으면 교착 상태 발생
        if deadlock_count == 4:
            break

        # 현재 시간에 도착한 차량이 없는 경우
        if deadlock_count == 0:
            current_time = min_time  # 가장 빠른 차량의 도착 시각으로 갱신
            continue

        # 통과 가능한 차량 확인
        for lane in "ABCD":
            if is_waiting[lane]:  # 현재 대기 중인 차량이라면
                right_lane = right_lanes[lane]  # 해당 차선의 오른쪽 차선
                if not is_waiting[right_lane]:  # 오른쪽 차선에 차량이 없으면
                    can_cross[lane] = True  # 통과 가능

        # 통과 가능한 차량 처리
        for lane in "ABCD":
            if can_cross[lane]:
                _, idx = queues[lane].popleft()  # 차량 제거
                results[idx] = current_time  # 차량의 통과 시각 기록

        # 시간 증가
        current_time += 1

    return results


# 입력
N = int(input())
cars = []
for _ in range(N):
    t, w = input().split()
    cars.append((int(t), w))

# 실행
results = get_result(N, cars)

# 출력
for time in results:
    print(time)
