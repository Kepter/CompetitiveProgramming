def chocolateFeast(n, c, m):
    w = int(n / c)
    t = int(n / c)

    while w >= m:
        t += int(w / m)
        w = int(w / m) + w % m
