def levelOrder(root):
    s = ""
    q = [root]

    while len(q) != 0:
        n = q.pop(0)
        s += str(n.info) + " "

        if (n.left is not None):
            q.append(n.left)

        if (n.right is not None):
            q.append(n.right)

    print(s)
