def rotateLeft(d, arr):
    a = []

    for i in range(len(arr)):
        a.append(arr[(i + d) % len(arr)])

    return a
