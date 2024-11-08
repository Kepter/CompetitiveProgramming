def decodeHuff(root, s):
    ds = ""
    si = 0

    while si < len(s):
        n = root
        while (n.left is not None):
            if s[si] == '0':
                n = n.left
                si += 1

            elif s[si] == '1':
                n = n.right
                si += 1

        ds += str(n.data)

    print(ds)
