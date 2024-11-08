def hourglassSum(arr):
    ms = -10000
    for i in range(4):
        for j in range(4):
            s = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j]+ arr[i+2][j+1] + arr[i+2][j+2]
            ms = max(ms, s)

    return ms
