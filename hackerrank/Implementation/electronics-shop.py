def getMoneySpent(keyboards, drives, b):
    maxCost = -1
    for k in keyboards:
        for d in drives:
            if (k + d <= b):
                maxCost = max(maxCost, k + d)

    return maxCost
