def kaprekarNumbers(p, q):
    nums = ""

    for i in range(p, q+1):
        v = i * i
        l = len(str(v))
        a = 0
        b = int(str(v)[int(l / 2):])

        if (l > 1):
            a = int(str(v)[:(int(l / 2))])

        if (a + b) == i:
            nums = nums + str(i) + " "

    if (nums != ""):
        print(nums)
    else:
        print("INVALID RANGE")
