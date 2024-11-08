def pickingNumbers(a):
    a.sort()
    ml = 0

    for v in set(a):
        l = 0
        for k in a:
            if k == v or k == v + 1:
                l += 1

        ml = max(l, ml)

    return ml
