def is_valid_position(queens, row, col):
    for i in range(row):
        if queens[i] == col or \
           queens[i] - i == col - row or \
           queens[i] + i == col + row:
            return False
    return True

def place_queens(queens, row, N):
    if row == N:
        return 1
    count = 0
    for col in range(N):
        if is_valid_position(queens, row, col):
            queens[row] = col
            count += place_queens(queens, row + 1, N)
    return count

def solve_n_queens(N):
    queens = [-1] * N
    return place_queens(queens, 0, N)

# 입력 처리
N = int(input())
print(solve_n_queens(N))
