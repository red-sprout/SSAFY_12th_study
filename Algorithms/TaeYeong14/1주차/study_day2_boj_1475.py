num_list = list(map(int, input()))
count_list = [0] * 10

for n in num_list:
    if n == 6 or n == 9:
        if count_list[6] > count_list[9]:
            count_list[9] += 1
        elif count_list[6] < count_list[9]:
            count_list[6] += 1
        else:
            count_list[n] += 1
    else:
        count_list[n] += 1

print(max(count_list))
