# '이것이 취업을 위한 코딩테스트다 with 파이썬' 문제

def time():
    n = int(input())
    start_time = [0, 0, 0]
    cnt = 0
    while (start_time[0] != n or start_time[1] != 59 or start_time[2] != 59):
        # 현재 시각 내에 3이 들어있는지 여부 확인
        for num in start_time:
            if '3' in str(num):
                cnt += 1
                break
        # 다음 시각에 대한 처리
        start_time[2] += 1
        if (start_time[2] == 60):
            start_time[1] += 1
            start_time[2] = 0
        if (start_time[1] == 60):
            start_time[0] += 1
            start_time[1] = 0
    print(cnt)
time()

# 답안 예시 코드
# 새로 배운 내용 : for문 돌릴 필요 없이 str의 + 연산을 활용하는 방법을 항상 고민하기, 3개의 요소가 반복을 돈다면 삼중 for문을 사용할 수 있다.
# h = int(input())

# count = 0
# for i in range(h + 1):
#     for j in range(60):
#         for k in range(60):
#             if '3' in str(i) + str(j) + str(k):
#                 count += 1

# print(count)