def kangaroo(x1, v1, x2, v2):
    if (x1 == x2):
        return "YES"

    if (v2 > v1):
        return "NO"

    if (v1 == v2):
        return "NO"

    intersection = (x1 - x2) % (v1 - v2)

    if intersection == 0:
        return "YES"
    else:
        return "NO"
