# '이것이 취업을 위한 코딩테스트다 with 파이썬' 문제

# 기본 설정, 파싱
map_n, map_m = map(int, input().split())
gamer = list(map(int, input().split()))         # 캐릭터 x좌표, y좌표, 방향
map_area = []
for i in range(map_n):
    oneline = list(map(int, input().split()))
    map_area.append(oneline)
direction_move = [(-1, 0), (0, 1), (1, 0), (0, -1)]
# 현 위치 방문 체크
map_area[gamer[0]][gamer[1]] = 2
visit_area = 1
turned_time = 0

while 1:
    next_move_x = gamer[0] + direction_move[gamer[2]][0]
    next_move_y = gamer[1] + direction_move[gamer[2]][1]
    # 현재 방향 방문 안한 곳 존재 시 이동
    if (map_area[next_move_x][next_move_y] == 0):
        map_area[next_move_x][next_move_y] = 2
        gamer[0] = next_move_x
        gamer[1] = next_move_y
        visit_area += 1
        turned_time = 0
    # 현재 방향에 방문한 곳이거나 바다가 있다면 방향을 돌림
    else:
        if gamer[2] == 0:
            gamer[2] = 3
        else:
            gamer[2] -= 1
        turned_time += 1
    # 바라본 방향이 모두 방문 또는 바다일 경우 뒤로 이동 (뒤가 바다일 경우 종료)
    if turned_time > 3:
        go_back_x = gamer[0] + direction_move[(gamer[2] + 2) % 4][0]
        go_back_y = gamer[1] + direction_move[(gamer[2] + 2) % 4][1]
        if (map_area[go_back_x][go_back_y] == 1):
            print(visit_area)
            break
        else:
            gamer[0] = go_back_x
            gamer[1] = go_back_y
            if gamer[2] == 0:
                gamer[2] = 3
            else:
                gamer[2] -= 1
            next_move_x = gamer[0] + direction_move[gamer[2]][0]
            next_move_y = gamer[1] + direction_move[gamer[2]][1]
            if (map_area[next_move_x][next_move_y] != 0):
                print(visit_area)
                break

# 교재에 있는 tip : 일반적으로 방향을 설정해서 이동하는 문제 유형에서는 dx, dy라는 별도의 리스트를 만들어 방향을 정하는 것이 효과적이다.