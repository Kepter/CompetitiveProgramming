def flatlandSpaceStations(n, c):
    c.sort()
    d = []

    ci = 0
    for i in range(n):
        if (ci + 1 < len(c) and c[ci + 1] == i):
            ci += 1

        d.append([abs(i - c[ci])])

    ci = len(c) - 1
    for i in range(n-1, -1, -1):
        if (ci - 1 >= 0 and c[ci - 1] == i):
            ci -= 1

        d[i].append(abs(c[ci] - i))

    m = 0
    for i in range(n):
        m = max(m, min(d[i][0], d[i][1]))

    return m
