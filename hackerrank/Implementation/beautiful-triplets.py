def beautifulTriplets(d, arr):
    count = 0
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[j] - arr[i] != d:
                continue

            for k in range(j + 1, len(arr)):
                if arr[k] - arr[j] != d:
                    continue

                count += 1

    return count
