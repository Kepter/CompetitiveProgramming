def climbingLeaderboard(ranked, player):
    ranks = []
    rank = 1

    for i in range(len(ranked)):
        if (i > 0 and ranked[i] != ranked[i - 1]):
            rank += 1

        ranks.append(rank)

    ridx = len(ranks) - 1
    pranks = []
    for p in player:
        while(ridx >= 0 and p > ranked[ridx]):
            ridx -= 1

        if (ridx == -1):
            pranks.append(1)
        elif (p == ranked[ridx]):
            pranks.append(ranks[ridx])
        else:
            pranks.append(ranks[ridx] + 1)

    return pranks
