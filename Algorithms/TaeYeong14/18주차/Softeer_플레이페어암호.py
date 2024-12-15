def build_table(key):
    # 키존 키 알파벳 처리
    keys = []
    for char in key:
        if char not in keys and char != 'J':
            keys.append(char)

    # 나머지 알파벳 처리
    for i in range(ord('A'), ord('Z') + 1):
        char = chr(i)
        if char not in keys and char != 'J':
            keys.append(char)

    # 5x5 표 생성
    table = [[keys[i * 5 + j] for j in range(5)] for i in range(5)]
    return table


def preprocess(message):
    # 'J'를 'I'로 변환
    message = message.replace('J', 'I')
    processed = []
    i = 0

    while i < len(message):
        # 마지막 문자 처리
        if i == len(message) - 1:
            processed.append(message[i] + 'X')
            break

        # 동일한 문자 연속 시 처리
        if message[i] == message[i + 1]:
            processed.append(message[i] + ('X' if message[i] != 'X' else 'Q'))
            i += 1
        else:
            processed.append(message[i:i + 2])
            i += 2

    return processed


def find_position(table, char):
    # 2차원 리스트에서 문자 위치 찾기
    for row in range(5):
        if char in table[row]:
            return row, table[row].index(char)


def encryption(message_pairs, table):
    encrypted = []
    for pair in message_pairs:
        a, b = pair[0], pair[1]
        a_row, a_col = find_position(table, a)
        b_row, b_col = find_position(table, b)

        if a_row == b_row:
            # 같은 행
            encrypted.append(table[a_row][(a_col + 1) % 5])
            encrypted.append(table[b_row][(b_col + 1) % 5])
        elif a_col == b_col:
            # 같은 열
            encrypted.append(table[(a_row + 1) % 5][a_col])
            encrypted.append(table[(b_row + 1) % 5][b_col])
        else:
            # 다른 행, 열
            encrypted.append(table[a_row][b_col])
            encrypted.append(table[b_row][a_col])

    return ''.join(encrypted)


def get_result(message, key):
    table = build_table(key)  # 키로 5x5 표 생성
    processed_message = preprocess(message)  # 메시지 전처리
    return encryption(processed_message, table)  # 암호화 수행


# 입력
message = input().strip()
key = input().strip()

# 실행
result = get_result(message, key)

# 출력
print(result)
