def dynamicArray(n, queries):
    a = []
    la = 0
    o = []

    for i in range(n):
        a.append([])

    for q in queries:
        if q[0] == 1:
            i = (q[1] ^ la) % n
            a[i].append(q[2])

        if q[0] == 2:
            i = (q[1] ^ la) % n
            la = a[i][q[2] % len(a[i])]
            o.append(la)

    return o
