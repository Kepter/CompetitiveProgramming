def cutTheSticks(arr):
    o = []
    while len(arr) > 0:
        sm = arr[0]

        for v in arr:
            if v < sm:
                sm = v

        p = []
        for i in range(len(arr)):
            arr[i] -= sm
            if (arr[i] == 0):
                p.append(i)

        o.append(len(arr))

        for i in range(len(p)):
            arr.pop(p[i] - i)

    return o
