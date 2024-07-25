n, w, L = map(int,input().split())
trucks = list(map(int,input().split()))

time = 0
weight_check = 0
truck_list = []
set_list = []
for truck in trucks:
    weight_check += truck
    if(weight_check>L):
       # 기존 것 리스트에 넣고 초기화
       truck_list.append(set_list)
       weight_check=0
       set_list = []
        # 다시 체크
       weight_check += truck
    set_list.append(truck)
if len(set_list)!=0:
    truck_list.append(set_list)
               
print(truck_list)

res = len(truck_list) * w

for lst in truck_list:
    if len(lst) !=1:
        res+=len(lst)-1
res +=1
print(res)

# 마지막은 같이 가는 트럭수만큼
# 중간은 트럭수 -1만큼(겹쳐가므로)
