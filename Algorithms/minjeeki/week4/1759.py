set_moum = set(['a', 'e', 'i', 'o', 'u'])

def ft_backtracking(depth, cur_idx):
    global password, visited
    # 기저 조건 : depth가 L 이상 \\ print 조건 : 모음 한개 이상 포함 시 (모음으로만 구성되는 경우 제외 필요)
    if depth == L:
        cnt_moum = 0
        cnt_jaum = 0
        for char in password:
            if cnt_moum < 1 and char in set_moum:
                cnt_moum += 1
            elif cnt_jaum < 2 and char not in set_moum:
                cnt_jaum += 1
            elif cnt_moum >= 1 and cnt_jaum >= 2:
                break
        if cnt_moum >= 1 and cnt_jaum >= 2:
            print(''.join(password))
        return
    # 재귀 진행
    for idx in range(cur_idx, C):
        if visited[idx] == False:
            visited[idx] = True
            password.append(alpha_lst[idx])
            ft_backtracking(depth + 1, idx + 1)
            visited[idx] = False
            password.pop()


L, C = map(int, input().split())            # L : 암호 알파벳 개수 / C : 사용 가능 문자 종류
alpha_lst = sorted(input().split())         # 암호 규칙 : 최소 1개의 모음은 포함해야 함 / 알파벳 배열은 오름차순
visited = [False] * C
password = []
ft_backtracking(0, 0)