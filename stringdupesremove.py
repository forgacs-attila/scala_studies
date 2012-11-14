'''
Design an algo: removes dupes in string
without using additional buffer.
'''
def removeDupes(s):
    L = len(s)
    if L == 0: return
    if L < 2: return
    tail = 1 # the 2nd char, forget the first

    for i in range(1, L):

        for j in range(0, tail+1):
            if s[i] == s[j]:
                break
        else:
            print "new genuine:",s[i],' check:',j,tail, " tail == j"

        # if no match J remains on tail...

        if j == tail:
            s[tail] = s[i]
            tail += 1
        else:
            print "skip:",s[j],' at ',i

    s[tail] = "X"
    return s


print removeDupes(["w", "o", "o", "o", "2", "3", "o", "o", "t","iiii"])
