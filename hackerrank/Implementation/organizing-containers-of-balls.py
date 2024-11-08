def organizingContainers(container):
    totals = []
    sizes = {}

    for i in range(len(container)):
        totals.append(0)

    for c in container:
        size = 0
        for i in range(len(c)):
            totals[i] += c[i]
            size += c[i]

        if size not in sizes:
            sizes[size] = 0

        sizes[size] += 1

    for t in totals:
        if (t not in sizes) or (sizes[t] == 0):
            return "Impossible"

    return "Possible"
