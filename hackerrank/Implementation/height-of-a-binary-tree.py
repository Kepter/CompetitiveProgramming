def height(root):
    q = [(root, 0)]

    mh = 0
    while len(q) != 0:
        n = q.pop(0)
        mh = max(mh, n[1])

        if n[0].left is not None:
            q.append((n[0].left, n[1] + 1))

        if n[0].right is not None:
            q.append((n[0].right, n[1] + 1))

    return mh
