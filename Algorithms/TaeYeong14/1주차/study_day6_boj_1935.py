size = int(input())
data = input()
num_list = [0]*size
stack = []


def cal(s, n1, n2):
    if d == '+':
        return n1 + n2
    elif d == '-':
        return n1 - n2
    elif d == '*':
        return n1 * n2
    else:
        return n1 / n2


for i in range(size):
    num_list[i] = int(input())

for d in data:
    if d in ['+', '-', '*', '/']:
        num2 = stack.pop()
        num1 = stack.pop()
        stack.append(cal(d, num1, num2))
    else:
        stack.append(num_list[ord(d)-ord('A')])

print('%.2f' % stack[0])
