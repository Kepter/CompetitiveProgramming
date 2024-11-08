def lca(root, v1, v2):
    n = root
    while n.info != v1 and n.info != v2:
        if v1 > n.info and v2 > n.info:
            n = n.right

        elif v1 < n.info and v2 < n.info:
            n = n.left

        else:
            return n

    return n
