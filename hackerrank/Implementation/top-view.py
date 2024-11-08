def topView(root):
    v = {}
    q = [(root, 0)]

    while len(q) != 0:
        n = q.pop(0)
        if (n[1] not in v):
            v[n[1]] = n[0].info

        if (n[0].left is not None):
            q.append((n[0].left, n[1] - 1))

        if (n[0].right is not None):
            q.append((n[0].right, n[1] + 1))

    keys = list(v.keys())
    keys.sort()
    s = ""
    for k in keys:
        s += str(v[k]) + " "

    print(s)
