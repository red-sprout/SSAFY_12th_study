m, n = map(int,input().split())
# chess_board = [[0 if (row+col)%2 == 0 else 1 for col in range(8)] for row in range(8)]
board = [[0 if i == 'W' else 1 for i in list(input())] for _ in range(m)]
# W = 0, B = 1
# print(board)

diff = 0
ls_answer = []
for a in range(m-7):
    for b in range(n-7):
        diff = 0
        for i in range(8):
            for j in range(8):
                diff += abs(board[i+a][j+b] - (0 if((i+j)%2 == 0) else 1))
                # print(f'val:{board[i+a][j+b]}, m:{a},n:{b}, row:{i}, col:{j}, pointer:{0 if((i+j)%2 == 0) else 1}, diff:{diff}')
        ls_answer.append(diff)

print(min(min(ls_answer), min(64-x for x in ls_answer)))