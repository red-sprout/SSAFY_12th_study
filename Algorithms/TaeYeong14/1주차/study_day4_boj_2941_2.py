word = input()
i = 0
result = 0

while i < len(word):
    if word[i] == 'c' and i + 1 < len(word) and (word[i + 1] == '=' or word[i + 1] == '-'):
        i += 2
    elif word[i] == 'd':
        if i + 1 < len(word) and word[i + 1] == '-':
            i += 2
        elif i + 2 < len(word) and word[i + 1] == 'z' and word[i + 2] == '=':
            i += 3
        else:
            i += 1
    elif (word[i] == 'l' or word[i] == 'n') and i + 1 < len(word) and word[i + 1] == 'j':
        i += 2
    elif (word[i] == 's' or word[i] == 'z') and i + 1 < len(word) and word[i + 1] == '=':
        i += 2
    else:
        i += 1
    result += 1

print(result)
