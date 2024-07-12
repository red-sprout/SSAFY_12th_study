def color_paper():
    size_total = 100; size_paper = 10
    total = [[0 for j in range(size_total)] for i in range(size_total)]
    num_paper = int(input())
    for _ in range(num_paper):
        x, y = map(int, input().split())
        for x1 in range(x, x + size_paper):
            for y1 in range(y, y + size_paper):
                total[x1][y1] = 1
    sum = 0
    for i in range(size_total):
        for j in range(size_total):
            if total[i][j] == 1:
                sum += 1;
    print(sum)
color_paper()