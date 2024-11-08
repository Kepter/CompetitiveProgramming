def strangeCounter(t):
    m = 3
    c = 0

    while t > c + m:
        c += m
        m += m

    return m - (t - c - 1)
