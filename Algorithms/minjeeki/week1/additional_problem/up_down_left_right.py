# '이것이 취업을 위한 코딩테스트다 with 파이썬' 문제

def up_down_left_right():
    n = int(input())
    move_plan = input().split()
    start_point = [1, 1]
    for move in move_plan:
        if move == 'R' and start_point[1] < n:
            start_point[1] += 1
        elif move == 'L' and start_point[1] > 1:
            start_point[1] -= 1
        elif move == 'U' and start_point[0] > 1:
            start_point[0] -= 1
        elif move == 'D' and start_point[0] < n:
            start_point[0] += 1
    print(f'{start_point[0]} {start_point[1]}')

up_down_left_right()

# 답안 예시 코드

# 새로 배운 내용 : 변수를 하나 더 써서 값을 선 반영한 후 해당 값의 유효성을 판단하는 방법도 있음
# n = int(input())
# x, y = 1, 1
# plans = input().split()

# dx = [0, 0, -1, 1]
# dy = [-1, 1, 0, 0]
# move_types = ['L', 'R', 'U', 'D']

# for plan in plans:
#     for i in range(len(move_types)):
#         if plan == move_types[i]:
#             nx = x + dx[i]
#             ny = y + dy[i]
#     if nx < 1 or ny < 1 or nx > n or ny > n:
#         continue
#     x, y = nx, ny