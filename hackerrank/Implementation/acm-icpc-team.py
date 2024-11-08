def acmTeam(topic):
    mx = 0
    mc = 0
    for i in range(len(topic)-1):
        for j in range(i+1, len(topic)):
            c = 0
            for v in range(len(topic[i])):
                if topic[i][v] == '1' or topic[j][v] == '1':
                    c += 1

            if c > mx:
                mx = c
                mc = 1
            elif c == mx:
                mc += 1

    return [mx, mc]
