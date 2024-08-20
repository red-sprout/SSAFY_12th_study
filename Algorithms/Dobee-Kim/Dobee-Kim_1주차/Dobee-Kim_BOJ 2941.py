cr_list = ['c=','c-','dz=','d-','lj','nj','s=','z=']
a = input().strip()

sum_str = 0
for cr in cr_list:
  sum_str += a.count(cr)
  a = a.replace(cr,".")


sum_str += len(a) - a.count(".")

print(sum_str)
