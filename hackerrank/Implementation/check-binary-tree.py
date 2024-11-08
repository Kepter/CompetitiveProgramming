def check_binary_search_tree_(root):
    q = [(root, -1, -1)]

    while len(q) != 0:
        n = q.pop(0)

        if (n[1] != -1 and n[0].data <= n[1]):
            return False

        if (n[2] != -1 and n[0].data >= n[2]):
            return False

        if (n[0].left is not None):
            q.append((n[0].left, n[1], n[0].data))

        if (n[0].right is not None):
            q.append((n[0].right, n[0].data, n[2]))


    return True
