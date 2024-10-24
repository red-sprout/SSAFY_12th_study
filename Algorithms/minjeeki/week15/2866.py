R, C = map(int, input().split())
tables = [list(input()) for _ in range(R)]

# 주어진 값의 세로로 읽은 결과
lst_zip = list(zip(*tables))
len_zip = C

# 이분탐색
start = -1
end = R
duplicates = []
while start <= end:
    mid = (start + end) // 2
    # print(start, mid, end)
    # input("더 진행할까요?")
    set_splicing = set()
    for c in range(len_zip):
        # 중복 존재 : 앞 부분 확인 필요
        if lst_zip[c][mid:] in set_splicing:
            end = mid
            # print("중복 발생, 앞부분 체크")
            duplicates.append(mid)
            break
        else:
            set_splicing.add(lst_zip[c][mid:])
    else:
        start = mid
        # print(set_splicing)
        if end - start == 1:
            duplicates.append(mid)
            break
print(min(duplicates))