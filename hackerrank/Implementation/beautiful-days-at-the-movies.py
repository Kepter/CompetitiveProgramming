def reverse(n):
    v = 0
    while n != 0:
        v *= 10
        v += n % 10
        n = int(n/10)

    return v

def beautifulDays(i, j, k):
    days = 0

    for i in range(i, j+1):
        if (abs(i - reverse(i)) % k == 0):
            days += 1

    return days
