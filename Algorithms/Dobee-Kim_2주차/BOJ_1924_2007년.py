x, y  = map(int,input().split())

c1 = [1,3,5,7,8,10,12]
c2 = [4,6,9,11]
c3 = [2]
day = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']

days = 0
for m in range(1,x):
    if m in c1:
        days += 31
    elif m in c2:
        days += 30
    else :
        days += 28

days += y
print(day[days % 7])