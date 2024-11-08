def nonDivisibleSubset(k, s):
    ns = []

    for i in range(k):
        ns.append(0)

    for v in s:
        ns[v % k] += 1

    count = 0
    for i in range(1, int(k/2) + k % 2):
        count += max(ns[i], ns[k-i])

    if (k % 2 == 0 and ns[int(k/2)] > 0):
        count += 1

    if (ns[0] > 0):
        count += 1

    return count
