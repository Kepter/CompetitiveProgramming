def squares(a, b):
    v = 0
    count = 0
    while (v * v) < a:
        v += 1

    while (v * v) <= b:
        count += 1
        v += 1

    return count
