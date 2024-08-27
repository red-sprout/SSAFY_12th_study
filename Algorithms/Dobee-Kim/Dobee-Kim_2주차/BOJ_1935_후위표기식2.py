## N값
N = int(input())

## 표현식
expr = input()
expr_dict = {}
for n in range(N):
    expr_dict[chr(65+n)] = int(input())
# print(expr_dict)

## 계산기호
cal_compared = ['*','+','/','-']
num_list = []
a = 0
b = 0

## 계산 함수
def cal(a, b, cal_Str):
    if cal_Str == "+":
        rst = a+b
    elif cal_Str == "-":
        rst = a-b
    elif cal_Str == "*":
        rst = a*b
    else:
        rst = a/b
    return rst

for e in expr:
    if e not in cal_compared: # 숫자일 때(문자열)
        num_list.append(expr_dict[e])             
    else : 
        a = num_list.pop()
        b = num_list.pop()
        num_list.append(cal(b,a,e))

print(round(num_list[0],2))


# ############# 개별로 계산하려다가 망한 시도
# for e in expr:
#     if e not in cal_compared: # 숫자일 때
#         num_list.append(int(input())) # 숫자 리스트에 넣기
#         is_need = True
#     else : # 계산 기호일 때
#         cal_list.append(e)
#         try:
#             if(len(cal_list)==1): # 첫 계산일 때
#                 a = num_list.pop()
#             else :
#                 a = res
#             b = num_list.pop()
#             res = cal(a,b,e)
#             if(len(num_list)==0): # 숫자 리스트에 남은 숫자가 없을 때 (새 계산식 시작)
#                 res_list.append(res)
#                 cal_list = []
#                 res,a,b = 0,0,0       
#         except :
#             pass
#     # print(f'numlist={num_list}callist={cal_list}reslist={res_list}a={a}b={b}res={res}')

# if(len(res_list)==1):
#     print(res_list[0])
# else :
#     a = res_list[-1]
#     for i in range(len(res_list)-2,0,-1):
#         print(i)
#         b = res_list[i]
#         a = cal(a,b,cal_list[i])
#     print(a)



