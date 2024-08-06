# 기본 입력값
# (n - 트럭 개수 / w - 다리 길이, 최대 트럭 개수 / l - 최대 하중 / trucks - 트럭 순서)
n, w, l = map(int, input().split())
trucks = list(map(int, input().split()))
# 변수 설정 (bridge - 다리에 올라갈 수 있는 트럭 덩어리 확인용 (무게 및 개수 제한 확인)
idx_trucks = 0
bridge_queue = [trucks[idx_trucks]] + [0 * (w - 1)]
idx_trucks += 1
front = 0
rear = 1

while sum(bridge_queue) > 0:
    