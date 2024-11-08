def arrayManipulation(n, queries):
    sq = {}

    for q in queries:
        if q[0] in sq:
            sq[q[0]] += q[2]
        else:
            sq[q[0]] = q[2]

        if q[1]+1 in sq:
            sq[q[1]+1] -= q[2]
        else:
            sq[q[1]+1] = -q[2]

    m = 0
    v = 0
    keys = list(sq.keys())
    keys.sort()

    for k in keys:
        v += sq[k]
        m = max(m, v)

    return m
