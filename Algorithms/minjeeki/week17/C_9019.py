from collections import deque

# DSLR 처리에서 중복 너무 많아서 함수로 따로 빼서 처리함
def check_visit_append(num, cur_cmd, new_cmd):
    if visited[num] == False:
        visited[num] = True
        deq.append([num, cur_cmd + new_cmd])

T = int(input())
for t in range(1, T + 1):
    A, B = map(int, input().split())
    visited = [False] * 10001
    visited[A] = True
    # deq에는 값과 해당 값을 갖기까지 처리한 명령어에 대한 정보가 들어감
    deq = deque([[A, '']])
    while deq:
        cur_num, cur_cmd = deq.popleft()
        if cur_num == B:
            print(cur_cmd)
            break
        # D 상황
        after_D = (2 * cur_num) % 10000
        check_visit_append(after_D, cur_cmd, 'D')
        # S 상황
        after_S = (cur_num - 1) % 10000
        check_visit_append(after_S, cur_cmd, 'S')
        # L 상황
        after_L = ((cur_num % 1000) * 10) + (cur_num // 1000)
        check_visit_append(after_L, cur_cmd, 'L')
        # R 상황
        after_R = ((cur_num % 10) * 1000) + (cur_num // 10)
        check_visit_append(after_R, cur_cmd, 'R')