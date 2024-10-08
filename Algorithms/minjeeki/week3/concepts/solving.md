# 문제 풀이

## A. 1260 DFS와 BFS (실버 2)

### 문제 분석

- 요구 사항 : 그래프를 DFS로 탐색한 결과와 BFS 탐색 결과 출력
- 제한 조건
    - 방문 가능 정점이 여러개인 경우, 정점 번호가 작은 것을 먼저 방문
    - 종료 조건 : 더 이상 방문할 수 있는 점이 없는 경우
        
        ⇒ 모든 점을 방문해야 한다는 의미 (완전 탐색)
        
    - 정점 번호 : 1번 ~ N번
        
        ⇒ 인덱스 생성 시 0번 인덱스 비워놓을 것 고려하기
        
    - 정점 개수 최대 1,000
        
        간선 개수 최대 10,000 (정점 사이 여러개 간선 가능, 양방향 간선 그래프)
        

### 입/출력 요구 확인

- 입력
    
    1 line : `N M V`(정점 개수, 간선 개수, 시작 정점 번호)
    
    2 ~ 2+M line : `node1 node2` (간선이 연결하는 두 정점 번호 / 중복 존재)
    
- 출력
    
    1 line : DFS 출력 결과 (V부터 방문된 점)
    
    2 line : BFS 출력 결과 (V부터 방문된 점)
    

### 의사 코드 작성

1. 인접 리스트 생성
: 중복 간선은 set 리스트 아닌 중복 요소 있는 리스트로 작성 / 근데 상관없을듯
2. 방문처리용 배열 생성 : DFS용, BFS용 각각 구분 필요
3. DFS 코드 작성 (재귀)
4. BFS 코드 작성 (큐)

### 코드 구현

```python
# dfs 함수 구현
def dfs(graph, start, visited=[]):
    visited.append(start)
    for node in graph[start]:
        if node not in visited:
            dfs(graph, node, visited)
    return visited

# 입력값 처리, 양방향 인접 리스트 생성
N, M, V = map(int, input().split())
near_list = [[] for _ in range(N + 1)]
for m in range(M):
    i, j = map(int, input().split())
    near_list[i].append(j)
    near_list[j].append(i)
# 인접 리스트의 내부 리스트 정렬 : 작은 것부터 순회해야 하기 때문
for lst in near_list:
    lst.sort()
# 방문한 node를 visited에 직접적으로 추가
visited_DFS = []
visited_BFS = [V]
# DFS 탐색 및 결과 출력
visited_DFS = dfs(near_list, V, visited_DFS)
print(*visited_DFS)
# BFS 탐색 및 결과 출력
front = 0
rear = 1
while front != rear:
    for node in near_list[visited_BFS[front]]:
        if node not in visited_BFS:
            visited_BFS.append(node)
            rear += 1
    front += 1
print(*visited_BFS)
```

## B. 1759 암호 만들기 (골드 5)

### 문제 분석

- 암호 구성 (규칙)
    - 서로 다른 L개의 알파벳 소문자 (모음 1개, 자음 2개 반드시 포함 ⇒ 문자 종류 C가지)
    - 알파벳은 오름차순으로 배열 (정렬 안된 경우 고려 안함)

### 입/출력 요구 확인

- 입력
    
    1 line : `L C` (암호 개수, 문자 종류)
    
    2 line : 사용 문자 (C개)
    
- 출력
    
    사전식으로 가능성 있는 암호 출력
    
    ⇒ 암호의 부분집합 구하기
    

### 의사 코드 작성

1. 인접 리스트 생성
    1. c_lst 정렬
    2. near_lst의 리스트 : [idx + 1:]
2. 스택 구현 (통 안에 담은 결과 출력하는 방식으로 진행)
3. L만큼 DFS 진행 후 출력, stack 되돌아와 다른 가능한 경우 확인

### 코드 구현

```python
def backtracking():
    visited = [0] * len(
```

## C. 15686 치킨 배달 (골드 5)

### 문제 분석

- 도시 크기 : n * n
    
    도시 구성 : 빈칸 (`0`), 집 (`1`), 치킨 집(`2`)
    
- 치킨 거리 : 집과 가장 가까운 치킨 집 거리
    
    ⇒ 집에서 각 치킨집까지의 거리를 구한 뒤 최소값을 저장
    
- 도시의 치킨 거리 : 모든 집의 치킨 거리의 합
    
    거리 공식 : `|r1-r2| + |c1-c2|` 
    
- 최고 수익 치킨집 잔류 :
    
    치킨집 중 M개 선택 → 남은 M개에 대해서 각 집의 치킨 거리를 구함 → 도시 치킨거리 구함
    
- 집 개수 : 1개 이상 2N개 미만
치킨집 개수 : M개 이상 13개 이하

### 입/출력 요구 확인

- 입력
    
    line 1 : N M (도시의 줄 수, 잔류 치킨집 수)
    
    line 2 ~ line 2 + N : 도시의 2차원 배열 값
    
- 출력
    
    폐업시키지 않을 치킨집 최대 M개 골랐을 때 치킨 거리 최솟값
    

### 의사 코드(pseudo) 작성

- 치킨집 위치 리스트 / 집 위치 리스트
- 치킨집 위치 리스트 중 M개 선택
- 집 위치 리스트에서 치킨집 위치 리스트까지 거리 구하기, 치킨 거리 구하기
- 치킨 거리 합 구하기 / 도시 치킨 거리 최소값과 비교했을 때 작으면 업데이트

### 코드 구현

## D. 9663 N-Queen (골드 4)

### 문제 분석

- N개의 퀸을 체스판에 놓을 때 각각의 퀸들이 서로를 공격하지 않도록 하는 것

### 입/출력 요구 확인

- 입력 : N이 주어짐
- 출력 : 공격 불가한 케이스의 총합

### 의사 코드 작성

- 체스판 만들기 : N * N 이차원 배열 만들기
- cnt 변수 설정
- 한줄 씩 퀸 배치
→ 같은 행, 같은 열, 대각선에 퀸 없는지 확인 후 배치 (놓고 위치 확인 후 탐색)
→ 행 끝까지 가면 종료 cnt += 1

### 코드 구현

```python

```

## E. 15684. 사다리 조작 (골드 3)

### 문제 분석

- 

### 입/출력 요구 확인

### 의사 코드 작성

### 코드 구현