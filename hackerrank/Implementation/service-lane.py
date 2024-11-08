def serviceLane(n, width, cases):
    s = []

    for c in cases:
        m = width[c[0]]
        for i in range(c[0], c[1] + 1):
            m = min(m, width[i])

        s.append(m)

    return s
