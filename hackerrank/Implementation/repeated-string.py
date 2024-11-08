def repeatedString(s, n):
    count = 0

    if (n > len(s)):
        ps = 0
        for c in s:
            if (c == 'a'):
                ps += 1

        count += ps * int(n / len(s))

    for i in range(n % len(s)):
        if s[i] == 'a':
            count += 1

    return count
