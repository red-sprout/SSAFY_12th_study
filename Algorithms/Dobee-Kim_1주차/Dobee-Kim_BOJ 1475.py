import math

# 입력 & 숫자 리스트
n_digit = list(map(int,input()))
count = {}
val_6 = 0
val_9 = 0
# 숫자 개수 세기 & 6과 9 처리
for n in n_digit:
  if n ==6:
    val_6 +=1
  elif n == 9:
    val_9 +=1
  else:
      if n in count:
        count[n] += 1
      else:
        count[n] = 1

max_value = max(count.values(),default=0)
        
# 6 & 9 합계 처리
combined_6_and_9 = math.ceil((val_6 + val_9) / 2)

res = max(max_value, combined_6_and_9)
print(res)