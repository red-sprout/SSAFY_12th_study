def croatia():
    croatia_2word = ['c=', 'c-', 'd-', 'lj', 'nj', 's=', 'z=']
    word = input()
    cnt = 0; i = 0
    while i < len(word):
        if word[i:i+2] in croatia_2word:
            i += 2
        elif word[i:i+3] == 'dz=':
            i += 3
        else:
            i+= 1
        cnt+= 1
    print(cnt)