def ft_backtracking(cnt, cur_ci):
    global visited, min_distance

    # 기저 조건
    if cnt == M:
        chosen_chicken = list(visited)
        distance_house = [(N * 2) * M] * len_house
        for cci in range(M):
            for hi in range(len_house):
                distance_now = abs(chosen_chicken[cci][0] - house_coordinates[hi][0]) + abs(chosen_chicken[cci][1] - house_coordinates[hi][1])
                distance_house[hi] = min(distance_house[hi], distance_now)
        # print(chosen_chicken)
        # print(distance_house, sum(distance_house))
        min_distance = min(min_distance, sum(distance_house))
        return
    # 가지치기 조건
    # 재귀 조건
    for ci in range(cur_ci + 1, len_chicken):
        # 치킨집 선택
        if chicken_coordinates[ci] not in visited:
            visited.add(chicken_coordinates[ci])
            ft_backtracking(cnt + 1, ci)
            visited.remove(chicken_coordinates[ci])

N, M = map(int, input().split())
grid = [[] for _ in range(N)]
# 치킨집 좌표 리스트
chicken_coordinates = []
house_coordinates = []
for idx in range(N):
    grid[idx] = list(map(int, input().split()))
    for jdx in range(N):
        if grid[idx][jdx] == 2:
            chicken_coordinates.append((idx, jdx))
        elif grid[idx][jdx] == 1:
            house_coordinates.append((idx, jdx))
len_chicken = len(chicken_coordinates)
len_house = len(house_coordinates)
min_distance = 10 ** 6
# print(min_distance)
visited = set()
ft_backtracking(0, -1)
print(min_distance)