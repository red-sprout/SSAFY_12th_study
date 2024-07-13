word_arr = list(input())
result = 0
check = 0

for i in range(len(word_arr)):
    if check == 1:
        check = 0
        continue
    elif check == 2:
        check = 1
        continue

    if word_arr[i] in ['c', 'd', 'l', 'n', 's', 'z']:
        if word_arr[i] == 'c' and (word_arr[i+1] == '=' or word_arr[i+1] == '-'):
            result += 1
            check = 1
        elif word_arr[i] == 'd':
            if word_arr[i+1] == '-':
                result += 1
                check = 1
            elif word_arr[i+1] == 'z' and word_arr[i+2] == '=':
                result += 1
                check = 2
            else:
                result += 1
        elif word_arr[i] == 'l' and word_arr[i+1] == 'j':
            result += 1
            check = 1
        elif word_arr[i] == 'n' and word_arr[i+1] == 'j':
            result += 1
            check = 1
        elif word_arr[i] == 's' and word_arr[i+1] == '=':
            result += 1
            check = 1
        elif word_arr[i] == 'z' and word_arr[i+1] == '=':
            result += 1
            check = 1
        else:
            result += 1
    else:
        result += 1
print(result)
