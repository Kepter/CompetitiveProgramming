def pageCount(n, p):
    return min(int(p / 2), int((n + 1 - (n % 2) - p) / 2))
