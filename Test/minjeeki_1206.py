T = 10
for t_case in range(1, T + 1):
    N = int(input())
    buildings = list(map(int, input().split()))
    result_views = 0
    for idx in range(2, N - 2):
        near_buildings = [buildings[idx-2], buildings[idx-1], buildings[idx+1], buildings[idx+2]]
        near_buildings.sort()
        max_near_building = near_buildings[-1]
        if buildings[idx] > max_near_building :
            result_views += (buildings[idx] - max_near_building)
    print(f"#{t_case} {result_views}")