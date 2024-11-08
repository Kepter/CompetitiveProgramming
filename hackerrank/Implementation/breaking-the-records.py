def breakingRecords(scores):
    maxScore = scores[0]
    minScore = scores[0]

    maxBreaks = 0
    minBreaks = 0

    for s in scores:
        if s > maxScore:
            maxScore = s
            maxBreaks += 1

        if s < minScore:
            minScore = s
            minBreaks += 1

    return [maxBreaks, minBreaks]
