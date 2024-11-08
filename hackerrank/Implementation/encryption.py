def encryption(s):
    ns = s.strip()

    rows = math.floor(math.sqrt(len(ns)))
    cols = rows

    if (len(ns) > rows * cols):
        cols += 1
        if (len(ns) > rows * cols):
            rows += 1

    crypt = []
    si = 0
    for i in range(rows):
        crypt.append("")
        for j in range(cols):
            if (si >= len(ns)):
                break

            crypt[i] += ns[si]
            si += 1

    cs = ""
    for j in range(cols):
        for i in range(rows):
            if (j >= len(crypt[i])):
                continue

            cs += crypt[i][j]

        cs += " "

    return cs
