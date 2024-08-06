n, w, L = map(int,input().split())
trucks = list(map(int,input().split()))

bridge = [0] * w # 다리 길이만큼의 큐
time = 0

for truck in trucks:
    while True:
        bridge.pop(0)
        # print(f'bridge={bridge}time={time}')
        if sum(bridge)+truck <= L: # 다리 하중을 안 넘을 경우
            bridge.append(truck)
            time += 1  
            break
        else :
            bridge.append(0)
            time += 1  
         
print(time+w)
  


''' 실패 try1 : 반례를 고려하지 않음
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
'''

''' try2 : 클래스 만들려다 실패
class truck() :
    def __init__(self, size):
        self.queue = [0] * size
    
    def dequeue(self):
        if len(self.queue) == 0:
                return -1
        self.queue.pop(0)

    def enqueue(self, n):
         self.append(n)
'''