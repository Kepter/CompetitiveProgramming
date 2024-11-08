def sockMerchant(n, ar):
    count = 0
    seen = {}

    for s in ar:
        if s in seen:
            count += 1
            seen.pop(s)
        else:
            seen[s] = True

    return count
