# 행, 열, 동일 사각형 내 값의 존재 유무 판단
def check_row(x, input_num):
    if input_num in sudoku[x]:
        return False
    return True

def check_column(y, input_num):
    for i in range(9):
        if sudoku[i][y] == input_num:
            return False
    return True

def check_square(x, y, input_num):
    s_idx = (x // 3) * 3
    s_jdx = (y // 3) * 3
    for i in range(s_idx, s_idx + 3):
        for j in range(s_jdx, s_jdx + 3):
            if sudoku[i][j] == input_num:
                return False
    return True

# DFS : 좌표에 값 하나씩 넣고 유효성 판단 -> 유효할 경우 계속 다음 값 넣기
def dfs(cnt):
    if cnt == len_zero:
        for line in sudoku:
            print(*line)
        exit(0)
    for can_input in range(1, 10):
        x, y = zeros[cnt]
        if check_row(x, can_input) and check_column(y, can_input) and check_square(x, y, can_input):
            sudoku[x][y] = can_input
            dfs(cnt + 1)
            sudoku[x][y] = 0

# 입력값 처리 & 값이 0인 좌표 정보 저장
sudoku = [0] * 9
zeros = []
for idx in range(9):
    sudoku[idx] = list(map(int, input().split()))
    for jdx in range(9):
        if sudoku[idx][jdx] == 0:
            zeros.append((idx, jdx))

len_zero = len(zeros)
dfs(0)