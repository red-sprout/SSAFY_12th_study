def solve_1475():
    cnt_pack = [0 for _ in range(0, 10)]
    dasom = input()
    for char in dasom:
        num = int(char)
        if (num == 6 or num == 9):
            if (cnt_pack[6] >= cnt_pack[9]):
                cnt_pack[9] += 1
            else:
                cnt_pack[6] += 1
        else:
            cnt_pack[num] += 1
    result = max(cnt_pack)
    print(result)
solve_1475()