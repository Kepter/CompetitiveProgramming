def happyLadybugs(b):
    count = {}
    cm = False

    for c in b:
        if c == '_':
            cm = True
            continue

        if c in count:
            count[c] += 1
        else:
            count[c] = 1

    if cm:
        for c in count.keys():
            if count[c] == 1:
                return "NO"
    else:
        for i in range(len(b)):
            if i-1 >= 0 and b[i-1] == b[i]:
                continue

            if i+1 < len(b) and b[i+1] == b[i]:
                continue

            return "NO"

    return "YES"
