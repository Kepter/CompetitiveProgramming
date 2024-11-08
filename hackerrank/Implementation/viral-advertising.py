def viralAdvertising(n):
    total = 0
    last = 2

    for i in range(n):
        total += last
        last = int((last * 3)/2)

    return total
