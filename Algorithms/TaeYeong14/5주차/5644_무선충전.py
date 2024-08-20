def get_dis(a_pos, b_pos):
    return abs(a_pos[0] - b_pos[0]) + abs(a_pos[1] - b_pos[1])
 
dxy = [[0, 0], [0, -1], [1, 0], [0, 1], [-1, 0]]
 
for test_case in range(1, (int(input())) + 1):
    M, A = map(int, input().split())  # 이동 시간, charger 개수
    a_mv_list = list(map(int, input().split()))  # a 이동방향 목록
    b_mv_list = list(map(int, input().split()))  # b 이동방향 목록
    ap_list = [list(map(int, input().split())) for _ in range(A)]  # ap 목록
    A_START_POS, B_START_POS = 1, 10  # A (1,1)
    ax, ay = A_START_POS, A_START_POS  # A 유저의 위치
    bx, by = B_START_POS, B_START_POS  # B 유저의 위치
 
    # 충전량의 합을 저장할 변수
    result = 0
 
    for t in range(M + 1):
        # 매 시간 ap 충전 로직 실행
        a_connects, b_connects = [], []
 
        for ap in ap_list:
            # ap의 x좌표, y좌표, 충전 범위, 충전 파워
            ap_x, ap_y, c, p = ap
 
            if get_dis([ax, ay], [ap_x, ap_y]) <= c:
                a_connects.append([[ap_x, ap_y], p])
            if get_dis([bx, by], [ap_x, ap_y]) <= c:
                b_connects.append([[ap_x, ap_y], p])
 
        # 모든 경우의 수를 확인을 한다.
        # 1. a 유저만 접속한 ap가 있는경우
        # b 유저만 접속한 ap 가 있는경우
        # a,b 모두 접속한 ap가 있는경우
        #   접속한 ap가 동일할 경우에는 ? 절반씩 나눠갖고
        #   동일하지 않으면 각각 선택한다.
        power_max = 0
        if a_connects and not b_connects:
            # a 유저가 접속할 수 있는 ap 목록을 순회
            for a_connects in a_connects:
                # ap의 파워가 가장 큰 친구를 이번 시간에 얻을 수 있는 충전량으로 설정
                power_max = max(power_max, a_connects[1])
        # 주어진 방향대로 이동!
        elif not a_connects and b_connects:
            for b_connect in b_connects:
                power_max = max(power_max, b_connect[1])
        # a도 연결한 ap가 있고, b도 연결한 ap가 있는 경우
        else:
            for a_connect_ap in a_connects:
                for b_connect_ap in b_connects:
                    # 0 인덱스는 위치를 뜻한다.
                    # 동일하면 절반씩 나눠갖음
                    if a_connect_ap[0] == b_connect_ap[0]:
                        power_max = max(power_max, a_connect_ap[1])
                    else:
                        power_max = max(power_max, a_connect_ap[1] + b_connect_ap[1])
 
        result += power_max
        # 로직을 수행하고 이동을 하고 있다.
        # M 시간을 다 소요하면 (로직을 수행하면, 더 이상 이동할 필요가 없다 )
        if t == M:
            break
 
        #  이동
        ax += dxy[a_mv_list[t]][0]
        ay += dxy[a_mv_list[t]][1]
        bx += dxy[b_mv_list[t]][0]
        by += dxy[b_mv_list[t]][1]
 
    print(f"#{test_case} {result}")
