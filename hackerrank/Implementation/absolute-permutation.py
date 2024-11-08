def absolutePermutation(n, k):
    a = []
    t = {}

    #a[i] = i +/- k
    for i in range(n):
        if (i + 1 <= k):
            a.append(i + k + 1)
        elif (i + 1 + k > n):
            a.append(i - k + 1)
        elif (i - k + 1) in t:
            a.append(i + k + 1)
        else:
            a.append(i - k + 1)

        if a[i] in t or a[i] < 1 or a[i] > n:
            return [-1]

        t[a[i]] = True

    return a
