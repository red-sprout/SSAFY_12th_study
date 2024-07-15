# '이것이 취업을 위한 코딩테스트다 with 파이썬' 문제

def kingdom_knight():
    coordinate = input()
    x = ord(coordinate[0]) - ord('a') + 1
    y = int(coordinate[1])
    dx_list = [1, -1, 1, -1, 2, 2, -2, -2]
    dy_list = [2, 2, -2, -2, 1, -1, 1, -1]
    cnt = 0

    for idx in range(8):
        dx = x + dx_list[idx]
        dy = y + dy_list[idx]
        if (dx >= 1 and dx <= 8 and dy >= 1 and dy <= 8):
            cnt += 1
    print(cnt)

kingdom_knight()

# 답안 예시 코드
# 새로 배운 내용 : 2차원 배열 내에서 움직이는 문제에 대해서는 대략 2가지 접근 방법을 많이 사용한다 / 파이썬에서는 아스키 코드를 ord()함수를 이용한다.
# input_data = input()
# row = int(input_data[1])
# column = int(ord(input_data[0])) - int(ord('a')) + 1
# steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

# result = 0
# for step in steps:
#     next_row = row + step[0]
#     next_column = column + step[1]
#     if next_row >= 1 and next_row <= 8 and next_column >= 1 and next_row <= 8:
#         result += 1

# print(result)