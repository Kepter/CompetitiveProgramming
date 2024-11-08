def hurdleRace(k, height):
    mh = height[0]

    for h in height:
        mh = max(mh, h)

    return max(0, mh - k)
