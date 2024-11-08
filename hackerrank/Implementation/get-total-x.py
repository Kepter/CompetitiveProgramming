def getTotalX(a, b):
    count = 0
    test = 1
    while(test <= 100):
        valid = True

        for v in a:
            if test % v != 0:
                valid = False
                break

        for v in b:
            if v % test != 0:
                valid = False
                break

        if valid:
            count += 1

        test += 1

    return count
