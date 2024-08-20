N = int(input())

### try3 : 제곱수로 반복하기 & 3진수 만들기

def solution(n, q):
    rev_base = ''

    if n == 0:
        rev_base = '0'

    while n > 0:
        n, mod = divmod(n, q)
        rev_base += str(mod)

    return rev_base # 안 뒤집음

def sqrt_n(N):
    sqrt_n = 1
    while N>1 :
        N = N // 3
        sqrt_n +=1
    return sqrt_n

sqrt_n = sqrt_n(N)

x = [0 for _ in range(sqrt_n)]
y = [0 for _ in range(sqrt_n)]

for i in range(sqrt_n):
    while x[i] < 3**(i-1):
        for j in range(sqrt_n):
            while y[j] < 3:
                print(x,y)
                if(x[i]==1 and y[j]==1):
                    print(' ',end='')
                else :
                    print('*',end='')
                y[j] += 1
            y[j] = 0
        print('\n',end='')
        x[i] += 1
    x[i] = 0
    x[i+1] = 1


### try2 : 규칙에 따라 ' ' 넣기 & 3진수 만들기
## 시간 초과
## 재귀
# digit3 = []
# def triple_num(n) :
#     quo = n // 3
#     mod = n % 3
#     if quo == 0:
#         digit3.append(0)
#     elif quo < 3 :
#         digit3.append(quo) 
#         digit3.append(mod)
#     else : 
#         digit3.append(mod)
#         triple_num(quo)
#     return digit3
# print(triple_num(N))

# def solution(n, q):
#     rev_base = ''

#     if n == 0:
#         rev_base = '0'

#     while n > 0:
#         n, mod = divmod(n, q)
#         rev_base += str(mod)

#     return rev_base # 안 뒤집음

# for r in range(N):
#     x = solution(r, 3)
#     for c in range(N):
#         y = solution(c, 3)
#         # print(f'y={y}')
#         # print(list(zip(x,y)))
#         if ('1','1') in list(zip(x,y)):
#             print(' ',end='')
#         else :
#             print('*',end='')
#     print('\n',end='')


# ----------------------------
### try1 : 규칙성 만들고, 따라 넣으려다 실패

# rule = [[1,1,1],[1,0,1],[1,1,1]]
# star_rule = [['*','*','*'],
#              ['*',' ','*'],
#              ['*','*','*']]
# blank_rule = [[' '] * 3 for _ in range(3)]

# blank_rule_var = ['   ' for _ in range(3)]
# star_rule_var = ['***','* *','***']

# ## test
# tmp = list(zip(star_rule_var,star_rule_var,star_rule_var))
# print(tmp)
# # print(list(zip(tmp,star_rule)))
# for t in tmp:
#     print(''.join(t))

# comp_list = list()
# outer_list = []
# def print_star(n, rule) :
#     if n == 1:
#         # print(f'rule={rule}')
#         return rule       
#         # for rows in rule:
#         #     # print(''.join(rows))
#         #     # print(rows)
 
#     else :
#         for rows in rule:
#             inner_arr = []
#             for e in rows:
#                 if e=='*':
#                     inner_arr.append(print_star(n-1, star_rule_var))
#                 else : 
#                     inner_arr.append(print_star(n-1, blank_rule_var))   
#                     # print('come in')               
#                     # print_star(n-1, blank_rule)
#                 # print(inner_arr)
#             print(list(zip(*inner_arr)))
#             outer_list.extend()
#             for i in range(len(outer_list)):
#                 outer_list[i] = ''.join(outer_list[i])
#             tmp_list.append(outer_list)
            
#         print(outer_list)
#     for o in outer_list:
#         print(o)
#         # print(''.join(o))


# print_star(N, star_rule_var)
