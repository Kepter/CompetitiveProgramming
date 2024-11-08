def appendAndDelete(s, t, k):
    dt = len(s) - 1
    for i in range(len(s)):
        if (i >= len(t)) or (s[i] != t[i]):
            dt = i
            break

    st = (len(s[dt:]) + len(t) - dt)

    if (len(t) + len(s) > k):
        if (st % 2 != k % 2):
            return "No"

    if (k - st >= 0):
        return "Yes"
    else:
        return "No"
