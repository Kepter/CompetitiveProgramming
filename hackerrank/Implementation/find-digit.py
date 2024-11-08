def findDigits(n):
    count = 0
    v = n

    while v > 0:
        d = v % 10

        if (d != 0 and n % d == 0):
            count += 1

        v = int(v / 10)

    return count
