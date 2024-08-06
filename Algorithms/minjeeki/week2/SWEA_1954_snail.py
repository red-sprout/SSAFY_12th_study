T = int(input())

for t in range(1, T + 1):
    # 초기 설정
    N = int(input())
    square = [[0 for _ in range(N)] for _ in range(N)]
    # 오른쪽 이동, 아래로 이동, 왼쪽 이동, 위쪽이동
    direction_move = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    cur_x, cur_y = 0, 0
    direction = 0
    
    
    for n in range(1, N * N + 1):
        # 현위지 값 지정
        square[cur_x][cur_y] = n

        # 다음 위치 유효성 판단
        next_x = cur_x + direction_move[direction][0]
        next_y = cur_y + direction_move[direction][1]

        if (0 <= next_x < N and 0 <= next_y < N and square[next_x][next_y] == 0):
            pass
        else:
            direction += 1
            direction %= 4
        
        cur_x += direction_move[direction][0]
        cur_y += direction_move[direction][1]

    # print
    print(f'#{t}')
    for line in square:
        print(*line)
