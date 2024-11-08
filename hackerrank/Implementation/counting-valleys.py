def countingValleys(steps, path):
    height = 0
    valleys = 0

    for s in path:
        sheight = height

        if (s == 'U'):
            height += 1

        if (s == 'D'):
            height -= 1

        if (sheight == 0 and height == -1):
            valleys += 1

    return valleys
