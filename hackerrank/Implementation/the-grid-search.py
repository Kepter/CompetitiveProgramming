def gridSearch(G, P):
    for i in range(len(G) - len(P) + 1):
        for j in range(len(G[0]) - len(P[0]) + 1):
            valid = True
            for x in range(len(P)):
                for y in range(len(P[x])):
                    if (G[i + x][j + y] != P[x][y]):
                        valid = False
                        break

                if not valid:
                    break

            if valid:
                return "YES"

    return "NO"
