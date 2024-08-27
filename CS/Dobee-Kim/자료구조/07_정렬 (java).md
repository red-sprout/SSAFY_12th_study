# 정렬
## 정렬 알고리즘
- 데이터를 특정한 기준에 따라 순서대로 나열하는 것

## 선택 정렬
- 처리되지 않은 데이터 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸는 것
- 마지막 경우는 처리안해도 됨
- 선형 탐색

```python
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_index = i  # 가장 작은 원소의 인덱스
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
    array[i], array[min_index] = array[min_index], array[i]  # 스왑

print(array)

```
### 시간복잡도
- 선택 정렬의 시간 복잡도 설명:
- 선택 정렬은 N번 만큼 가장 작은 수를 찾아서 맨 앞으로 보내야 합니다.
- 구현 방식에 따라서 사소한 오차는 있을 수 있지만, 전체 연산 횟수는 다음과 같습니다.
- N + (N - 1) + (N - 2) + ... + 2
- 이는 (N^2 + N - 2) / 2 로 표현할 수 있는데, 빅오 표기법에 따라서 O(N^2)이라고 작성합니다.

## 삽입 정렬
- 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입함
- 선택 정렬에 비해 구현 난이도는 높으나, 일반적으로 더 효율적으로 동작함

```python
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)):
    for j in range(i, 0, -1):  # 인덱스 i부터 1까지 1씩 감소하며 반복하는 문법
        if array[j] < array[j - 1]:  # 한 칸씩 왼쪽으로 이동
            array[j], array[j - 1] = array[j - 1], array[j]
        else:  # 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
            break

print(array)  # 실행 결과: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

```
- 삽입 정렬의 시간 복잡도 설명:
- 삽입 정렬의 시간 복잡도는 O(N^2)이며, 선택 정렬과 마찬가지로 반복문이 두 번 중첩되어 사용됩니다.
- 삽입 정렬은 현재 리스트의 데이터가 거의 정렬되어 있는 상태라면 매우 빠르게 동작합니다.
- 최선의 경우 O(N)의 시간 복잡도를 가집니다.
- 이미 정렬되어 있는 상태에서 다시 삽입 정렬을 수행하면 어떻게 될까요?
- [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

### 퀵정렬
# 퀵 정렬

- 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법입니다.
- 일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘 중 하나입니다.
- 병합 정렬과 더불어 대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 되는 알고리즘입니다.
- 가장 기본적인 퀵 정렬은 첫 번째 데이터를 기준 데이터(Pivot)로 설정합니다.

```python
def quick_sort(array):
    # 리스트가 하나 이하의 원소만을 담고 있다면 종료
    if len(array) <= 1:
        return array
    
    pivot = array[0]  # 피벗은 첫 번째 요소
    tail = array[1:]  # 피벗을 제외한 리스트
    
    left_side = [x for x in tail if x <= pivot]  # 피벗보다 작은 요소들
    right_side = [x for x in tail if x > pivot]  # 피벗보다 큰 요소들
    
    # 분할 이후 왼쪽 부분과 오른쪽 부분을 각각 정렬하고, 전체 리스트 반환
    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

# 테스트 배열
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
# 퀵 정렬 수행
sorted_array = quick_sort(array)
# 결과 출력
print(sorted_array)

- 퀵 정렬이 빠른 이유:
- 이상적인 경우 분할이 절반씩 일어난다면 전체 연산 횟수로 O(N log N)을 기대할 수 있음
- 최악의 경우 O(N^2)의 시간 복잡도를 가짐
    - 편향되게 분할될 경우
    - 이미 정렬된 배열의 경우 시간이 많이 걸림
- 너비 X 높이 = N x log N = N log N

def quick_sort(array):
    if len(array) <= 1:
        return array
    
    pivot = array[0]  # 피벗은 첫 번째 요소
    tail = array[1:]  # 피벗을 제외한 리스트
    
    left_side = [x for x in tail if x <= pivot]  # 피벗보다 작은 요소들
    right_side = [x for x in tail if x > pivot]  # 피벗보다 큰 요소들
    
    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

# 테스트 배열
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
# 퀵 정렬 수행
sorted_array = quick_sort(array)
# 결과 출력
print(sorted_array)
