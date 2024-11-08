def matchingStrings(stringList, queries):
    c = {}

    for s in stringList:
        if s in c:
            c[s] += 1
        else:
            c[s] = 1

    a = []

    for q in queries:
        if q in c:
            a.append(c[q])
        else:
            a.append(0)

    return a
