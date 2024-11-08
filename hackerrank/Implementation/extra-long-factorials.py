def extraLongFactorials(n):
    v = 1

    for i in range(1, n+1):
        v *= i

    print(v)
