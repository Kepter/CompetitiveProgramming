def migratoryBirds(arr):
    spotted = {}

    for b in arr:
        if b in spotted:
            spotted[b] += 1
        else:
            spotted[b] = 1

    maxCount = -1
    maxId = -1
    keys = list(spotted.keys())
    keys.sort()
    for k in keys:
        if spotted[k] > maxCount:
            maxCount = spotted[k]
            maxId = k

    return maxId
