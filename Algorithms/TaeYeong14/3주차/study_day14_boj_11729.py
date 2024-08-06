def hanoi(num, start, mid, end):
    if num == 1:
        print(start, end)
    else:
        hanoi(num-1, start, end, mid)
        print(start, end)
        hanoi(num-1, mid, start, end)

N = int(input())

print(2**N -1)
hanoi(N, 1, 2, 3)
