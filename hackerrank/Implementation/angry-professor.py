def angryProfessor(k, a):
    a.sort()
    arrived = 0

    for s in a:
        if s <= 0:
            arrived += 1

    if arrived >= k:
        return "NO"
    else:
        return "YES"
