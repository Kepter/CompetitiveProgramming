def birthday(s, d, m):
    sum = 0

    if (m > len(s)):
        return 0

    for i in range(m):
        sum += s[i]

    count = 0

    if (sum == d):
        count += 1

    for i in range(m, len(s)):
        sum -= s[i-m]
        sum += s[i]

        if (sum == d):
            count += 1

    return count
