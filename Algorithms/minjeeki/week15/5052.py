T = int(input())
for _ in range(T):
    num_dict = {}
    N = int(input())
    result = 'YES'
    phones = sorted([list(input()) for _ in range(N)])
    len_ps = len(phones)
    for idx in range(len_ps):
        len_p = len(phones[idx])
        if idx < len_ps - 1 and phones[idx] == phones[idx + 1][:len_p]:
            result = 'NO'
            break
    print(result)