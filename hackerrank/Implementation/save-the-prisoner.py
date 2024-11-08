def saveThePrisoner(n, m, s):
    c = ((s - 1 + m) % n)

    if c == 0:
        return n
    else:
        return c
