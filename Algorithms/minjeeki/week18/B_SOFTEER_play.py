import sys

input = sys.stdin.readline

message = input().strip()
play_key = input().strip()

matrix = [[0] * 5 for _ in range(5)]
set_key = set()
key_info = {}
idx = 0

# matrix 채우기
for k in play_key:
    if k not in set_key:
        set_key.add(k)
        matrix[idx // 5][idx % 5] = k
        key_info[k] = (idx // 5, idx % 5)
        idx += 1
for alpha in "ABCDEFGHIKLMNOPQRSTUVWXYZ":
    if alpha not in set_key:
        matrix[idx // 5][idx % 5] = alpha
        key_info[alpha] = (idx // 5, idx % 5)
        idx += 1
# print(matrix)
# 메시지 분해하기
len_message = len(message)
split_message = []
start_idx = 0
while start_idx < len_message:
    # 마지막에 한글자가 남는 경우
    if start_idx == len_message - 1:
        split_message.append([message[start_idx], 'X'])
        start_idx += 1
    # 연속한 두 글자가 다를 경우
    elif message[start_idx] != message[start_idx + 1]:
        split_message.append([message[start_idx], message[start_idx + 1]])
        start_idx += 2
    # 연속한 두 글자가 같은 경우
    elif message[start_idx] == message[start_idx + 1]:
        if message[start_idx] != 'X':
            split_message.append([message[start_idx], 'X'])
        else:
            split_message.append([message[start_idx], 'Q'])
        start_idx += 1
# print(split_message)
# 암호화 해결하기
answer = ''
for pair in split_message:
    row1, col1 = key_info[pair[0]]
    row2, col2 = key_info[pair[1]]
    if row1 == row2:
        change1 = matrix[row1][(col1 + 1) % 5]
        change2 = matrix[row2][(col2 + 1) % 5]
    elif col1 == col2:
        change1 = matrix[(row1 + 1) % 5][col1]
        change2 = matrix[(row2 + 1) % 5][col2]
    else:
        change1 = matrix[row1][col2]
        change2 = matrix[row2][col1]
    answer += change1 + change2
print(answer)