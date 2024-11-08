def fairRations(B):
    count = 0

    for i in range(len(B)):
        if (B[i] % 2 != 0):
            if (i == len(B) - 1):
                return "NO"
            else:
                count += 2
                B[i] += 1
                B[i+1] += 1

    return str(count)
