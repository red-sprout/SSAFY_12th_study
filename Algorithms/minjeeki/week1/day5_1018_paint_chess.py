def paint_chess():
    # 초기 세팅
    chess_size = 8
    n, m = map(int, input().split())
    chess = []
    for _ in range(n):
        chess.append(list(input()))
    painted = []
    for i in range(0, n - chess_size + 1):
        for j in range(0, m - chess_size + 1):
            # 체스판의 (0, 0)이 B로 시작하는 경우와 W로 시작하는 경우 계산 필요
            start_B = 0
            start_W = 0
            for check_i in range(i, i + 8):
                for check_j in range(j, j + 8):
                    if (check_i + check_j) % 2 == 0:
                        if (chess[check_i][check_j] == 'B'):
                            start_W += 1
                        else:
                            start_B += 1
                    else:
                        if (chess[check_i][check_j] == 'B'):
                            start_B += 1
                        else:
                            start_W += 1
            if start_B > start_W:
                painted.append(start_W)
            else:
                painted.append(start_B)
    print(min(painted))