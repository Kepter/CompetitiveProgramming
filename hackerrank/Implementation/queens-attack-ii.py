def queensAttack(n, k, r_q, c_q, obstacles):
    om = {}

    for o in obstacles:
        if o[0]-1 in om:
            om[o[0]-1][o[1]-1] = True
        else:
            om[o[0]-1] = {o[1]-1: True}

    count = 0
    for d in dir:
        p = [r_q + d[0] - 1, c_q + d[1] - 1]
        while (p[0] >= 0 and p[0] < n) and (p[1] >= 0 and p[1] < n):
            if (p[0] in om and p[1] in om[p[0]]):
                break
            count += 1
            p[0] += d[0]
            p[1] += d[1]

    return count
