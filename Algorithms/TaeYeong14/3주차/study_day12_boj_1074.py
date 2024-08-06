n, r, c = map(int, input().split())

answer = 0
while n != 0:

    n -= 1
    size = 2 ** n

    if r < size and c < size:
        pass
    elif r < size and c >= size:
        answer += size * size
        c -= size
    elif r >= size and c < size:
        answer += size * size * 2
        r -= size
    else:
        answer += size * size * 3
        r -= size
        c -= size

print(answer)
