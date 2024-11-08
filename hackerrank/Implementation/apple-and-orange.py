def countApplesAndOranges(s, t, a, b, apples, oranges):
    appleHits = 0
    orangeHits = 0

    for move in apples:
        land = move + a
        if (s <= land and t >= land):
            appleHits += 1

    for move in oranges:
        land = move + b
        if (s <= land and t >= land):
            orangeHits += 1

    print(str(appleHits))
    print(str(orangeHits))
