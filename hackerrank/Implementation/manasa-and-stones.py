def stones(n, a, b):
    q = set([0])

    for i in range(n-1):
        nq = set()
        while len(q) > 0:
            v = q.pop()

            nq.add(v + a)
            nq.add(v + b)

        q = nq

    q = list(q)
    q.sort()
    return q
