import sys
input = sys.stdin.readline

# 입력 받기 : 게이트 수, 비행기 수, 비행기별 도착 가능 게이트 최대값
num_gates = int(input())
num_airplanes = int(input())
airplanes = [int(input()) for _ in range(num_airplanes)]

# 변수 초기화
alters = list(range(num_gates + 1)) # 각 게이트가 가리키는 값 (처음에는 자기 자신 가리킴)

# 주차 가능 게이트 찾기
def find_root(airplane):
    stack = [airplane]              # 현재 비행기 경로를 저장하는 스택
 
    while True:
        parking_gate = alters[airplane]

        if parking_gate == airplane:
            break
        # 루트 아닐 경우 경로 압축 위해 스택에 저장 필요
        else:
            stack.append(parking_gate)
            airplane = alters[parking_gate]
    # 루트 게이트로 모든 경로 연결
    while stack:
        temp = stack.pop()
        alters[temp] = parking_gate

    return parking_gate

# 
def union(root):
    # b is bigger
    b_root = find_root(root-1)

    alters[root] = b_root

# 게이트 찾기
cnt = 0

for i in range(num_airplanes):
    airplane = airplanes[i]
    root = find_root(airplane)       # 해당 비행기 주차 가능한 게이트 루트 찾기

    if root == 0:                    # 루트 0일 경우 주차 불가 -> 종료
        break

    union(root)                      # 주차 후 게이트 연결 처리
    cnt += 1                         # 주차된 비행기 수 증가

print(cnt)