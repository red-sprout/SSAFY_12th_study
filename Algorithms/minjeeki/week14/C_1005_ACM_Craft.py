import sys
from collections import deque

input = sys.stdin.readline  # readline 함수를 바로 사용하기 위해 할당
T = int(input())  # 첫 번째 입력: 테스트 케이스 수

for _ in range(T):
    # N : 건물 수, K : 규칙 수
    N, K = map(int, input().split())  # N, K 입력
    build_time = [0] + list(map(int, input().split()))  # 각 건물의 건설 시간
    build_near_lst = [[] for _ in range(N + 1)]
    in_degree = [0] * (N + 1)  # 각 건물의 진입 차수

    for _ in range(K):
        x, y = map(int, input().split())  # x 지어야 y 짓기 가능
        build_near_lst[x].append(y)       # x 지은 다음 y 지을 수 있기에 단방향
        in_degree[y] += 1                 # y가 지어지기 위해서 선건설되어야 하는 건물 수

		# 목표 건물 번호
    W = int(input())

    times = build_time[:]                # build_time을 기반으로 값을 변경할 변수 복사
    deq = deque()

    # 진입 차수가 0인 건물들 먼저 큐에 삽입
    for i in range(1, N + 1):
        if in_degree[i] == 0:
            deq.append(i)

    # 위상 정렬 BFS 수행
    while deq:
        now = deq.popleft()
        for next_building in build_near_lst[now]:
            # now가 지어졌기 때문에 next_building을 위해 선행되어야 하는 필요 건물 건설 개수 감소
            in_degree[next_building] -= 1
            # 해당 건물의 최종 건설 시간을 갱신
            times[next_building] = max(times[next_building], times[now] + build_time[next_building])
            # 해당 건물의 선행 건물이 모두 건설됐을 경우 deq에 담아 건설 진행
            if in_degree[next_building] == 0:
                deq.append(next_building)

    # 목표 건물 W의 건설 시간 출력
    print(times[W])