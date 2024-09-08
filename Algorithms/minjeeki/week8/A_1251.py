'''
문제 이해
- 목표
    - 인도네시아 내의 모든 섬을 해저터널로 연결
    - 환경 부담금을 최소로 지불 => 출력 : 최소 환경 부담금 (소수 첫째자리에서 반올림)
- 설정
    - 해저터널은 반드시 두 섬을 하나의 선분으로 연결, 교차되더라도 연결 아님
    - 섬 연결은 직접적일 수도, 간접적일 수도 있음
    - 환경 부담금 정책 : 환경부담세율(E) * 해저터널길이제곱(L ** 2)
- 문제 관련 알고리즘 (feat chatGPT)
    - 최소 신장 트리 -> 크루스칼 알고리즘
    - 크루스칼 알고리즘은 모든 간선을 미리 계산해 정렬한 후 비용이 적은 간선부터 선택 => 거리 기반 간선 처리에 유리
    1. 모든 간선을 비용순으로 정렬
    2. 사이클을 이루지 않는 선에서 가장 작은 간선을 선택해 나가며 트리 확장
    3. 모든 정점이 연결될 때까지 1과 2의 과정 반복
- 크루스칼 알고리즘 학습 부족한 관계로 chatGPT의 도움을 얻음
'''
def get_cost_by_distance():
    edge = []
    for i in range(N):
        for j in range(i + 1, N):
            dx = x_lst[i] - x_lst[j]
            dy = y_lst[i] - y_lst[j]
            distance = dx ** 2 + dy ** 2
            cost = E * distance
            edge.append((i, j, cost))
    return edge

def kruskal(n, edge):
    # 아직 이해 못함. 추가 학습 필요
    pass

T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    for island in range(N):
        x_lst = list(map(int, input().split()))
        y_lst = list(map(int, input().split()))
        E = float(input())
        # 섬들의 좌표 이용해 섬 간의 거리 계산 -> 간선 비용 계산
        edge = get_cost_by_distance()
        # 최소 신장 트리 구성(크루스칼 알고리즘) -> 총 비용 계산
        min_cost = kruskal(N, edge)
    print(f'#{tc} {min_cost}')