N = int(input())
count = 0
number = 0

while True :
  number += 1
  if str(number).find('666') != -1:
    count += 1
  if count == N:
    break

print(number)