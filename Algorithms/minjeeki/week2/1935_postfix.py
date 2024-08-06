n = int(input())
expression = input()
n_dict = {}
for i in range(n):
    key_chr = chr(ord('A') + i)
    n_dict[key_chr] = int(input())
stack = []
for chr in expression:
    if chr.isupper():
        stack.append(n_dict[chr])
    else:
        right_num = stack.pop()
        left_num = stack.pop()
        if chr == '+':
            stack.append(left_num + right_num)
        elif chr == '*':
            stack.append(left_num * right_num)
        elif chr == '/':
            stack.append(left_num / right_num)
        elif chr == '-':
            stack.append(left_num - right_num)
print(f'{stack[0]:.2f}')