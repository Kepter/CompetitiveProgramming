def cavityMap(grid):
    ng = []

    for i in range(len(grid)):
        ng.append("")
        for j in range(len(grid[i])):
            c = True
            for d in dir:
                ni = i + d[0]
                nj = j + d[1]

                if (ni < 0 or ni == len(grid) or nj < 0 or nj == len(grid[i])):
                    c = False
                elif (grid[ni][nj] >= grid[i][j]):
                    c = False

            if c:
                ng[i] += "X"
            else:
                ng[i] += grid[i][j]

    return ng
