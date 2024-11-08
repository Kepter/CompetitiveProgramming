def jumpingOnClouds(c, k):
    e = 100
    n = len(c)

    p = k % n
    e -= 1 + 2 * c[p]

    while p != 0:
        p = (p + k) % n
        e -= 1 + 2 * c[p]

    return e
