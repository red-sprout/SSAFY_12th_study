canvas_size = 100
paper_size = 10

matrix = [[0]*canvas_size for _ in range(canvas_size)]

T = int(input().strip())

for test in range(T):
  x, y = map(int,input().split())
  for i in range(x,x+10):
    for j in range(y,y+10):
      matrix[i][j] = 1

print(sum(sum(row) for row in matrix))