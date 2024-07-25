# 데이터 구조 set 사용하고 풀기
n, m = map(int, input().split())
set_s = set()
for _ in range(n):
    set_s.add(input())
cnt = 0
for _ in range(m):
    str_need_test = input()
    if str_need_test in set_s:
        cnt += 1
print(cnt)

# 데이터 구조 set 사용 안하고 list로 풀기
n, m = map(int, input().split())
lst_s = []
for _ in range(n):
    word = input()
    if word not in lst_s:
        lst_s.append(word)
cnt = 0
for _ in range(m):
    str_need_test = input()
    if str_need_test in lst_s:
        cnt += 1
print(cnt)

# 성능 차이
# - 파이썬의 set은 해시함수를 이용 / 리스트는 인덱스를 이용
# - in 연산자를 이용한 조회 시간 복잡도 비교
# - set : 해시 함수를 이용, 전체 요소 조회 없이 O(1)의 시간 복잡도 가짐
# - list : 인덱스를 이용해 전체 순회하며 조회 => O(n)의 시간 복잡도를 가짐
# - 중복 제거
# - set : 해시 함수를 이용하기에 중복 알아서 걸러짐 => O(1)의 시간 복잡도 가짐
# - list : 인덱스를 이용해 전체 순회하며 조회 => O(n)의 시간 복잡도 가짐