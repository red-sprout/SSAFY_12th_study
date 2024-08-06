# 기본 입력값
# (n - 트럭 개수 / w - 다리 길이, 최대 트럭 개수 / l - 최대 하중 / trucks - 트럭 순서)
n, w, l = map(int, input().split())
trucks = list(map(int, input().split()))
# 변수 설정 (bridge - 다리에 올라갈 수 있는 트럭 덩어리 확인용 (무게 및 개수 제한 확인)
bridge = []
total_time = 0
idx_truck = 0
while idx_truck < n:            # 전체 트럭 리스트를 순회
    will_add = trucks[idx_truck]
    cur_cnt = len(bridge)
    cur_total_weight = sum(bridge)
    # bridge에 담긴 트럭들(cur_cnt)이 아직 최대 트럭 개수(w)를 넘지 않을 경우 추가 여부 확인 필요
    if cur_cnt < w:
        # 현재 다리 내 트럭 무게에 현재 트럭 추가했을 때 최대 하중 미만일 경우, 현재 트럭 추가
        if will_add + cur_total_weight < l:
            bridge.append(will_add)
            idx_truck += 1
        # 최대 하중 넘을 경우 덩어리 수집 종료, 시간 계산
        else:
            total_time += (w + (cur_cnt - 1))
            bridge = []
    # 최대 개수 넘을 경우 덩어리 수집 종료, 시간 계산
    else:
        total_time += (w + (cur_cnt - 1))
        bridge = []
# 전체 트럭 리스트 순회했으나 덩어리에 아직 남은 트럭이 있을 경우
if len(bridge) != 0:
    total_time += (w + (len(bridge) - 1))
# 모든 트럭이 다리를 건너는 최단 시간은 전체 덩어리의 체류 시간 + 1
print(total_time + 1)