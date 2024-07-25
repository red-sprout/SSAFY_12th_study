# 1954 대신 잘못 풀이함

T = int(input())
for t in range(1, T + 1):
    N = int(input())
    num_lst = [2, 3, 5, 7, 11]
    output_lst = [0, 0, 0, 0, 0]

    # 계산하기
    idx = 0
    for idx in range(len(num_lst)):
        while N % num_lst[idx] == 0:
            N /= num_lst[idx]
            output_lst[idx] += 1
    # 출력하기
    print(f'#{t}', end=' ')
    for num in output_lst:
        print(num, end=' ')
    print('')