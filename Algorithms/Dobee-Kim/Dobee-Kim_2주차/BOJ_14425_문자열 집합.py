N, M = map(int,input().split())
S = set()
test = []
for n in range(N):
    S.add(input())
for m in range(M):
    test.append(input())

res = 0

for t in test:
    if t in S :
        res+=1

print(res)