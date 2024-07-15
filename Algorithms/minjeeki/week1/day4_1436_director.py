def director():
    n = int(input())
    cnt = 0
    now = 665
    while (cnt < n):
        if '666' in str(now):
            cnt += 1
        if cnt == n:
            print(now)
        now += 1
director()