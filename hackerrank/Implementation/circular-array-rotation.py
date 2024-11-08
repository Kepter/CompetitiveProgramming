def circularArrayRotation(a, k, queries):
    values = []
    for q in queries:
        values.append(a[(q - k) % len(a)])

    return values
