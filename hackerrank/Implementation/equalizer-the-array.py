def equalizeArray(arr):
    arr.sort()

    mc = -1
    t = 0
    j = 0
    for i in range(arr[len(arr) - 1] + 1):
        c = 0
        while j < len(arr) and arr[j] == i:
            c += 1
            j += 1

        mc = max(c, mc)
        t += c

    return t - mc
