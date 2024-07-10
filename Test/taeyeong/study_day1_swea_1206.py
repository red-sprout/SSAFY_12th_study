# T = int(input())
#
# for test_case in range(1, T+1):
#     num_a, num_b = map(int, input().split())
#     min_num, max_num = 0, 0
#     min_arr, max_arr = 0, 0
#     result = 0
#
#     a_data = list(map(int, input().split()))
#     b_data = list(map(int, input().split()))
#
#     if num_a > num_b:
#         min_num, max_num = num_b, num_a
#         min_arr, max_arr = b_data, a_data
#     else:
#         min_num, max_num = num_a, num_b
#         min_arr, max_arr = a_data, b_data
#
#     for i in range(0, max_num-min_num+1):
#         sum_result = 0
#         for j in range(0, min_num):
#             sum_result += min_arr[j] * max_arr[i+j]
#         if sum_result > result:
#             result = sum_result
#
#     print("#%d %d" % (test_case, result))

T = int(input())

for test_case in range(1, T+1):
    num_a, num_b = map(int, input().split())
    min_num, max_num = 0, 0
    min_arr, max_arr = 0, 0
    result = 0

    a_data = list(map(int, input().split()))
    b_data = list(map(int, input().split()))

    if num_a > num_b:
        min_num, max_num = num_b, num_a
        min_arr, max_arr = b_data, a_data
    else:
        min_num, max_num = num_a, num_b
        min_arr, max_arr = a_data, b_data

    for i in range(0, max_num-min_num+1):
        sum_result = 0
        for j in range(0, min_num):
            sum_result += min_arr[j] * max_arr[i+j]
        if sum_result > result:
            result = sum_result

    print("#%d %d" % (test_case, result))
