num = int(input())
arr = [[0]*100 for _ in range(100)]

for n in range(num):
    x1, y1 = map(int, input().split())

    for i in range(10):
        for j in range(10):
            arr[x1+i][y1+j] = 1

result = 0
for i in range(100):
    result += sum(arr[i])

print(result)
