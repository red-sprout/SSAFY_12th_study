A, B, C = map(int,input().split())

# 나머지끼리 곱한 후, 다시 값으로 나눠도 나머지 계산 가능
res = 0
mod = B
length = 0
addible_nod = []

"""
7^14를 13으로 나눈다고 할 때
ex) 7 ** 4 / 13 은 7 ** 2 / 13 의 나머지의 곱의 나머지와 같음
13 * x + a = 7 ** 2
7 ** 2를 양변에 곱하면, 몫부분은 13이 이미 곱해져 있으므로 제외하고, 나머지 부분 (7 ** 2) * a을 13으로 나누면 (7 ** 4) / 13 의 나머지를 알 수 있음 
큰 수의 나머지는 각 수의 나머지들의 곱을 다시 나눈 나머지와 같음

계산을 log n 으로 줄이기 위해선 반으로 분할함
B가 2k라면 A**2k는 (A**K)**2로 계산하고, B가 2k-1(홀수)라면 A**(B-1) * A로 계산함 

"""

while mod > 1 :
    if mod % 2 == 0: # 1이 될때까지 B를 반으로 계속 나눔
        mod = mod // 2
        length += 1
        addible_nod.append(0)        
    else : # 홀수일 경우, 1을 빼고 다시 반으로 나눔. 대신 이 경우 addible_nod 변수에 기록해 둠.
        mod = (mod - 1) // 2
        length += 1
        addible_nod.append(1)

addible_nod_reversed = addible_nod[::-1] # 역으로 계산하기 위해 list를 뒤집음

unit_res = A % C 
res = unit_res
for a in addible_nod_reversed:
    if a == 0: # A/C부터 거꾸로 제곱해 감.
        res = res ** 2 % C
    else : # 중간에 홀수 였으면 다시 기본수를 곱해서 나머지를 계산함
        res = (res ** 2 * unit_res) % C 
print(res)


# print( A**B % C)


### try 실패 : 사이클 수를 구하기엔 나누는 수에 따라 200억번이 나올 수 있음
## 나눗셈 나머지 첫자리 구하기 -> 나머지*제곱수 % 몫 한 값이 그다음 나머지
# res = [(A % C)]
# for i in range(1, B) :
#     res.append(res[i-1] * A % C)  
## 나눗셈 나머지는 최대 9가지 경우의 수로 반복될 것 (사이클 수 찾기)
#     if res[i] in res[:-1]:
#         break
#     print(res)

# idx = B % len(res)
# print(res[idx])


### 내가 작성한 코드가 길어서 찾아본 깔끔한 답안 : 재귀함수 이용
"""
import sys


def power(a, b, c):
    if b == 1:
        return a % c

    temp = power(a, b // 2, c)
    return (temp * temp * (a if b & 1 else 1)) % c


A, B, C = map(int, sys.stdin.readline().split())
print(power(A, B, C))
"""