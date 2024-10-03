def ft_is_in_A(item, start, end):
    if start > end:
        return 0
    mid = (end + start) // 2
    if item == A[mid]:
        return 1
    if item > A[mid]:
        return ft_is_in_A(item, mid + 1, end)
    else:
        return ft_is_in_A(item, start, mid - 1)
    

N = int(input())
A = sorted(list(map(int, input().split())))
M = int(input())
B = list(map(int, input().split()))
for item in B:
    print(ft_is_in_A(item, 0, N - 1))