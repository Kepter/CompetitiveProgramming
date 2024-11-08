def howManyGames(p, d, m, s):
    count = 0

    while p > m and s >= p:
        count += 1
        s -= p
        p -= d

    if p <= m:
        count += int(s / m)

    return count
