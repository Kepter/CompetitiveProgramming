def workbook(n, k, arr):
    count = 0
    p = 1

    for i in range(len(arr)):
        lj = 0
        j = min(k, arr[i])

        while True:
            if p > lj and j >= p:
                count += 1
            lj = j
            j = min(j + k, arr[i])
            p += 1

            if lj == arr[i]:
                break

    return count
