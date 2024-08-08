# 입력 처리
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 집과 치킨집의 위치를 저장할 리스트
house = []
chicken = []

# 집과 치킨집의 위치를 리스트에 추가
for r in range(N):
    for c in range(N):
        if arr[r][c] == 1:
            house.append((r, c))
        elif arr[r][c] == 2:
            chicken.append((r, c))


# 치킨 거리 계산 함수
def get_chicken_distance(houses, chickens):
    total_distance = 0
    for hx, hy in houses:
        min_distance = float('inf')
        for cx, cy in chickens:
            distance = abs(hx - cx) + abs(hy - cy)
            min_distance = min(min_distance, distance)
        total_distance += min_distance
    return total_distance


# 백트래킹을 사용한 치킨집 선택
def select_chickens(selected, idx):
    global min_chicken_distance
    if len(selected) == M:
        chicken_distance = get_chicken_distance(house, selected)
        min_chicken_distance = min(min_chicken_distance, chicken_distance)
        return
    if idx >= len(chicken):
        return

    # 현재 치킨집 선택
    select_chickens(selected + [chicken[idx]], idx + 1)
    # 현재 치킨집 선택 안함
    select_chickens(selected, idx + 1)


min_chicken_distance = float('inf')
select_chickens([], 0)
print(min_chicken_distance)
