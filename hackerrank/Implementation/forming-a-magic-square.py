squares = [
   [[8,3,4],
    [1,5,9],
    [6,7,2]],

   [[6,1,8],
    [7,5,3],
    [2,9,4]],

   [[2,7,6],
    [9,5,1],
    [4,3,8]],

   [[4,9,2],
    [3,5,7],
    [8,1,6]],

   [[4,3,8],
    [9,5,1],
    [2,7,6]],

   [[2,9,4],
    [7,5,3],
    [6,1,8]],

   [[6,7,2],
    [1,5,9],
    [8,3,4]],

   [[8,1,6],
    [3,5,7],
    [4,9,2]],
]

def formingMagicSquare(s):
    minCost = 10000

    for sq in squares:
        cost = 0
        for i in range(3):
            for j in range(3):
                cost += abs(s[i][j] - sq[i][j])

        minCost = min(cost, minCost)

    return minCost
