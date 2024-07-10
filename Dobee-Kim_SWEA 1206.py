for test_case in range(1, 11):
    n = int(input().split()[0])
    fl = list(map(int, input().split()))
    tot_sum = 0
    for i in range(2, n - 2):
        max_value = max(fl[i - 2], fl[i - 1], fl[i + 1], fl[i + 2]);
        if fl[i] - max_value > 0:
            tot_sum += fl[i] - max_value
    print(f"#{test_case} {tot_sum}")

