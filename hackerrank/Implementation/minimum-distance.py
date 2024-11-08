def minimumDistances(a):
    md = -1

    for i in range(len(a)):
        for j in range(i + 1, len(a)):
            if a[i] == a[j]:
                if md == -1 or md > (j - i):
                    md = j - i

    return md
