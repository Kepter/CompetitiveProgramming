def surfaceArea(A):
    a = len(A) * len(A[0]) * 2

    for i in range(len(A)):
        for j in range(len(A[0])):
            for d in dir:
                ni = i + d[0]
                nj = j + d[1]

                if ni < 0 or ni >= len(A) or nj < 0 or nj >= len(A[0]):
                    a += A[i][j]
                elif A[ni][nj] < A[i][j]:
                    a += A[i][j] - A[ni][nj]

    return a
